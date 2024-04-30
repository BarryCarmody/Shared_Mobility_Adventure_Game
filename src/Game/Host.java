package Game;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Game.Commons;

public class Host extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JPanel splashPanel=new JPanel(new BorderLayout());
    private JPanel mainPanel = new JPanel(new BorderLayout());


    public Host() {
        initialise();
    }

    public void initialise() {
        setTitle("I'm not safe");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().requestFocusInWindow();
        initialiseUI();
    }

    public void initialiseUI() {
        getContentPane().add(cardPanel);
        createSplashPanel();
        createMainPanel();

        cardPanel.add(splashPanel, "Splash");
        cardPanel.add(mainPanel, "Main");

        cardLayout.show(cardPanel, "Splash");
        new javax.swing.Timer(5000, e ->
        {
            cardLayout.show(cardPanel, "Main");
            Component board = mainPanel.getComponent(0);
            if (board != null) {
                board.requestFocusInWindow();
            }
        }).start();
    }

    private void createSplashPanel() {
        JLabel splashLabel = new JLabel("Ja Weiward Dreamers");
        splashLabel.setFont(new Font("GOUDY STOUT", Font.BOLD, 50));
        splashLabel.setForeground(Color.white);
        splashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        splashPanel.setBackground(Color.black);
        splashPanel.add(splashLabel, BorderLayout.CENTER);
        splashPanel.setVisible(true);
    }

    private void createMainPanel() {
        Board gameBoard = new Board();
        mainPanel.add(gameBoard, BorderLayout.CENTER);
        mainPanel.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        EventQueue.invokeLater(() -> {
            var ex = new Host();
            ex.setVisible(true);

        });

    }
}


