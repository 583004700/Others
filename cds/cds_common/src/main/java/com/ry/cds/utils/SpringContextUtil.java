package com.ry.cds.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Spring 获取 Bean的工具类
 * @author 幸仁强
 * @createtime 2018-2-12
 */
@Component
public class SpringContextUtil implements BeanFactoryAware {
	private static BeanFactory beanFactory = null;

	private static SpringContextUtil servlocator = null;

	@SuppressWarnings("static-access")
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.beanFactory = factory;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	@Bean(name = "serviceLocator")
	public SpringContextUtil springContextUtil() {
		return new SpringContextUtil();
	}

	public static SpringContextUtil getInstance() {
		if (servlocator == null) {
			servlocator = (SpringContextUtil) beanFactory.getBean("serviceLocator");
		}
		return servlocator;
	}

	/**
	 * 根据提供的bean名称得到相应的服务类
	 * 
	 * @param servName bean名称
	 * @return
	 */
	public static Object getBean(String servName) {
		return beanFactory.getBean(servName);
	}

	/**
	 * 根据提供的bean名称得到对应于指定类型的服务类
	 * @param servName bean名称
	 * @param clazz 返回的bean类型，若类型不匹配，抛出异常
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Object getBean(String servName, Class clazz) {
		return beanFactory.getBean(servName, clazz);
	}

}
