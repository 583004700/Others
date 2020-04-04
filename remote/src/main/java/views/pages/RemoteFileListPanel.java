package views.pages;

import com.alibaba.fastjson.JSON;
import command.PropertiesConst;
import command.entity.FileItem;
import command.entity.Operator;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;
import views.pages.common.CommonTable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;

public class RemoteFileListPanel extends Operator implements Runnable {
    class CellRenderer extends DefaultTableCellRenderer {
        JLabel jLabel = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column != 0) {
                jLabel.setText(value == null ? "" : (String) value);
                return jLabel;
            } else {
                JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String fileType = (String) table.getValueAt(row, 2);
                if ("文件夹".equals(fileType)) {
                    jLabel.setIcon(dIcon);
                } else {
                    jLabel.setIcon(fIcon);
                }
                return jLabel;
            }
        }
    }

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Image img = null;
    public static Icon dIcon = null;
    public static Image fImg = null;
    public static Icon fIcon = null;

    static {
        try {
            URL url = RemoteFileListPanel.class.getResource("/d.png");
            img = Toolkit.getDefaultToolkit().createImage(url);
            dIcon = new ImageIcon(img);

            URL furl = RemoteFileListPanel.class.getResource("/f.png");
            fImg = Toolkit.getDefaultToolkit().createImage(furl);
            fIcon = new ImageIcon(fImg);
//            JLabel j = new JLabel();
//            ImageIcon i = (ImageIcon) FileUtil.getFileSmallIcon(new File("D:\\IdeaProjects\\remote\\remote.iml"));
//            j.setIcon(i);
//            j.setSize(i.getIconWidth(), i.getIconHeight());
//            BufferedImage img = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
//            Graphics2D g2d = img.createGraphics();
//            j.printAll(g2d);
//            g2d.dispose();
//            ImageIO.write(img, "png", new File("d:/remotefile/f.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    //当前点击传输的文件路径
    private String currentTrans;
    private volatile boolean started;

    public RemoteFileListPanel(String key, final String currentPath, FileListFrame fileListFrame) {
        this.key = key;
        this.submitCommand(Handler.OPERATE + Handler.separator + key + "FT:");
        this.fileListFrame = fileListFrame;
        this.fileListFrame.getRightTabbedPane().addTab(key, this);
        this.setLayout(null);

        // 创建内容面板，使用边界布局
        JPanel tablePanel = new JPanel(new BorderLayout());
        // 表头（列名）
        Object[] columnNames = {"名称", "大小", "类型", "修改时间", "真实路径"};
        tableModel = new DefaultTableModel(new Object[][]{}, columnNames);
        // 创建一个表格，指定 所有行数据 和 表头
        fileListTable = new CommonTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        fileListTable.setDefaultRenderer(Object.class, this.new CellRenderer());
        fileListTable.setPreferredWidth(0, 350);
        fileListTable.setPreferredWidth(3, 160);
        fileListTable.hideColumn(4);
        fileListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = fileListTable.getSelectedRow();
                    if (row != -1) {
                        String realPath = (String) fileListTable.getValueAt(row, 4);
                        String fileType = (String) fileListTable.getValueAt(row, 2);
                        //if ("文件夹".equals(fileType)) {
                            open(realPath);
                        //}
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int row = fileListTable.getSelectedRow();
                    if (row != -1) {
                        String fileType = (String) fileListTable.getValueAt(row, 2);
                        if ("文件".equals(fileType)) {
                            jPopupMenu.add(cs);
                        } else {
                            jPopupMenu.remove(cs);
                        }
                        String fileName = (String) fileListTable.getValueAt(row, 0);
                        if (!RemoteFileListPanel.this.currentPath.contains(Handler.root) && !"..".equals(fileName)) {
                            jPopupMenu.add(sc);
                        } else {
                            jPopupMenu.remove(sc);
                        }
                    } else {
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
        tablePanel.setSize(screenSize.width / 2, screenSize.height - 20);

        open(currentPath);

        JScrollPane jspData = new JScrollPane(fileListTable);
        jspData.setSize(screenSize.width / 2 - 10, screenSize.height - 200);
        jspData.setLocation(0, 30);

        Icon icon = dIcon;
        JLabel jLabel = new JLabel(icon);
        jLabel.setSize(30, 30);

        currentPathText.setSize(screenSize.width / 2, 30);
        currentPathText.setLocation(30, 0);
        this.add(jLabel);
        this.add(currentPathText);
        this.add(jspData);

        currentPathText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    open(currentPathText.getText());
                }
            }
        });

        sx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!RemoteFileListPanel.this.getConnected()) {
                    RemoteFileListPanel.this.submitCommand(Handler.OPERATE + Handler.separator + RemoteFileListPanel.this.key + "FT:");
                } else {
                    open(RemoteFileListPanel.this.currentPath);
                }
            }
        });

        sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int o = JOptionPane.showConfirmDialog(RemoteFileListPanel.this, "您确定要删除吗?", "文件删除", JOptionPane.YES_NO_CANCEL_OPTION);
                if (o == JOptionPane.YES_OPTION) {
                    int row = fileListTable.getSelectedRow();
                    String realPath = (String) fileListTable.getValueAt(row, 4);
                    submitCommand("java:command.entity.JavaMethod.deleteFiles(" + realPath + ")");
                }
            }
        });

        //传输
        cs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = fileListTable.getSelectedRow();
                if (row != -1) {
                    String realPath = (String) fileListTable.getValueAt(row, 4);
                    RemoteFileListPanel.this.currentTrans = realPath;
                    RemoteFileListPanel.this.fileDown();
                }
            }
        });

        jPopupMenu.add(sx);
        this.add(jPopupMenu);
    }

    @Override
    public void init() {
        started = true;
    }

    public void reConnect() {
        closeConnection();
        connect();
    }

    public void loadList(List<FileItem> files) {
        fileListTable.clearData();
        String parentPath = new File(currentPath).getParent();
        if (parentPath != null) {
            parentPath = parentPath.replaceAll("\\\\", "/");
        }
        if (!currentPath.contains(Handler.root)) {
            tableModel.addRow(new String[]{"..", "", "文件夹", "", parentPath});
        }
        for (FileItem f : files) {
            String fileName = f.getFileName();
            String fileSize = f.getFileSize();
            String fileType = f.getFileType();
            String lastM = f.getLastM();
            tableModel.addRow(new String[]{fileName, fileSize, fileType, lastM, f.getRealPath()});
        }
    }

    public void open(String path) {
        if (!this.getConnected()) {
            submitCommand(Handler.OPERATE + Handler.separator + RemoteFileListPanel.this.key + "FT:");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("open" + path);
        if (path == null) {
            path = Handler.root;
        }
        setCurrentPath(path);
        submitCommand("java:command.entity.JavaMethod.getFileList(" + currentPath + ")");
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
     *
     * @param currentPath
     */
    public void setCurrentPath(String currentPath) {
        if (currentPath == null) {
            currentPath = Handler.root;
        }
        this.currentPath = currentPath;
        this.currentPathFile = new File(currentPath);
        this.currentPathText.setText(currentPath);
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


    public void connect() {
        super.connect();
        try {
            ThreadManager.getExecutorService().execute(this);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件下载
     */
    public boolean fileDown() {
        boolean b = false;
        if (currentTrans != null) {
            OperatorFileListPanel operatorFileListPanel = (OperatorFileListPanel) fileListFrame.getLeftTabbedPane().getSelectedComponent();
            String downPath = operatorFileListPanel.getCurrentPath();
            downPath = downPath.endsWith("/") || downPath.endsWith("\\") ? downPath : downPath + "/";
            String upPath = this.currentTrans;
            //JOptionPane.showMessageDialog(RemoteFileListPanel.this,"downPath"+downPath);
            //JOptionPane.showMessageDialog(RemoteFileListPanel.this,"upPath"+upPath);
            if (!Handler.root.equals(downPath)) {
                this.submitCommand(Handler.DOWNFILE + Handler.separator + upPath + ">" + downPath);
                b = true;
            } else {
                JOptionPane.showMessageDialog(RemoteFileListPanel.this, "不能选择根目录");
            }
            currentTrans = null;
        }
        return b;
    }

    public boolean fileUp() {
        boolean b = false;
        OperatorFileListPanel operatorFileListPanel = (OperatorFileListPanel) fileListFrame.getLeftTabbedPane().getSelectedComponent();
        if (operatorFileListPanel.getCurrentTrans() != null) {
            String downPath = this.getCurrentPath();
            downPath = downPath.endsWith("/") || downPath.endsWith("\\") ? downPath : downPath + "/";
            String upPath = operatorFileListPanel.getCurrentTrans();
            //JOptionPane.showMessageDialog(RemoteFileListPanel.this,"downPath"+downPath);
            //JOptionPane.showMessageDialog(RemoteFileListPanel.this,"upPath"+upPath);
            if (!downPath.contains(Handler.root)) {
                this.submitCommand(Handler.UPFILE + Handler.separator + upPath + ">" + downPath);
                b = true;
            } else {
                JOptionPane.showMessageDialog(RemoteFileListPanel.this, "不能选择根目录");
            }
            operatorFileListPanel.setCurrentTrans(null);
        }
        return b;
    }

    @Override
    public void printMessage(String message) {
        if (message.contains("文件下载结束")) {
            JOptionPane.showMessageDialog(RemoteFileListPanel.this, message);
            OperatorFileListPanel operatorFileListPanel = (OperatorFileListPanel) fileListFrame.getLeftTabbedPane().getSelectedComponent();
            operatorFileListPanel.flushList();
        } else {
            System.out.println(message);
        }
    }

    public void flushList() {
        this.open(this.currentPath);
    }

    public void stop(){
        started = false;
        closeConnection();
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(), PropertiesConst.appEncoding);
        while (started) {
            String result = null;
            try {
                result = br.readLine();
                System.out.println("result:" + result);
                if (result != null) {
                    if (result.contains(Handler.receiveSuccess)) {
                        //如果成功接收到文件
                        String upPath = result.replaceAll(Handler.separator + Handler.receiveSuccess, "");
                        JOptionPane.showMessageDialog(RemoteFileListPanel.this, "文件成功上传到" + upPath);
                        flushList();
                    } else if (result.contains("已连接:")) {
                        this.setConnected(true);
                        this.setName(result);
                        changeCurrentTabTitle(result);
                    } else if (result.startsWith(Handler.getFileList)) {
                        //获取到文件列表
                        String[] resultStr = result.split(">");
                        boolean success = "success".equals(resultStr[2]);
                        if (success) {
                            String listStr = resultStr[3];
                            if("".equals(listStr)){
                                this.printMessage("打开文件");
                            }else {
                                List<FileItem> fileItems = JSON.parseArray(listStr, FileItem.class);
                                loadList(fileItems);
                                System.out.println(listStr);
                            }
                        } else {
                            JOptionPane.showMessageDialog(RemoteFileListPanel.this, "获取文件列表失败");
                        }
                    } else if (result.startsWith(Handler.deleteFiles)) {
                        System.out.println("删除文件。。。" + result);
                        String[] resultStr = result.split(">");
                        boolean success = "success".equals(resultStr[2]);
                        String b = "";
                        if (success) {
                            b = resultStr[3];
                        }
                        if ("true".equals(b)) {
                            JOptionPane.showMessageDialog(RemoteFileListPanel.this, "删除成功！");
                        } else {
                            JOptionPane.showMessageDialog(RemoteFileListPanel.this, "删除失败！");
                        }
                        open(RemoteFileListPanel.this.currentPath);
                    }
                }
            } catch (SocketTimeoutException s) {
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result == null) {
                this.setConnected(false);
                this.setName("未连接");
                changeCurrentTabTitle("未连接");
                reConnect();

                break;
            }
        }
    }

    public void changeCurrentTabTitle(String title) {
        this.fileListFrame.getRightTabbedPane().setTitleAt(this.fileListFrame.getRightTabbedPane().getSelectedIndex(), title);
    }
}
