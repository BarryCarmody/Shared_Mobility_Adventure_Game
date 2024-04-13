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

    private Node stepNode;

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

    public void setX(double x){
        this.x=x;
    }

    public double getY(){return y;}

    public void setY(double y){
        this.y=y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving){
        this.moving=moving;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public Node getStepNode() {
        return stepNode;
    }

    public void setStepNode(Node stepNode) {
        this.stepNode = stepNode;
    }
}
