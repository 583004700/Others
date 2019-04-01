package demo02Layout;

import javax.swing.*;
import java.awt.*;

/**
 * 窗体默认布局是边界布局
 */
public class MyJframe3 extends JFrame {
    private JPanel jp_center = new JPanel();
    private JPanel jp_top = new JPanel();
    private JPanel jp_left = new JPanel();
    private JPanel jp_right = new JPanel();
    private JPanel jp_bottom = new JPanel();

    public MyJframe3(){
        jp_center.setBackground(Color.RED);
        jp_top.setBackground(Color.BLUE);
        jp_bottom.setBackground(Color.GREEN);
        jp_left.setBackground(Color.ORANGE);
        jp_right.setBackground(Color.YELLOW);

        this.add(jp_center,BorderLayout.CENTER);
        this.add(jp_left,BorderLayout.WEST);
        this.add(jp_right,BorderLayout.EAST);
        this.add(jp_top,BorderLayout.NORTH);
        this.add(jp_bottom,BorderLayout.SOUTH);

        JButton jb = new JButton("我是按钮");
        jp_top.add(jb);

        setSize(600,400);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyJframe3();
    }
}
