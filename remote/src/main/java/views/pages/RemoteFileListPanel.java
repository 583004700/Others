package views.pages;

import com.alibaba.fastjson.JSON;
import command.PropertiesConst;
import command.entity.FileItem;
import command.entity.Operator;
import handler.Handler;
import thread.ThreadManager;
import util.FileUtil;
import util.IOUtil;
import views.pages.common.CommonTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.List;

public class RemoteFileListPanel extends Operator implements Runnable {
    class CellRenderer extends DefaultTableCellRenderer{
        JLabel jLabel = new JLabel();
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(column != 0){
                jLabel.setText(value == null ? "" : (String)value);
                return jLabel;
            }else{
                JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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
    private FileListFrame fileListFrame;
    private String key;
    private String parentPath = "";

    public RemoteFileListPanel(String key,final String currentPath,FileListFrame fileListFrame){
        this.key = key;
        this.submitCommand(Handler.OPERATE+Handler.separator+key+"FT:");
        this.fileListFrame = fileListFrame;
        this.fileListFrame.getRightTabbedPane().addTab(key,this);
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
                        String fileType = (String) fileListTable.getValueAt(row,2);
                        if("文件夹".equals(fileType)) {
                            open(realPath);
                        }
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
                        if(!RemoteFileListPanel.this.currentPath.contains("根目录") && !"..".equals(fileName)) {
                            jPopupMenu.add(sc);
                        }else{
                            jPopupMenu.remove(sc);
                        }
                    }else{
                        jPopupMenu.remove(sc);
                        jPopupMenu.remove(cs);
                    }
                    jPopupMenu.show(RemoteFileListPanel.this, e.getX()+5, e.getY()+60);
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

        //Icon icon = FileUtil.getFileSmallIcon(currentPathFile);
        JLabel jLabel = new JLabel();
        jLabel.setSize(30,30);
        currentPathText.add(jLabel);

        currentPathText.setSize(screenSize.width/2, 30);
        currentPathText.setLocation(0,0);
        this.add(currentPathText);
        this.add(jspData);

        sx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open(RemoteFileListPanel.this.currentPath);
            }
        });

        sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int o = JOptionPane.showConfirmDialog(RemoteFileListPanel.this,"您确定要删除吗?","文件删除",JOptionPane.YES_NO_CANCEL_OPTION);
                if(o == JOptionPane.YES_OPTION) {
                    int row = fileListTable.getSelectedRow();
                    String realPath = (String) fileListTable.getValueAt(row, 4);
                    File deleteFile = new File(realPath);
                    boolean b = FileUtil.deleteFiles(deleteFile);
                    if(b){
                        JOptionPane.showMessageDialog(RemoteFileListPanel.this,"删除成功！");
                    }else{
                        JOptionPane.showMessageDialog(RemoteFileListPanel.this,"删除失败！");
                    }
                    open(RemoteFileListPanel.this.currentPath);
                }
            }
        });

        jPopupMenu.add(sx);
        this.add(jPopupMenu);
    }

    public void loadList(List<FileItem> files){
        fileListTable.clearData();
        String parentPath = new File(currentPath).getParent();
        if(!currentPath.contains("根目录")){
            System.out.println("父目录"+parentPath);
            tableModel.addRow(new String[]{"..","","文件夹","",parentPath});
        }
        for(FileItem f : files){
            String fileName = f.getFileName();
            String fileSize = f.getFileSize();
            String fileType = f.getFileType();
            String lastM = f.getLastM();
            tableModel.addRow(new String[]{fileName,fileSize,fileType,lastM,f.getRealPath()});
        }
    }

    public void open(String path){
        System.out.println("open"+path);
        if(path == null) {
            path = "根目录";
        }
        setCurrentPath(path);
        System.out.println("提交"+currentPath);
        submitCommand("java:command.entity.JavaMethod.getFileList("+currentPath+")");
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        RemoteFileListPanel.screenSize = screenSize;
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








    public void connect(){
        super.connect();
        try {
            ThreadManager.getExecutorService().execute(this);
            Thread.sleep(100);

            //submitCommand(Handler.LIST+Handler.separator);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(), PropertiesConst.appEncoding);
        while(true){
            String result = null;
            try {
                result = br.readLine();
                if(result!=null && result.contains(Handler.receiveSuccess)){
                    //如果成功接收到文件
                }else if(result!=null && result.contains("已连接:")){
                    this.setName(result);
                    changeCurrentTabTitle(result);
                }else if(result.startsWith(Handler.getFileList)){
                    //获取到文件列表
                    String[] resultStr = result.split(">");
                    boolean success = "success".equals(resultStr[2]);
                    if(success){
                        String listStr = resultStr[3];
                        List<FileItem> fileItems = JSON.parseArray(listStr,FileItem.class);
                        loadList(fileItems);
                        System.out.println(listStr);
                    }else{
                        JOptionPane.showMessageDialog(RemoteFileListPanel.this,"获取文件列表失败");
                    }
                }
            }catch (SocketTimeoutException s){
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result == null){
                this.setName("未连接");
                changeCurrentTabTitle("未连接");
                key = "";
                break;
            }
        }
    }

    public void changeCurrentTabTitle(String title){
        this.fileListFrame.getRightTabbedPane().setTitleAt(this.fileListFrame.getRightTabbedPane().getSelectedIndex(),title);
    }
}
