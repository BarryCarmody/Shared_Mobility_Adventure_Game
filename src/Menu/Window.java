package Menu;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public static int currentState;
    public static Scene currentScene;

    public static KL keyListener = new KL();
    public static ML mouseListener = new ML();

    public Window(int width, int height, String title) {
        setSize(width, height);
        setTitle(title);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(Window.keyListener);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);

        Window.changeState(0);
    }

    public static void changeState(int newState) {
        Window.currentState = newState;
        switch (Window.currentState) {
            case 0:
                Window.currentScene = new MenuScene(Window.keyListener, Window.mouseListener);
                break;
            case 1:
                Window.currentScene = new GameScene();
                break;
            default:
                System.out.println("Unknown scene.");
                Window.currentScene = null;
                break;
        }
    }


    public void update() {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);

        currentScene.update();
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //sets graphics object to a 2D object
        currentScene.draw(g);
    }

    @Override
    public void run() {
        try {
            while (true) {
                update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
