package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

public class Bike extends Transport{

    static int speed = 4;
    private final int PHEIGHT=20;
    private final int PWIDTH=20;
    public boolean onboard;
    public Player player;

    public int delay=0;

    public static final String transportType = "Bike";

    private Image cyclistImage;

    public Bike(Player passenger){

        //Sets Start Point

        setCurrentNode(passenger.getRoute().get(passenger.getCurrentSpotOnRoute()+1));
        moveLocationtoNode(passenger.getCurrentNode());
        this.player=passenger;

        //Checks Next node
        planInitRoute(passenger);
        System.out.println(getRoute());
        setOnboard(true);
        player.setVisible(false);
        setMoving(true);
        loadImage();


    }

    public void act(){
        if (Board.getActive()) {
            if(isMoving()) {
                if (delay==0) {
                    int curr = getCurrentSpotOnRoute();
                    Node base = getRoute().get(curr);
                    setStepNode(getRoute().get(curr + 1));
                    directionOfMotion(base, getStepNode());

                    setX(getX() + getDx());
                    setY(getY() + getDy());


                    //System.out.println(player.currentNode);
                    if (Math.abs(10 + getX() - getStepNode().getX()) < (1 + speed) && Math.abs(10 + getY() - getStepNode().getY()) < (1 + speed)) {

                        setCurrentNode(getStepNode());
                        System.out.println(getCurrentNode());
                        if (onboard) {
                            player.moveLocationtoNode(getCurrentNode());

                        }

                        //If at end of route
                        if (curr == getRoute().size() - 2) {
                            setDx(0);
                            setDy(0);
                            setX(getStepNode().getX() - (PWIDTH / 2));
                            setY(getStepNode().getY() - (PHEIGHT / 2));
                            dropOff();
                        } else {
                            //Move to exact spot of Node
                            setX(getStepNode().getX() - (PWIDTH / 2));
                            setY(getStepNode().getY() - (PHEIGHT / 2));
                        }
                    }
                }else if(delay==1){
                    setMoving(false);
                    Level.setBike(null);
                }else{
                    delay-=1;
                }
            }
        }
    }

    public int getDelay() {
        return delay;
    }

    public void dropOff(){
        setOnboard(false);
        player.setVisible(true);
        //Set greater than 1 to make bike wait a while before disappearing 20ms per 1 increased
        delay=1;
    }

    public void directionOfMotion(Node base, Node step) {
        int xdist = step.getX()-base.getX();
        int ydist = step.getY()-base.getY();

        double eucdist = Math.sqrt(xdist * xdist + ydist * ydist);
        setDx((step.getX()-base.getX())*speed/eucdist);
        setDy((step.getY()-base.getY())*speed/eucdist);
    }


    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        if(onboard) {
            g.setColor(Color.MAGENTA);
            g.drawOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        }
    }

    public void loadImage() {
        ImageIcon cyclistIcon = new ImageIcon("C:/Users/Justh/IdeaProjects/BarrysGame/src/Game/Images/cyclist1.png");
        Image newpic = cyclistIcon.getImage();
        int scaledWidth = 25;  // Desired width
        int scaledHeight = 25;
        cyclistImage = newpic.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);
    }

    public void drawBike(Graphics g){
        g.drawImage(cyclistImage, (int) Math.round(x), (int) Math.round(y),null);
        }


    public void moveLocationtoNode(Node moveToNode){
        setX(moveToNode.getX()- (PWIDTH/2));
        setY(moveToNode.getY()- (PHEIGHT/2));
    }

    public void setOnboard(boolean onboard) {
        this.onboard = onboard;
    }

    @Override
    public int getCurrentSpotOnRoute() {

        for (int i=0; i<getRoute().size();i++){
            if (getCurrentNode().equals(getRoute().get(i))){
                return i;
            }
        }
        return -1;
    }

    public void planInitRoute(Player passenger){
        int i=passenger.getCurrentSpotOnRoute()+1;
        boolean checking=true;
        List<Node> tmplist= new ArrayList<>();
        while(checking){
            if(Objects.equals(passenger.getRoute().get(i).getTransportType(), "Bike")&&i<passenger.getRoute().size()){

                tmplist.add(passenger.getRoute().get(i));
                setRoute(tmplist);

                i+=1;
            }else{
                checking=false;
            }
        }
    }

}
