package views.pages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddNetFrame extends JFrame {
    private CMDPanel cmdPanel;
    public AddNetFrame(final CMDPanel cmdPanel){
        this.cmdPanel = cmdPanel;
        this.setSize(250,150);
        this.setLocationRelativeTo(null);

        final JTextField serverText = new JTextField(20);
        final JTextField portText = new JTextField(20);
        JPanel panel = new JPanel();

        panel.add(new JLabel("Server"));
        panel.add(serverText);
        panel.add(new JLabel("Port"));
        panel.add(portText);

        this.add(panel);
        this.setResizable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int value = JOptionPane.showConfirmDialog(null, "确定要关闭吗并添加吗？");
                if (value == JOptionPane.OK_OPTION) {
                    String server = serverText.getText();
                    String port = portText.getText();
                    AddNetFrame.this.cmdPanel.submitCommand("java:command.entity.JavaMethod.addNet("+server+","+port+")");
                    AddNetFrame.this.dispose();
                }
            }
        });
    }
}
