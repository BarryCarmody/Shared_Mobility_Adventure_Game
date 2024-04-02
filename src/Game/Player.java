package Game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    public Node currentNode;

    public Player(Node startNode) {

        initPlayer(startNode);
        currentNode=startNode;
    }

    private void initPlayer(Node startNode) {

        int START_X = startNode.getX() - (PWIDTH/2);
        int START_Y = startNode.getY() - (PHEIGHT/2);

        setX(START_X);
        setY(START_Y);

    }

    public void act() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics g){
       g.setColor(Color.MAGENTA);
       g.fillOval(x,y,PWIDTH,PHEIGHT);
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT||key == KeyEvent.VK_RIGHT) {
            dx = 0;

        }
        if (key == KeyEvent.VK_DOWN||key == KeyEvent.VK_UP) {
            dy = 0;
        }
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode){
        this.currentNode=currentNode;
    }
}