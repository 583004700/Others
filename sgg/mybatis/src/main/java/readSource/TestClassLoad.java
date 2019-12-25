package readSource;


import mybatis1.helloWorld.Employee;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

class MyClassLoader extends ClassLoader
{
    public MyClassLoader()
    {

    }

    public MyClassLoader(ClassLoader parent)
    {
        super(parent);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        File file = getClassFile(name);
        try
        {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private File getClassFile(String name)
    {
        File file = new File("mybatis/target/classes/mybatis1/helloWorld/Employee.class");
        System.out.println(file.exists());
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception
    {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true)
        {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }
}

class T{
    static{
        System.out.println("静态代码块");
    }
}

public class TestClassLoad {


    public static void main(String[] args) throws Exception{
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        Class c = cl.loadClass("readSource.T");
//        System.out.println(c.getName());
//        c.newInstance();

        //Class.forName("readSource.T");
       // Class.forName("readSource.T",true,ClassLoader.getSystemClassLoader());

        MyClassLoader mcl = new MyClassLoader(null);
        Class<?> c1 = Class.forName("mybatis1.helloWorld.Employee", true, mcl);
        Object obj = c1.newInstance();
        System.out.println(mcl.getParent());
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
        //加载器不同，所以即使是相同的类，也不会返回 true
        System.out.println(obj instanceof Employee);
        System.out.println(Employee.class.getClassLoader());
    }
}
