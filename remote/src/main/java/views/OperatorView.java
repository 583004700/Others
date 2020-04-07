package views;

import command.entity.Operator;
import views.pages.CMDFrame;

import javax.swing.*;

/**
 * cmd常用命令
 * dir 展示目录
 * del d:a.txt 删除文件
 * msg %username% /time:10 "要显示的内容" 弹出窗口
 * shutdown /s 关机，有30秒提示
 * shutdown /s /t 300 300秒后
 * shutdown /s /t 300 /c "注释"
 */

//C:\Users\pan\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup
//C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup

public class OperatorView extends Operator{

    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");  //还可以
            //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); //灰黑
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");//不好看
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"); //不好看
//            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");//不好看，黄亮
//            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel"); //灰
//            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); //很难看
//            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");    //太黑了
//            UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");  //还可以
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");    //mac风格
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");    //还可以
//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");    //很黑，需要设置字体为其它颜色
//            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");    //一般

        }catch (Exception e){
            e.printStackTrace();
        }
        CMDFrame cmdFrame = new CMDFrame();
    }

}
