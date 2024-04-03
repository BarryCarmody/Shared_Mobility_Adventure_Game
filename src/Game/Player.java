package Game;

import java.awt.*;
import java.util.List;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private final int PHEIGHT=20;
    private final int PWIDTH=20;


    public Player(Node startNode) {

        speed=6;
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
        if (moving) {
            int curr=getCurrentSpotOnRoute();
            Node base=route.get(curr);
            Node step=route.get(curr+1);
            directionOfMotion(base, step);
            x += dx;
            y += dy;
            System.out.println("X: "+(x-step.getX()));
            System.out.println("Y: "+(y-step.getY()));

            if (Math.abs(10+x-step.getX())<(1+speed) && Math.abs(10+y-step.getY())<(1+speed)){
                x=step.getX()-(PWIDTH/2);
                y=step.getY()-(PHEIGHT/2);
                currentNode=step;
                if (getCurrentSpotOnRoute()==route.size()){
                    moving=false;
                }
            }
        }
    }

    public void draw(Graphics g){
       g.setColor(Color.MAGENTA);
       g.fillOval((int) Math.round(x), (int) Math.round(y),PWIDTH,PHEIGHT);
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode){
        this.currentNode=currentNode;
    }
}