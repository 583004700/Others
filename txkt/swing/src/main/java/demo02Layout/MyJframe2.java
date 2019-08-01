package demo02Layout;

import javax.swing.*;
import java.awt.*;

/**
 * 默认布局从左到右，从上到下，居中
 */
public class MyJframe2 extends JFrame {
    private JPanel jp = new JPanel();

    public MyJframe2(){
//        GridLayout gl = new GridLayout(3,4);
        GridLayout gl = new GridLayout(3,4,50,100);
        jp.setLayout(gl);

        //网格布局超过数量，则增加列
        for(int i=0;i<14;i++){
            JButton bt = new JButton("按钮"+i);
            jp.add(bt);
        }

        add(jp);
        setSize(600,400);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyJframe2();
    }
}
