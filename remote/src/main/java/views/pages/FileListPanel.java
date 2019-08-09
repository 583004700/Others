package views.pages;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileListPanel extends JPanel {

    public FileListPanel(){

    }

    public static void main(String[] args) {
        String filePath = "D:\\软件备份\\开发工具\\软件\\oracle11g安装与卸载\\";
        File f = new File(filePath);
        JFrame frm = new JFrame();
        frm.setSize(300, 200);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        frm.setLayout(new FlowLayout(10,10,FlowLayout.LEADING));

        FileListPanel fileListPanel = new FileListPanel();
        frm.add(fileListPanel);
    }
}
