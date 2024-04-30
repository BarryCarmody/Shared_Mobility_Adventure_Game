package Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CustomButton extends JButton {
    private final String buttonText;
    private final Dimension defaultSize = new Dimension(300, 80);

    CustomButton(final String buttonText) {
        super();
        this.buttonText = buttonText;
        this.loadBlankButtonIcon();
        this.setSize(this.defaultSize);
        this.setPreferredSize(this.defaultSize);
        this.setFocusPainted(true);
        this.setContentAreaFilled(false);
    }

    private void loadBlankButtonIcon() {
        try {
            final Image image = ImageIO.read(new File("assets/blankButton.png")).getScaledInstance(defaultSize.width, defaultSize.height, Image.SCALE_FAST);
            final ImageIcon icon = new ImageIcon(image);
            this.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);

        // The following allows text to be drawn over a button image instead of beside
        final Graphics2D g = (Graphics2D) graphic;
        g.setFont(new Font("Britannic Bold", Font.BOLD, 25));
        final FontMetrics metric = g.getFontMetrics();
        g.drawString(this.buttonText, (getWidth() - metric.stringWidth(this.buttonText)) / 2, (getHeight()) / 2);
    }

}
