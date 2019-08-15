package views.pages;

import handler.Handler;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CMDFrame extends JFrame {
    private JTabbedPane jTabbedPane = new JTabbedPane();

    private JMenuBar jMenuBar = new JMenuBar();

    private FileListFrame fileListFrame;

    public CMDFrame(){

        JMenu fileMenu = new JMenu("   文件   ");
        fileMenu.setSize(100,30);
        JMenuItem openMenuItem = new JMenuItem(" 打开 ");
        final JMenuItem fileCsMenuItem = new JMenuItem(" 文件传输 ");
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTabbedPane.getTabCount() == 0){
                    addPanel("未连接",new CMDPanel(CMDFrame.this));
                }
                getCurrentSelectTab().submitCommand(Handler.LIST+Handler.separator);
            }
        });
        fileCsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getCurrentSelectTab() == null || "".equals(getCurrentSelectTab().getCurrentConnectKey())) {
                    JOptionPane.showMessageDialog(CMDFrame.this, "请先选中连接!");
                }else{
                    //getCurrentSelectTab().reConnect();
                    //JOptionPane.showMessageDialog(CMDFrame.this, "打开文件传输!"+getCurrentSelectTab().getCurrentConnectKey());
                    if(fileListFrame == null) {
                        fileListFrame = new FileListFrame(getCurrentSelectTab().getCurrentConnectKey());
                    }else{
                        fileListFrame.show();
                    }
                }
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(fileCsMenuItem);
        jMenuBar.add(fileMenu);

        Container container = this.getContentPane();
        container.add(jTabbedPane);
        container.add(jMenuBar, BorderLayout.NORTH);

        setSize(1200, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 添加面板
     */
    public void addPanel(String name,CMDPanel cmdPanel){
        jTabbedPane.addTab(name,cmdPanel);
        this.jTabbedPane.setSelectedComponent(cmdPanel);
    }

    public CMDPanel getCurrentSelectTab(){
        return (CMDPanel) jTabbedPane.getSelectedComponent();
    }

    /**
     * get set
     */
    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public void setjTabbedPane(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }
}
