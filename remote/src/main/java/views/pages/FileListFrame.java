package views.pages;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileListFrame {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static JTabbedPane leftTabbedPane = new JTabbedPane();
    private static JTabbedPane rightTabbedPane = new JTabbedPane();

    public static void main(String[] args) {

        String filePath = "D:\\软件备份\\开发工具\\软件\\oracle11g安装与卸载\\";

        OperatorFileListPanel fileListPanel = new OperatorFileListPanel(filePath);
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

        rightTabbedPane.addTab("192.168.1.113",new OperatorFileListPanel(filePath));

        splitPane.setRightComponent(rightTabbedPane);

        File f = new File(filePath);
        JFrame frm = new JFrame();
        Container container = frm.getContentPane();
        container.add(splitPane);
        frm.setSize(screenSize);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        frm.setResizable(false);
    }
}
