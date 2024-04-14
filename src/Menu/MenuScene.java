package Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuScene extends Scene {

    private final Window window;
    private final KL keyListener;
    private final ML mouseListener;
    private BufferedImage title, play, playPressed, leaderBoard, leaderBoardPressed;
    private BufferedImage playCurrentImage, leaderboardCurrentImage;
    private final Rectangle playRect = new Rectangle(320, 370, 200, 50);
    private final Rectangle leaderBoardRect = new Rectangle(320, 430, 200, 50);

    public MenuScene(final Window window, final KL keyListener, final ML mouseListener) {
        this.window = window;
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;

        try {
            title = ImageIO.read(new File("assets/title.png"));
            play = ImageIO.read(new File("assets/start1.png"));
            playPressed = ImageIO.read(new File("assets/start2.png"));
            leaderBoard = ImageIO.read(new File("assets/leaderboard1.png"));
            leaderBoardPressed = ImageIO.read(new File("assets/leaderboard2.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        playCurrentImage = play;
        leaderboardCurrentImage = leaderBoard;
    }

    //    int i = 0;
    @Override
    public void update() {
//        if (i==100) {
//            window.changeState(1);
//        }
//        i++;
//        if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
//            System.out.println("Up");
//        }
        if (mouseListener.isInRectangle(playRect)) {
            playCurrentImage = playPressed;
            if (mouseListener.isPressed()) {
                window.changeState(1);
            }
        } else {
            playCurrentImage = play;
        }

        if (mouseListener.isInRectangle(leaderBoardRect)) {
            leaderboardCurrentImage = leaderBoardPressed;
        } else {
            leaderboardCurrentImage = leaderBoard;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(title, 180, 100, 500, 250, null);
        g.drawImage(playCurrentImage, playRect.x, playRect.y, playRect.width, playRect.height, null);
        g.drawImage(leaderboardCurrentImage, leaderBoardRect.x, leaderBoardRect.y, leaderBoardRect.width, leaderBoardRect.height, null);
    }
}
