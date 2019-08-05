package views.pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 选择会话窗口
 */
public class OpenSessionFrame extends JFrame {
    private JButton connectButton = new JButton("连接");
    private JButton closeButton = new JButton("关闭");

    public OpenSessionFrame(){
        connectButton.setSize(96,28);
        connectButton.setLocation(414,334);
        closeButton.setSize(96,28);
        closeButton.setLocation(520,334);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenSessionFrame.this.dispose();
            }
        });

        Container container = getContentPane();
        container.setLayout(null);
        container.add(connectButton);
        container.add(closeButton);

        setResizable(false);
        setSize(648, 421);
        setLocationRelativeTo(null);
        setTitle("会话");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OpenSessionFrame();
    }
}
