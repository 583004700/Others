package views.pages;

import lombok.Setter;
import lombok.experimental.Accessors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.ByteArrayOutputStream;

@Setter
@Accessors(chain = true)
public class SetImageThread implements Runnable{
    private ByteArrayOutputStream byteArrayOutputStream;
    private JLabel jlbImg;
    private JPanel jpanel;

    public SetImageThread(JPanel jPanel, JLabel jlbImg){
        this.jlbImg = jlbImg;
        this.jpanel = jPanel;
    }

    @Override
    public void run() {
        ImageIcon icon = new ImageIcon(byteArrayOutputStream.toByteArray());
        icon.setImage(icon.getImage().getScaledInstance(this.jpanel.getWidth(),this.jpanel.getHeight(), Image.SCALE_DEFAULT));
        jlbImg.setIcon(icon);
    }
}
