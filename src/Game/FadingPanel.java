package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FadingPanel extends JPanel implements ActionListener {
    //private JPanel FadingPanel = new JPanel(new BorderLayout());
    Timer alphaTimer;
    float alphaValue = 0f;
    private boolean fadingOut = false;

    public FadingPanel() {
        alphaTimer = new Timer(10, this);
        alphaTimer.start();
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!fadingOut) {
            alphaValue += 0.01f;
            if (alphaValue >= 1f) {
                alphaValue = 1f;
                fadingOut = true;

            }

        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            alphaValue -= 0.01f;

            if (alphaValue <= 0f) {
                alphaValue = 0f;
                fadingOut=false;
                alphaTimer.stop();
            }
            repaint();
        }
    }
}


