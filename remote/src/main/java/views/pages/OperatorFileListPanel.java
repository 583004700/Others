package views.pages;

import util.FileUtil;
import views.pages.common.CommonTable;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class OperatorFileListPanel extends JPanel {
    class CellRenderer extends DefaultTableCellRenderer{
        JLabel jLabel = new JLabel();
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(column != 0){
                jLabel.setText(value == null ? "" : (String)value);
                return jLabel;
            }else{
                JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String realPath = (String)table.getValueAt(row,4);
                try {
                    Icon icon = FileUtil.getFileSmallIcon(new File(realPath));
                    jLabel.setIcon(icon);
                }catch (Exception e){

                }
                return jLabel;
            }
        }
    }

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private String currentPath;
    private File currentPathFile;
    private final CommonTable fileListTable;
    private DefaultTableModel tableModel;
    private JTextField currentPathText = new JTextField();
    //右键菜单
    private JPopupMenu jPopupMenu = new JPopupMenu();
    private JMenuItem cs = new JMenuItem("传输");
    private JMenuItem sx = new JMenuItem("刷新");
    private JMenuItem sc = new JMenuItem("删除");

    public OperatorFileListPanel(final String currentPath){
        this.setLayout(null);

        // 创建内容面板，使用边界布局
        JPanel tablePanel = new JPanel(new BorderLayout());
        // 表头（列名）
        Object[] columnNames = {"名称","大小","类型","修改时间","真实路径"};
        tableModel = new DefaultTableModel(new Object[][]{},columnNames);
        // 创建一个表格，指定 所有行数据 和 表头
        fileListTable = new CommonTable(tableModel){
            public boolean isCellEditable(int row ,int column){
                return false;
            }
        };
        fileListTable.setDefaultRenderer(Object.class,this.new CellRenderer());
        fileListTable.setPreferredWidth(0,350);
        fileListTable.setPreferredWidth(3,160);
        fileListTable.hideColumn(4);
        fileListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int row = fileListTable.getSelectedRow();
                    if(row != -1) {
                        String realPath = (String) fileListTable.getValueAt(row, 4);
                        open(realPath);
                    }
                }
                if (e.getButton()==MouseEvent.BUTTON3) {
                    int row = fileListTable.getSelectedRow();
                    if(row != -1) {
                        String fileType = (String) fileListTable.getValueAt(row, 2);
                        if("文件".equals(fileType)) {
                            jPopupMenu.add(cs);
                        }else{
                            jPopupMenu.remove(cs);
                        }
                        String fileName = (String) fileListTable.getValueAt(row, 0);
                        if(!OperatorFileListPanel.this.currentPath.contains("根目录") && !"..".equals(fileName)) {
                            jPopupMenu.add(sc);
                        }else{
                            jPopupMenu.remove(sc);
                        }
                    }else{
                        jPopupMenu.remove(sc);
                        jPopupMenu.remove(cs);
                    }
                    jPopupMenu.show(fileListTable, e.getX(), e.getY());
                }
            }
        });

        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        tablePanel.add(fileListTable.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        tablePanel.add(fileListTable, BorderLayout.CENTER);
        tablePanel.setSize(screenSize.width/2,screenSize.height - 212);

        open(currentPath);

        JScrollPane jspData = new JScrollPane(fileListTable);
        jspData.setSize(screenSize.width/2-10, screenSize.height - 212);
        jspData.setLocation(0, 30);

        Icon icon = FileUtil.getFileSmallIcon(currentPathFile);
        JLabel jLabel = new JLabel(icon);
        jLabel.setSize(30,30);
        currentPathText.add(jLabel);

        currentPathText.setSize(screenSize.width/2, 30);
        currentPathText.setLocation(0,0);
        this.add(currentPathText);
        this.add(jspData);

        sx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open(OperatorFileListPanel.this.currentPath);
            }
        });

        sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int o = JOptionPane.showConfirmDialog(OperatorFileListPanel.this,"您确定要删除吗?","文件删除",JOptionPane.YES_NO_CANCEL_OPTION);
                if(o == JOptionPane.YES_OPTION) {
                    int row = fileListTable.getSelectedRow();
                    String realPath = (String) fileListTable.getValueAt(row, 4);
                    File deleteFile = new File(realPath);
                    boolean b = FileUtil.deleteFiles(deleteFile);
                    if(b){
                        JOptionPane.showMessageDialog(OperatorFileListPanel.this,"删除成功！");
                    }else{
                        JOptionPane.showMessageDialog(OperatorFileListPanel.this,"删除失败！");
                    }
                    open(OperatorFileListPanel.this.currentPath);
                }
            }
        });

        jPopupMenu.add(sx);
        this.add(jPopupMenu);
    }

    public void loadList(){
        fileListTable.clearData();
        String parentPath = new File(currentPath).getParent();
        if(!currentPath.contains("根目录")){
            tableModel.addRow(new String[]{"..","","文件夹","",parentPath});
        }
        File[] files = FileUtil.getFileList(currentPathFile);
        for(File f : files){
            String fileName = FileUtil.getName(f.getAbsolutePath());
            String fileType = FileUtil.getType(f);
            if(fileName == null || fileName.equals("")){
                fileName = f.getAbsolutePath();
                fileType = "文件夹";
            }
            String fileSize = FileUtil.getFileLengthStr(f);
            String lastM = FileUtil.getlastModified(f);
            tableModel.addRow(new String[]{fileName,fileSize,fileType,lastM,f.getAbsolutePath()});
        }
    }

    public void open(String path){
        System.out.println("open"+path);
        if(path != null) {
            File file = new File(path);
            if (!file.isDirectory()) {
                return;
            }
        }
        setCurrentPath(path);
        loadList();
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        OperatorFileListPanel.screenSize = screenSize;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    /**
     * 设置当前路径
     * @param currentPath
     */
    public void setCurrentPath(String currentPath) {
        if(currentPath == null){
            currentPath = "根目录";
        }
        this.currentPath = currentPath;
        this.currentPathFile = new File(currentPath);
        this.currentPathText.setText("          "+currentPath);
    }

    public File getCurrentPathFile() {
        return currentPathFile;
    }

    public void setCurrentPathFile(File currentPathFile) {
        this.currentPathFile = currentPathFile;
    }

    public CommonTable getFileListTable() {
        return fileListTable;
    }

    public JTextField getCurrentPathText() {
        return currentPathText;
    }

    public void setCurrentPathText(JTextField currentPathText) {
        this.currentPathText = currentPathText;
    }
}
