package Game;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.lang.Math;

public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Integer x;

    private Integer y;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination){
        int distance = calculateDistance(destination);
        adjacentNodes.put(destination,distance);
    }

    private int calculateDistance(Node destination){
        double deltaX=this.x - destination.getX();
        double deltaY=this.y- destination.getY();
        return (int) Math.sqrt(deltaX*deltaX+deltaY*deltaY);
    }

    public Node(String name, int x, int y){
        this.name=name;
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setDistance(int distance){
        this.distance=distance;
    }

    public int getDistance(){
        return distance;
    }

    public Map<Node, Integer> getAdjacentNodes(){
        return adjacentNodes;
    }

    public List<Node> getShortestPath(){
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath){
        this.shortestPath=shortestPath;
    }

    public String getName() {
        return name;
    }

    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x-5,y-5,10,10);
    }

    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }
}
