package Game;

import java.awt.Image;
import java.util.List;

public class Sprite {
    private boolean visible;
    private Image image;

    public double x;
    public double y;

    public double dx;
    public double dy;

    public Node currentNode;

    public Node targetNode;

    public Node stepNode;

    public boolean moving;

    public List<Node> route;

    static int speed=2;

    public Sprite(){
        visible=true;
    }
    public void hide(){
        visible=false;
    }
    public boolean isVisible(){
        return visible;
    }

    protected void setVisible(boolean visible){
        this.visible=visible;
    }

    public void setImage(Image image){
        this.image=image;
    }

    public Image getImage(){
        return this.image;
    }

    public List<Node> getRoute() {
        return route;
    }

    public int getCurrentSpotOnRoute(){
        //System.out.println(route);
        for (int i=0; i<route.size();i++){
            if (currentNode.equals(route.get(i))){
                return i;
            }
        }
        return -1;
    }

    public int getCurrentSpotOnRouteInv(){
        for (int i=route.size()-1; i>=0; i--){
            if (currentNode.equals(route.get(i))){
                return i;
            }
        }
        return -1;
    }

    public void directionOfMotion(Node base, Node step){
        int xdist = step.getX()-base.getX();
        int ydist = step.getY()-base.getY();
        if ((xdist==0) && (ydist==0)){
            dx=0;
            dy=0;
        } else{
            double eucdist = Math.sqrt(xdist * xdist + ydist * ydist);
            dx=(step.getX()-base.getX())*speed/eucdist;
            dy=(step.getY()-base.getY())*speed/eucdist;
        }

    }

    public void setX(double x){
        this.x=x;
    }

    public void setY(double y){
        this.y=y;
    }

    public void setRoute(List<Node> route){
        this.route=route;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setDX(int dx){
        this.dx=dx;
    }

    public void setDY(int dy){this.dy=dy;}

    public double getDX() {
        return dx;
    }

    public double getDY() {
        return dy;
    }

    public void setStepNode(Node stepNode) {
        this.stepNode = stepNode;
    }

    public Node getStepNode() {
        return stepNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }

}
