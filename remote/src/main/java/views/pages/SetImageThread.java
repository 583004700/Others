package views.pages;

import lombok.Setter;
import lombok.experimental.Accessors;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.ByteArrayOutputStream;

@Setter
@Accessors(chain = true)
public class SetImageThread implements Runnable{
    private ByteArrayOutputStream byteArrayOutputStream;
    private JLabel jlbImg;

    public SetImageThread(JLabel jlbImg){
        this.jlbImg = jlbImg;
    }

    @Override
    public void run() {
        ImageIcon icon = new ImageIcon(byteArrayOutputStream.toByteArray());
        //icon.setImage(icon.getImage().getScaledInstance(this.imgWidth, this.imgHeight, Image.SCALE_DEFAULT));
        jlbImg.setIcon(icon);
    }
}
