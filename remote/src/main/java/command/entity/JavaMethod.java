package command.entity;

import util.OSUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaMethod {
    //截图默认保存的路径
    public static final String pFilePath = OSUtil.isLinux() ? "/remotefile/png/" : "D:\\remotefile\\png\\";

    private final String separator = ">";

    //java:command.entity.JavaMethod.screenPrint(null,null)
    public String screenPrint(String filePath,String fileName){
        System.out.println("filePath:"+filePath);
        System.out.println("fileName:"+fileName);
        if("null".equals(filePath)){
            filePath = pFilePath;
        }
        if("null".equals(fileName)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
            fileName = sdf.format(new Date());
        }
        File f = null;
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            File screenFilePath = new File(filePath);
            if (!screenFilePath.exists()) {
                screenFilePath.mkdirs();
            }
            f = new File(filePath, fileName+".png");
            System.out.println("图片保存路径："+f.getAbsolutePath());
            ImageIO.write(image, "png", f);
            return "success"+separator+f.getAbsolutePath();
        }catch (Exception e){
            e.printStackTrace();
            return "fail"+separator+f.getAbsolutePath();
        }
    }

    public String screenPrintUp(String filePath,String fileName){
        return screenPrint(filePath,fileName);
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
