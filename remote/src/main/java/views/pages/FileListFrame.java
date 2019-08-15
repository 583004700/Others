package views.pages;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileListFrame extends JFrame{

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JTabbedPane leftTabbedPane = new JTabbedPane();
    private JTabbedPane rightTabbedPane = new JTabbedPane();

    public FileListFrame(String key){

        OperatorFileListPanel fileListPanel = new OperatorFileListPanel(System.getProperty("user.dir"));
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

        RemoteFileListPanel remoteFileListPanel = new RemoteFileListPanel(key,"根目录",this);

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
}
