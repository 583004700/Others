package org.springframework.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

abstract class SerializableTypeWrapper {

	private static final Class<?>[] SUPPORTED_SERIALAZABLE_TYPES = { GenericArrayType.class,
		ParameterizedType.class, TypeVariable.class, WildcardType.class };

	public static Type forField(Field field) {
		Assert.notNull(field, "Field must not be null");
		return forTypeProvider(new FieldTypeProvider(field));
	}

	public static Type forMethodParameter(MethodParameter methodParameter) {
		return forTypeProvider(new MethodParameterTypeProvider(methodParameter));
	}

	public static Type forGenericSuperclass(final Class<?> type) {
		return forTypeProvider(new DefaultTypeProvider() {

			private static final long serialVersionUID = 1L;


			@Override
			public Type getType() {
				return type.getGenericSuperclass();
			}
		});
	}

	public static Type[] forGenericInterfaces(final Class<?> type) {
		Type[] result = new Type[type.getGenericInterfaces().length];
		for (int i = 0; i < result.length; i++) {
			final int index = i;
			result[i] = forTypeProvider(new DefaultTypeProvider() {

				private static final long serialVersionUID = 1L;


				@Override
				public Type getType() {
					return type.getGenericInterfaces()[index];
				}
			});
		}
		return result;
	}

	public static Type[] forTypeParameters(final Class<?> type) {
		Type[] result = new Type[type.getTypeParameters().length];
		for (int i = 0; i < result.length; i++) {
			final int index = i;
			result[i] = forTypeProvider(new DefaultTypeProvider() {

				private static final long serialVersionUID = 1L;


				@Override
				public Type getType() {
					return type.getTypeParameters()[index];
				}
			});
		}
		return result;
	}

	static Type forTypeProvider(final TypeProvider provider) {
		Assert.notNull(provider, "Provider must not be null");
		if (provider.getType() instanceof Serializable || provider.getType() == null) {
			return provider.getType();
		}
		for (Class<?> type : SUPPORTED_SERIALAZABLE_TYPES) {
			if (type.isAssignableFrom(provider.getType().getClass())) {
				ClassLoader classLoader = provider.getClass().getClassLoader();
				Class<?>[] interfaces = new Class<?>[] { type, Serializable.class };
				InvocationHandler handler = new TypeProxyInvocationHandler(provider);
				return (Type) Proxy.newProxyInstance(classLoader, interfaces, handler);
			}
		}
		throw new IllegalArgumentException("Unsupported Type class "
				+ provider.getType().getClass().getName());
	}

	static interface TypeProvider extends Serializable {

		Type getType();

		Object getSource();

	}

	static abstract class DefaultTypeProvider implements TypeProvider {

		private static final long serialVersionUID = 1L;


		@Override
		public Object getSource() {
			return null;
		}

	}

	private static class TypeProxyInvocationHandler implements InvocationHandler,
			Serializable {

		private static final long serialVersionUID = 1L;


		private final TypeProvider provider;


		public TypeProxyInvocationHandler(TypeProvider provider) {
			this.provider = provider;
		}


		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Type.class.equals(method.getReturnType()) && args == null) {
				return forTypeProvider(new MethodInvokeTypeProvider(this.provider, method, -1));
			}
			if (Type[].class.equals(method.getReturnType()) && args == null) {
				Type[] result = new Type[((Type[]) method.invoke(this.provider.getType(), args)).length];
				for (int i = 0; i < result.length; i++) {
					result[i] = forTypeProvider(new MethodInvokeTypeProvider(this.provider, method, i));
				}
				return result;
			}
			return method.invoke(this.provider.getType(), args);
		}

	}

	static class FieldTypeProvider implements TypeProvider {

		private static final long serialVersionUID = 1L;


		private final String fieldName;

		private final Class<?> declaringClass;

		private transient Field field;


		public FieldTypeProvider(Field field) {
			this.fieldName = field.getName();
			this.declaringClass = field.getDeclaringClass();
			this.field = field;
		}


		@Override
		public Type getType() {
			return this.field.getGenericType();
		}

		@Override
		public Object getSource() {
			return this.field;
		}

		private void readObject(ObjectInputStream inputStream) throws IOException,
				ClassNotFoundException {
			inputStream.defaultReadObject();
			try {
				this.field = this.declaringClass.getDeclaredField(this.fieldName);
			}
			catch (Throwable ex) {
				throw new IllegalStateException(
						"Could not find original class structure", ex);
			}
		}

	}

	static class MethodParameterTypeProvider implements TypeProvider {

		private static final long serialVersionUID = 1L;


		private final String methodName;

		private final Class<?>[] parameterTypes;

		private final Class<?> declaringClass;

		private final int parameterIndex;

		private transient MethodParameter methodParameter;


		public MethodParameterTypeProvider(MethodParameter methodParameter) {
			if (methodParameter.getMethod() != null) {
				this.methodName = methodParameter.getMethod().getName();
				this.parameterTypes = methodParameter.getMethod().getParameterTypes();
			}
			else {
				this.methodName = null;
				this.parameterTypes = methodParameter.getConstructor().getParameterTypes();
			}
			this.declaringClass = methodParameter.getDeclaringClass();
			this.parameterIndex = methodParameter.getParameterIndex();
			this.methodParameter = methodParameter;
		}


		@Override
		public Type getType() {
			return this.methodParameter.getGenericParameterType();
		}

		@Override
		public Object getSource() {
			return this.methodParameter;
		}

		private void readObject(ObjectInputStream inputStream) throws IOException,
				ClassNotFoundException {
			inputStream.defaultReadObject();
			try {
				if (this.methodName != null) {
					this.methodParameter = new MethodParameter(
							this.declaringClass.getDeclaredMethod(this.methodName,
									this.parameterTypes), this.parameterIndex);
				}
				else {
					this.methodParameter = new MethodParameter(
							this.declaringClass.getDeclaredConstructor(this.parameterTypes),
							this.parameterIndex);
				}
			}
			catch (Throwable ex) {
				throw new IllegalStateException(
						"Could not find original class structure", ex);
			}
		}

	}

	static class MethodInvokeTypeProvider implements TypeProvider {

		private static final long serialVersionUID = 1L;


		private final TypeProvider provider;

		private final String methodName;

		private final int index;

		private transient Object result;


		public MethodInvokeTypeProvider(TypeProvider provider, Method method, int index) {
			this.provider = provider;
			this.methodName = method.getName();
			this.index = index;
			this.result = ReflectionUtils.invokeMethod(method, provider.getType());
		}


		@Override
		public Type getType() {
			if (this.result instanceof Type || this.result == null) {
				return (Type) this.result;
			}
			return ((Type[])this.result)[this.index];
		}

		@Override
		public Object getSource() {
			return null;
		}

		private void readObject(ObjectInputStream inputStream) throws IOException,
				ClassNotFoundException {
			inputStream.defaultReadObject();
			Method method = ReflectionUtils.findMethod(
					this.provider.getType().getClass(), this.methodName);
			this.result = ReflectionUtils.invokeMethod(method, this.provider.getType());
		}
	}
}
