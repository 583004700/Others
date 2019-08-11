package views.pages;

import util.FileUtil;
import views.pages.common.CommonTable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FileListPanel extends JPanel {
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
                Icon icon = FileUtil.getFileSmallIcon(new File(realPath));
                jLabel.setIcon(icon);
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

    public FileListPanel(String currentPath){
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
                    String realPath = (String)fileListTable.getValueAt(row,4);
                    open(realPath);
                }
            }
        });

        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        tablePanel.add(fileListTable.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        tablePanel.add(fileListTable, BorderLayout.CENTER);
        tablePanel.setSize(screenSize.width/2,screenSize.height);

        open(currentPath);

        JScrollPane jspData = new JScrollPane(fileListTable);
        jspData.setSize(screenSize.width/2, screenSize.height);
        jspData.setLocation(0, 30);

        Icon icon = FileUtil.getFileSmallIcon(currentPathFile);
        JLabel jLabel = new JLabel(icon);
        jLabel.setSize(30,30);
        currentPathText.add(jLabel);

        currentPathText.setSize(screenSize.width/2, 30);
        currentPathText.setLocation(0,0);
        this.add(currentPathText);
        this.add(jspData);
    }

    public void loadList(){
        fileListTable.clearData();
        String parentPath = new File(currentPath).getParent();
        if(parentPath != null){
            tableModel.addRow(new String[]{"..","","","",parentPath});
        }
        File[] files = currentPathFile.listFiles();
        for(File f : files){
            String fileName = FileUtil.getName(f.getAbsolutePath());
            String fileSize = FileUtil.getFileLengthStr(f);
            String fileType = FileUtil.getType(f);
            String lastM = FileUtil.getlastModified(f);
            tableModel.addRow(new String[]{fileName,fileSize,fileType,lastM,f.getAbsolutePath()});
        }
    }

    public void open(String path){
        System.out.println("open"+path);
        File file = new File(path);
        if(!file.isDirectory()){
            return;
        }
        setCurrentPath(path);
        loadList();
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        FileListPanel.screenSize = screenSize;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    /**
     * 设置当前路径
     * @param currentPath
     */
    public void setCurrentPath(String currentPath) {
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

    public static void main(String[] args) {

        String filePath = "D:\\软件备份\\开发工具\\软件\\oracle11g安装与卸载\\";


        FileListPanel fileListPanel = new FileListPanel(filePath);
        fileListPanel.setSize(screenSize.width/2,screenSize.height);

        JSplitPane splitPane = new JSplitPane();
        // 分隔条上显示快速 折叠/展开 两边组件的小按钮
        splitPane.setOneTouchExpandable(true);
        // 拖动分隔条时连续重绘组件
        splitPane.setContinuousLayout(true);
        // 设置分隔条的初始位置
        splitPane.setDividerLocation(screenSize.width/2);

        splitPane.setLeftComponent(fileListPanel);
        splitPane.setRightComponent(new FileListPanel(filePath));


        File f = new File(filePath);
        JFrame frm = new JFrame();
        Container container = frm.getContentPane();
        container.add(splitPane);
        frm.setSize(screenSize);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        frm.setResizable(false);
    }
}
