package zhongji.a18.io;


import java.io.*;

public class TestIo implements Serializable{

    public static byte[] encode(Serializable serializable) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static Object decode(byte[] bytes) throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        objectInputStream.close();
        return objectInputStream.readObject();
    }

    public static void main(String[] args) {

    }
}
