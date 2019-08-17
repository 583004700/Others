package views.pages;

import handler.Handler;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

public class FileListFrame extends JFrame{

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JTabbedPane leftTabbedPane = new JTabbedPane();
    private JTabbedPane rightTabbedPane = new JTabbedPane();
    private String key;

    public FileListFrame(String key){
        this.key = key;

        OperatorFileListPanel fileListPanel = new OperatorFileListPanel(System.getProperty("user.dir"),this);
        fileListPanel.setSize(screenSize.width/2,screenSize.height);

        JSplitPane splitPane = new JSplitPane();
        // 分隔条上显示快速 折叠/展开 两边组件的小按钮
        splitPane.setOneTouchExpandable(true);
        // 拖动分隔条时连续重绘组件
        splitPane.setContinuousLayout(true);
        // 设置分隔条的初始位置
        splitPane.setDividerLocation(screenSize.width/2);

        leftTabbedPane.addTab("我的电脑",fileListPanel);

        splitPane.setLeftComponent(leftTabbedPane);

        RemoteFileListPanel remoteFileListPanel = new RemoteFileListPanel(key, Handler.root,this);

        splitPane.setRightComponent(rightTabbedPane);

        Container container = this.getContentPane();
        container.add(splitPane);

        this.setSize(screenSize);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Dimension screenSize) {
        this.screenSize = screenSize;
    }

    public JTabbedPane getLeftTabbedPane() {
        return leftTabbedPane;
    }

    public void setLeftTabbedPane(JTabbedPane leftTabbedPane) {
        this.leftTabbedPane = leftTabbedPane;
    }

    public JTabbedPane getRightTabbedPane() {
        return rightTabbedPane;
    }

    public void setRightTabbedPane(JTabbedPane rightTabbedPane) {
        this.rightTabbedPane = rightTabbedPane;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
