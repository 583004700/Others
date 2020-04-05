package views.pages;

import lombok.Getter;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

@Getter
public class ScreenFrame extends JFrame{

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private String key;
    private ScreenPanel screenPanel;
    private CMDFrame cmdFrame;

    public ScreenFrame(String key,CMDFrame cmdFrame){
        this.cmdFrame = cmdFrame;
        this.key = key;
        screenPanel = new ScreenPanel(key,this);
        screenPanel.setKey(this.key);
        this.add(screenPanel);

        this.setSize(screenSize.width,screenSize.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void stopRemoteFileT(){
        screenPanel.exitT();
    }
}
