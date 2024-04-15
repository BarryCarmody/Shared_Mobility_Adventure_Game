package Game;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

public class Car extends Transport{

    static int speed = 12;

    public static final String transportType = "Car";

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    public boolean onboard;

    public List<Node> route;

    public int stopTime;

    public int stoppedTime;

    public static List<Car> carList= new ArrayList<>();

    private static List<Node> potentialStarts;

    private static Maps carGraph;

    private static List<Node> carNodeList;

    public Car(List<Node> start, Node pickUp){
        //potentialStarts=start;
        Node startNode=findNearestTaxi(potentialStarts,pickUp);
        setCurrentNode(startNode);
        setX(getCurrentNode().getX() - (PWIDTH / 2));
        setY(getCurrentNode().getY() - (PHEIGHT / 2));
        System.out.println(startNode+" to "+pickUp);
        nextLocation(pickUp);
        //System.out.println("New route: "+route);
        carList.add(this);
        setMoving(true);
    }

    public void act(){
        if (Board.getActive()) {
            if(isMoving()) {

                int curr = getCurrentSpotOnRoute();
                Node base = getRoute().get(curr);
                setStepNode(getRoute().get(curr + 1));
                //System.out.println("I'm currently at "+base+ " I'm going to "+getStepNode());
                directionOfMotion(base, getStepNode());

                setX(getX() + getDx());
                setY(getY() + getDy());

                //System.out.println(player.currentNode);
                if (Math.abs(10 + getX() - getStepNode().getX()) < (1 + speed) && Math.abs(10 + getY() - getStepNode().getY()) < (1 + speed)) {

                    setCurrentNode(getStepNode());
                    //System.out.println(getCurrentNode());
//                    if (onboard) {
//                        player.moveLocationtoNode(getCurrentNode());
//                    }

                    //If at end of route
                    if (curr == getRoute().size() - 2) {
                        setDx(0);
                        setDy(0);
                        setX(getStepNode().getX() - (PWIDTH / 2));
                        setY(getStepNode().getY() - (PHEIGHT / 2));
                        setMoving(false);
                        //dropOff();
                    } else {
                        //Move to exact spot of Node
                        setX(getStepNode().getX() - (PWIDTH / 2));
                        setY(getStepNode().getY() - (PHEIGHT / 2));
                    }
                }
            }

        }
    }

    public void directionOfMotion(Node base, Node step) {
        int xdist = step.getX()-base.getX();
        int ydist = step.getY()-base.getY();

        double eucdist = Math.sqrt(xdist * xdist + ydist * ydist);
        if(eucdist!=0) {
            setDx((step.getX() - base.getX()) * speed / eucdist);
            setDy((step.getY() - base.getY()) * speed / eucdist);
        }
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

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        if(onboard) {
            g.setColor(Color.MAGENTA);
            g.drawOval((int) Math.round(getX()), (int) Math.round(getY()), PWIDTH, PHEIGHT);
        }
    }

    public static void callTaxi(Node pickUp){
        new Car(potentialStarts,pickUp);
    }

    public static Node findNearestTaxi(List<Node> locations, Node pickUp){
        Node startNode=pickUp;
        int distance=Integer.MAX_VALUE;

        for(Node currentLocation: locations) {
            int dist = (currentLocation.getX() - pickUp.getX()) * (currentLocation.getX() - pickUp.getX()) + (currentLocation.getY() - pickUp.getY()) * (currentLocation.getY() - pickUp.getY());

            if(dist<distance){
                startNode=currentLocation;
                distance=dist;
            }
        }
        return startNode;
    }

    private void nextLocation(Node destination){
        Board.resetNodeDist();
        if (route!=null) {
            route.clear();
        }

        List<Node> test=Maps.routeBetweenNodes(getCarGraph(),getCurrentNode(),destination);
        System.out.println(test);
        setRoute(test);

        int trueStart=getCurrentSpotOnRoute();
        test=test.subList(trueStart,test.size());
        //System.out.println("New route: "+test);
        setRoute(test);
        route.add(destination);

    }

    public static void setPotentialStarts(List<Node> potentialStarts) {
        Car.potentialStarts = potentialStarts;
    }

    public static void setCarGraph(Maps carGraph) {
        Car.carGraph = carGraph;
    }

    public static Maps getCarGraph() {
        return carGraph;
    }

    public static void setCarNodeList(List<Node> carNodeList) {
        Car.carNodeList = carNodeList;
    }

    public static List<Node> getCarNodeList() {
        return carNodeList;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    @Override
    public void setRoute(List<Node> route) {
        this.route = route;
    }

    @Override
    public List<Node> getRoute() {
        return route;
    }
}
