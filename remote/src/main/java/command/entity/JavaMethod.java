package command.entity;

import util.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JavaMethod {
    public static final String currentJarPath = OtherComputer.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    public static final String jarFileName = new File(currentJarPath).getName();
    public static final String batFileName = "startremote.bat";
    public static String userHome = System.getProperty("user.home");
    public static final File parent = new File(userHome+"\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\");
    public static final File jarFile = new File(parent,jarFileName);
    public static final File batFile = new File(parent,batFileName);

    public void createFile() {
        try {
            //String currentJarPath = "\\D:\\IdeaProjects\\remote\\target\\remote-1.0-SNAPSHOT.jar";
            File currentJarFile = new File(currentJarPath);
            File currentBatFile = new File(currentJarFile.getParent(),batFileName);

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
}
