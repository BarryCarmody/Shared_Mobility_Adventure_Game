package Game;

import java.awt.*;
import java.util.*;
import java.lang.Math;
import java.util.List;

public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Integer x;

    private Integer y;

    private final String transportType;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name, int x, int y){
        this.name=name;
        this.x=x;
        this.y=y;
        this.transportType="Walk";
    }

    public Node(String name, int x, int y, String transport){
        this.name=name;
        this.x=x;
        this.y=y;
        this.transportType=transport;
    }


    public void addDestination(Node destination){
        int distance = calculateDistance(destination);
        System.out.println("Dist from "+ name +" to "+ destination.name + " is "+ distance);
        adjacentNodes.put(destination,distance);
    }

    private int calculateDistance(Node destination){
        int speed;
        if (Objects.equals(transportType, "Walk")){
            speed=6;
        }
        else if (Objects.equals(transportType, "Bus")){
            speed=Bus.speed;
        }
        else{
            speed=1;
        }
        double deltaX=this.x-destination.getX();
        double deltaY=this.y-destination.getY();
        return (int) (Math.sqrt(deltaX*deltaX+deltaY*deltaY))/speed;
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

    public void setDistance(Integer distance){this.distance=distance;}

    @Override
    public String toString(){
        return name;
    }
}
