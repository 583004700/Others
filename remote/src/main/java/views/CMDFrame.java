package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CMDFrame extends JFrame {
    //标题
    private String title = "未连接";
    //内容输入区
    private JTextArea contentInput = new JTextArea();

    private List<String> inputs = new ArrayList<String>();

    public CMDFrame(){
        contentInput.setForeground(Color.BLACK);
        contentInput.setFont(new Font("宋体", Font.PLAIN,16));
        this.addActionListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = contentInput.getText();
                    if(text.endsWith("\n")){
                        inputs.add("");
                    }else{
                        String[] arrStr = text.split("\n");
                        inputs.add(arrStr[arrStr.length - 1]);
                    }
                }
            }
        });

        JScrollPane jspSrc = new JScrollPane(contentInput);
        Container container = this.getContentPane();
        container.add(jspSrc);
        setSize(1200, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 追加内容
     * @param content
     */
    public void appendContent(String content){
        if(content == null){
            content = "";
        }
        contentInput.append(content);
        contentInput.setCaretPosition(contentInput.getText().length());
    }

    /**
     * 追加内容并换行
     */
    public void appendContentLn(String content){
        content = content+"\n";
        appendContent(content);
    }

    /**
     * 得到最后一条输入的内容
     * @return
     */
    public String getLastRowContent(){
        return inputs.get(inputs.size()-1);
    }

    /**
     * 添加键盘事件
     */
    public void addActionListener(KeyAdapter keyAdapter){
        contentInput.addKeyListener(keyAdapter);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        this.title = title;
    }

    public JTextArea getContentInput() {
        return contentInput;
    }

    public void setContentInput(JTextArea contentInput) {
        this.contentInput = contentInput;
    }
}
