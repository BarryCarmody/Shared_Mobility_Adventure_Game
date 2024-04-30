package Game;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.border.Border;

import Game.Commons;

public class SplashScreen extends JFrame {
    public SplashScreen(String companyName, int waitTime) {

        JLabel label1 = new JLabel(companyName);
        label1.setFont(new Font("GOUDY STOUT",Font.BOLD,50));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().setBackground(Color.black);
        getContentPane().add(label1, BorderLayout.CENTER);
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setLocationRelativeTo(null);

    }
}

