package views.pages;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenFrame extends JFrame{

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private String key;
    private ScreenPanel screenPanel;

    public ScreenFrame(String key){
        this.key = key;
        screenPanel = new ScreenPanel(key,this);
        this.add(screenPanel);

        this.setSize((int)(screenSize.width*0.8),(int)(screenSize.height*0.8));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void stopRemoteFileT(){
        this.screenPanel.stop();
    }
}
