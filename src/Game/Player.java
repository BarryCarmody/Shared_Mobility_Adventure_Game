package Game;

import java.awt.*;
import java.util.List;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

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
        if (Board.getActive()) {
            int curr=getCurrentSpotOnRoute();
            Node base=route.get(curr);
            setStepNode(route.get(curr+1));

            if(base.getTransportType().equals("Walk") && stepNode.getTransportType().equals("Bus")){
                moving=false;
            }else if(base.getTransportType().equals("Bus") && stepNode.getTransportType().equals("Walk")){
                moving=true;
            }

            directionOfMotion(base, stepNode);
            if (moving) {
                x += dx;
                y += dy;
            }

            if (Math.abs(PWIDTH/2+x-stepNode.getX())<(1+speed) && Math.abs(PHEIGHT/2+y-stepNode.getY())<(1+speed)) {
                currentNode = stepNode;
                if (curr== route.size()-2) {
                    moving = false;
                    Board.setActive(false);
                }else {
                    x = stepNode.getX() - (PWIDTH / 2);
                    y = stepNode.getY() - (PHEIGHT / 2);
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

    public void moveLocationtoNode(Node moveToNode){
        setX(moveToNode.getX()- (PWIDTH/2));
        setY(moveToNode.getY()- (PHEIGHT/2));
    }
}
