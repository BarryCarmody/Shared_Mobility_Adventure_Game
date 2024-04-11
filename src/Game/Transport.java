package Game;

import java.util.*;
abstract class Transport implements Mover {

    public static String transportType;

    private int co2Emission;

    private double x;

    private double y;

    private double dx;

    private double dy;

    private Node currentNode;

    private boolean moving;

    private List<Node> route;

    static int speed;

    private Node targetNode;

    private boolean visible;

    static String getTransportType(){
        return transportType;
    }

    public void setVisible(boolean visible){
        this.visible=visible;
    }

    public boolean getVisible(){
        return visible;
    }

    public double getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    public double getY(){return y;}

    public void setY(int y){
        this.y=y;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }
}
