package demo02Layout;

import javax.swing.*;

/**
 * 默认布局从左到右，从上到下，居中
 */
public class MyJframe1 extends JFrame {
    private JPanel jp = new JPanel();

    public MyJframe1(){
        //设置按钮没有布局
        jp.setLayout(null);
//        for(int i=0;i<12;i++){
//            JButton bt = new JButton("按钮"+i);
//            jp.add(bt);
//        }

        //没有布局时才生效
//        JButton bt = new JButton("我是按钮");
//        bt.setBounds(100,100,300,100);
//        jp.add(bt);


        add(jp);
        setSize(600,400);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyJframe1();
    }
}
