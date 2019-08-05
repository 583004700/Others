package views.pages;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Container;

public class CMDFrame extends JFrame {
    private JTabbedPane jTabbedPane = new JTabbedPane();

    private JMenuBar jMenuBar = new JMenuBar();

    public CMDFrame(){

        JMenu fileMenu = new JMenu("   文件   ");
        fileMenu.setSize(100,30);
        JMenuItem openMenuItem = new JMenuItem(" 打开 ");
        fileMenu.add(openMenuItem);
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
