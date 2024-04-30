package Menu;

import Game.Board;
import Game.Level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameScene extends Scene {
    private final ML mouseListener;
    private final KL keyListener;

    private BufferedImage infoIconImage;
    private final Rectangle infoButtonRect = new Rectangle(10, 45, 30, 30);
    private final PopupScreen infoPopup;
    private final Rectangle infoButtonRect2 = new Rectangle(50, 45, 30, 30);
    private final PopupScreen infoPopup2;
    private final Rectangle infoButtonRect3 = new Rectangle(90, 45, 30, 30);
    private final PopupScreen infoPopup3;

    private Level currentLevel;
    private Level nextLevel;

    private Board board;

    public GameScene(final Window window, final KL keyListener, final ML mouseListener) {
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;

        try {
            infoIconImage = ImageIO.read(new File("assets/infoBurron.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        window.add(new Board());

        // For level testing
        try {
            currentLevel = new Level(1);
            nextLevel = new Level(2);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        // ---
        infoPopup = new LevelCompletePopup(currentLevel);
        infoPopup.setRelativeContainer(window);
        infoPopup.addKeyListener(keyListener);

        infoPopup2 = new NewLevelPopup(nextLevel);
        infoPopup2.setRelativeContainer(window);
        infoPopup2.addKeyListener(keyListener);

        infoPopup3 = new InGameOptionsPopup(currentLevel);
        infoPopup3.setRelativeContainer(window);
        infoPopup3.addKeyListener(keyListener);
    }

    @Override
    public void update() {
        if (mouseListener.isPressed()) {
            if (mouseListener.isInRectangle(infoButtonRect)) {
                infoPopup.drawPopupScreen();
            } else {
                infoPopup.removePopupScreen();
            }

            if (mouseListener.isInRectangle(infoButtonRect2)) {
                infoPopup2.drawPopupScreen();
            } else {
                infoPopup2.removePopupScreen();
            }

            if (mouseListener.isInRectangle(infoButtonRect3)) {
                infoPopup3.drawPopupScreen();
            } else {
                infoPopup3.removePopupScreen();
            }
        }

        if (infoPopup.isOpen() && keyListener.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            infoPopup.removePopupScreen();
        }
        if (infoPopup2.isOpen() && keyListener.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            infoPopup2.removePopupScreen();
        }
        if (infoPopup3.isOpen() && keyListener.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            infoPopup3.removePopupScreen();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 800, 600);
        this.addInfoButton(g);
    }

    private void addInfoButton(final Graphics g) {
        g.drawImage(infoIconImage, infoButtonRect.x, infoButtonRect.y, infoButtonRect.width, infoButtonRect.height, null);
        g.drawImage(infoIconImage, infoButtonRect2.x, infoButtonRect2.y, infoButtonRect2.width, infoButtonRect2.height, null);
        g.drawImage(infoIconImage, infoButtonRect3.x, infoButtonRect3.y, infoButtonRect3.width, infoButtonRect3.height, null);
    }

    public void initBoard(Window window){
        board = new Board();
        window.add(board);
    }
}
