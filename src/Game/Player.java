package Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    private static int co2max=10000;

    private int co2level;

    private Panel co2Bar;

    private int wait=0;

    private int score;

    private Image playerImage;


    public Player(Node startNode) {

        initPlayer(startNode);
        this.currentNode=startNode;
        this.co2level=co2max;
        loadImage();
    }

    private void initPlayer(Node startNode) {
        int START_X = startNode.getX() - (PWIDTH/2);
        int START_Y = startNode.getY() - (PHEIGHT/2);

        setX(START_X);
        setY(START_Y);

        this.co2Bar=new Panel(Commons.BOARD_WIDTH-265, 35,(Commons.BOARD_HEIGHT-100),30 ,"","Bar");
    }

    public void act() {
        if (Board.getActive()) {

            int curr = getCurrentSpotOnRoute();
            Node base = route.get(curr);
            setStepNode(route.get(curr + 1));

            if (base.getTransportType().equals("Walk") && stepNode.getTransportType().equals("Bus")) {
                moving = false;
            } else if (base.getTransportType().equals("Bus") && stepNode.getTransportType().equals("Walk")) {
                moving = true;
            } else if (base.getTransportType().equals("Walk") && stepNode.getTransportType().equals("Bike")) {
                moving = false;
                pickingUpBike();
            } else if (base.getTransportType().equals("Bike") && stepNode.getTransportType().equals("Walk")) {
                moving = true;
            }else if (base.getTransportType().equals("Walk") && stepNode.getTransportType().equals("Car")) {
                moving = false;
            }else if (base.getTransportType().equals("Car") && stepNode.getTransportType().equals("Walk")) {
                moving = true;
            }

            directionOfMotion(base, stepNode);
            if (moving) {
                x += dx;
                y += dy;
            }

            if (Math.abs(PWIDTH / 2 + x - stepNode.getX()) < (1 + speed) && Math.abs(PHEIGHT / 2 + y - stepNode.getY()) < (1 + speed)) {
                currentNode = stepNode;
                if (curr == route.size() - 2) {
                    moving = false;
                    Board.setActive(false);
                    System.out.println("Im at "+currentNode);
                    targetNode=null;
                    Level.setCarFilter(false);
                    Level.setBikeFilter(false);
                    Level.setBusFilter(false);


                } else {
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

    public void loadImage(){
        ImageIcon playerIcon=new ImageIcon("src/Game/Images/player_icon.png");
        Image newpic=playerIcon.getImage();
        int scaledWidth = 25;  // Desired width
        int scaledHeight = 25;
        playerImage=newpic.getScaledInstance(scaledWidth,scaledHeight,Image.SCALE_DEFAULT);

    }

    public void drawPlayer(Graphics g) {
        g.drawImage(playerImage, (int) Math.round(x), (int) Math.round(y),null);
    }

    public void killTheEnvironment(int damage){
        setCo2level(Math.max(0,getCo2level()-damage));
        co2Bar.setHeight((Commons.BOARD_HEIGHT-100)*co2level/co2max);
        co2Bar.setY((Commons.BOARD_HEIGHT-65)-co2Bar.getHeight());
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

    public void pickingUpBike(){
        Level.setBike(new Bike(this));
    }

    public void setCo2level(int co2level) {
        this.co2level = co2level;
    }

    public int getCo2level() {
        return co2level;
    }

    public static int getCo2max() {
        return co2max;
    }

    public Panel getCo2Bar() {
        return co2Bar;
    }
}


