package views.pages;

import handler.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 选择会话窗口
 */
public class OpenSessionFrame extends JFrame {
    private CMDPanel cmdPanel;
    private JButton connectButton = new JButton("连接");
    private JButton closeButton = new JButton("关闭");

    public OpenSessionFrame(CMDPanel panel,String tableData){
        this.cmdPanel = panel;

        // 创建内容面板，使用边界布局
        JPanel tablePanel = new JPanel(new BorderLayout());

        // 表头（列名）
        Object[] columnNames = {"可连接"};

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{},columnNames);

        // 创建一个表格，指定 所有行数据 和 表头
        final JTable table = new JTable(tableModel){
            public boolean isCellEditable(int row ,int column){
                return false;
            }
        };

        String[] l = tableData.split(",");

        for(String key : l){
            if(!cmdPanel.ylj.containsKey(key)){
                tableModel.addRow(new String[]{key});
            }
        }

        connectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(OpenSessionFrame.this,"请先选中连接!");
                    return;
                }
                String selectKey = (String)table.getValueAt(row,0);
                if("".equals(cmdPanel.getCurrentConnectKey())) {
                    cmdPanel.submitCommand(Handler.OPERATE + Handler.separator + selectKey);
                }else{
                    CMDPanel newCmdPanel = new CMDPanel(cmdPanel.getCmdFrame());
                    newCmdPanel.getCmdFrame().addPanel("未连接",newCmdPanel);
                    newCmdPanel.submitCommand(Handler.OPERATE + Handler.separator + selectKey);
                }
                closeButton.doClick();
            }
        });

        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        tablePanel.add(table, BorderLayout.CENTER);

        JScrollPane jspData = new JScrollPane(table);

        jspData.setSize(642, 320);
        jspData.setLocation(0, 0);

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

        container.add(jspData);

        setResizable(false);
        setSize(648, 421);
        setLocationRelativeTo(null);
        setTitle("会话");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
