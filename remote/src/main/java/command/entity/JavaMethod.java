package command.entity;

import util.OSUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaMethod {

    //java:command.entity.JavaMethod.screenPrint(null,null)
    public boolean screenPrint(String filePath,String fileName){
        System.out.println("filePath:"+filePath);
        System.out.println("fileName:"+fileName);
        if("null".equals(filePath)){
            if(OSUtil.isLinux()){
                filePath = "/remotefile/png/";
            }else {
                filePath = "D:\\remotefile\\png\\";
            }
        }
        if("null".equals(fileName)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
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

    //java:command.entity.JavaMethod.screenPrintFor(null,null)
    public void screenPrintFor(String count,String d) throws Exception{
        if("null".equals(count)){
            count = "50";
        }
        if("null".equals(d)){
            d = "100";
        }
        int de = Integer.parseInt(d);
        int c = Integer.parseInt(count);
        for (int i = 0; i < c; i++) {
            screenPrint("null","null");
            Thread.sleep(de);
        }
    }
}
