package views.pages;

import lombok.Setter;
import lombok.experimental.Accessors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.ByteArrayOutputStream;

@Setter
@Accessors(chain = true)
public class SetImageThread implements Runnable{
    private ByteArrayOutputStream byteArrayOutputStream;
    private ScreeningImageLabel jlbImg;

    public SetImageThread(ScreeningImageLabel jlbImg){
        this.jlbImg = jlbImg;
    }

    @Override
    public void run() {
        Image icon = new ImageIcon(byteArrayOutputStream.toByteArray());
        //icon.setImage(icon.getImage().getScaledInstance(this.imgWidth, this.imgHeight, Image.SCALE_DEFAULT));
        jlbImg.setImage(icon);
    }
}
