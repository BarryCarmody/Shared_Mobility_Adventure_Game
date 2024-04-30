package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Bus extends Transport {

    static int speed = 12;

    public static final String transportType = "Bus";

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    public List<Node> route;

    private static final int co2Emission=2;

    public static List<Bus> busList= new ArrayList<>();

    public int stopTime;

    public int stoppedTime;

    public Player passenger;

    public boolean onboard;

    public int delay;

    private Image busImage;

    public Bus(BusRoute busroute, int delay){

        initBus(busroute.getRoute().get(0));
        setCurrentNode(busroute.getRoute().get(0));
        this.delay=delay;
        busList.add(this);
        setRoute(busroute.getRoute());
        passenger=Board.getPlayer();
        loadImage();

    }

    public void initBus(Node start){
        int START_X = start.getX() - (PWIDTH/2);
        int START_Y = start.getY() - (PHEIGHT/2);

        setX(START_X);
        setY(START_Y);
    }

    public void directionOfMotion(Node base, Node step) {
        int xdist = step.getX()-base.getX();
        int ydist = step.getY()-base.getY();

        double eucdist = Math.sqrt(xdist * xdist + ydist * ydist);
        setDx((step.getX()-base.getX())*speed/eucdist);
        setDy((step.getY()-base.getY())*speed/eucdist);
    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        if(onboard) {
            g.setColor(Color.MAGENTA);
            g.drawOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        }
    }

    public void drawBus(Graphics g){
        g.drawImage(busImage, (int) Math.round(getX())-PWIDTH/2, (int) Math.round(getY())-PHEIGHT/2,null);
        if(onboard) {
            g.setColor(Color.GREEN);
            g.drawOval((int) Math.round(getX())-PWIDTH/2, (int) Math.round(getY())-PWIDTH/2, PWIDTH, PHEIGHT);
        }
    }

    public void loadImage(){
        ImageIcon busIcon=new ImageIcon("Game/Images/yellowbus.png");
        Image newpic=busIcon.getImage();
        int scaledWidth = 40;  // Desired width
        int scaledHeight = 40;
        busImage=newpic.getScaledInstance(scaledWidth,scaledHeight,Image.SCALE_DEFAULT);

    }

    public static List<Bus> getBusList() {
        return busList;
    }

    public static void setBusList(List<Bus> busList) {
        Bus.busList = busList;
    }

    public void act(){

        if (Board.getActive()) {
            if (delay==0) {

                int curr = getCurrentSpotOnRoute();
                Node base = route.get(curr);
                setStepNode(route.get(curr + 1));
                directionOfMotion(base, getStepNode());

                if (isMoving()) {
                    setX(getX() + getDx());
                    setY(getY() + getDy());
                } else if (stoppedTime == stopTime) {
                    setMoving(true);
                }
                if (onboard) {
                    passenger.killTheEnvironment(co2Emission);

                    if (passengerStop()) {
                        dropOff();
                    }
                }
                if (getCurrentNode().getTransportStop()) {
                    stoppedTime += 1;
                    if (passengerWaiting()) {
                        pickUp();
                    }
                }


                //If close to next node
                if (Math.abs(10 + getX() - getStepNode().getX()) < (1 + speed) && Math.abs(10 + getY() - getStepNode().getY()) < (1 + speed)) {

                    setCurrentNode(getStepNode());
                    if (onboard) {
                        passenger.moveLocationtoNode(getStepNode());
                    }

                    //Wait at bus stop briefly
                    if (getCurrentNode().getTransportStop()) {
                        stoppedTime = 0;
                        stopTime = 5;
                        setMoving(false);
                    }

                    //If at end of route
                    if (curr == route.size() - 2) {
                        //Do the route in reverse
                        Collections.reverse(route);
                    } else {
                        //Move to exact spot of Node
                        setX(getStepNode().getX() - (PWIDTH / 2));
                        setY(getStepNode().getY() - (PHEIGHT / 2));
                    }
                }
            } else{
                delay-=1;
            }
        }
    }


    public int getCurrentSpotOnRoute(){
        //System.out.println(route);
        for (int i=0; i<route.size();i++){
            if (getCurrentNode().equals(route.get(i))){
                return i;
            }
        }
        return -1;
    }

    public boolean passengerWaiting(){
        return passenger.getCurrentNode() == getCurrentNode() && passenger.getStepNode()==getStepNode();
    }

    public void pickUp(){
        setOnboard(true);
        passenger.setVisible(false);
    }

    public boolean passengerStop(){
        return Objects.equals(passenger.getStepNode().getTransportType(), "Walk");
    }

    public void dropOff(){
        setOnboard(false);
        passenger.setVisible(true);
    }

    public void setOnboard(boolean onboard) {
        this.onboard = onboard;
    }

    public void setRoute(List<Node> route) {
        this.route = route;
    }

    public static int getCo2Emission() {
        return co2Emission;
    }
}
