package readSource;

import org.apache.ibatis.cache.CacheException;
import org.apache.ibatis.cache.decorators.SerializedCache;
import org.apache.ibatis.io.Resources;

import java.io.*;

class CustomObjectInputStream extends ObjectInputStream {

    public CustomObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        return Resources.classForName(desc.getName());
    }

}

public class TestObjectInputStream implements Serializable{
    public static class CustomObjectInputStream extends ObjectInputStream {

        public CustomObjectInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            return TestObjectInputStream.class;
        }

    }

    public static byte[] serialize(Serializable value) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.close();
            oos.flush();
            return bos.toByteArray();
        } catch (Exception e) {
            throw new CacheException("Error serializing object.  Cause: " + e, e);
        }
    }

    public static Serializable deserialize(byte[] value) {
        Serializable result;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(value);
            ObjectInputStream ois = new TestObjectInputStream.CustomObjectInputStream(bis);
            result = (Serializable) ois.readObject();
            ois.close();
        } catch (Exception e) {
            throw new CacheException("Error deserializing object.  Cause: " + e, e);
        }
        return result;
    }

    public static void main(String[] args) {
        Serializable obj = TestObjectInputStream.deserialize(TestObjectInputStream.serialize(new TestObjectInputStream()));
        System.out.println(obj);
    }
}
