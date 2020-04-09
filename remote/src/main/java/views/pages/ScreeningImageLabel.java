package views.pages;

import javax.swing.*;
import java.awt.*;

public class ScreeningImageLabel extends JLabel {
    ImageIcon icon = new ImageIcon();

    public ScreeningImageLabel(){

    }

    public void setImage(Image image){
        this.icon.setImage(image);
        repaint();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(icon.getImage(), 0, 0, getWidth(),getHeight(),
                icon.getImageObserver());
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
