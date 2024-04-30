package Game;

import javax.swing.*;
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

    private final boolean transportStop;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    private Image busStopImage;

    private Image bikeStationImage;

    public Node(String name, int x, int y){
        this.name=name;
        this.x=x;
        this.y=y;
        this.transportType="Walk";
        this.transportStop=false;
    }

    public Node(String name, int x, int y, String transport){
        this.name=name;
        this.x=x;
        this.y=y;
        this.transportType=transport;
        this.transportStop=false;
        loadImage();
    }

    public Node(String name, int x, int y, String transport, boolean transportStop){
        this.name=name;
        this.x=x;
        this.y=y;
        this.transportType=transport;
        this.transportStop=transportStop;
        loadImage();
    }


    public void addDestination(Node destination){
        int distance = calculateDistance(destination);
        //System.out.println("Dist from "+ name +" to "+ destination.name + " is "+ distance);
        adjacentNodes.put(destination,distance);
    }

    public int calculateDistance(Node destination){
        double deltaX=this.x-destination.getX();
        double deltaY=this.y-destination.getY();
        return (int) (Math.sqrt(deltaX*deltaX+deltaY*deltaY));
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

    public void loadImage() {
        if (transportStop && (Objects.equals(getTransportType(), "Bus"))){
            ImageIcon busIcon = new ImageIcon("Game/Images/busStop.png");
            Image newpic = busIcon.getImage();
            int scaledWidth = 30;  // Desired width
            int scaledHeight = 30;
            busStopImage = newpic.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);}
        else if  (transportStop&&(Objects.equals(getTransportType(), "Bike"))){
            ImageIcon playerIcon = new ImageIcon("Game/Images/bicycleStand.png");
            Image newpic = playerIcon.getImage();
            int scaledWidth = 30;  // Desired width
            int scaledHeight = 30;
            bikeStationImage = newpic.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);}
        }


//    public void draw(Graphics g){
//        if((Objects.equals(getTransportType(), "Walk"))) {
//            g.setColor(Color.ORANGE);
//            g.fillOval(x - 5, y - 5, 10, 10);
//        }else if(transportStop&&(Objects.equals(getTransportType(), "Bus"))){
//            g.setColor(Color.YELLOW);
//            g.fillRect(x - 8, y - 8, 16, 16);
//            g.setColor(Color.BLUE);
//            g.drawRect(x - 8, y - 8, 16, 16);
//        }else if(transportStop&&(Objects.equals(getTransportType(), "Bike"))) {
//            g.setColor(Color.GREEN);
//            g.fillRect(x - 8, y - 8, 16, 16);
//            g.setColor(Color.WHITE);
//            g.drawRect(x - 8, y - 8, 16, 16);
//        }
//    }

    public void drawTransport(Graphics g){
        if((Objects.equals(getTransportType(), "Walk"))) {
            g.setColor(Color.ORANGE);
            g.fillOval(x - 5, y - 5, 10, 10);
        }else if(transportStop&&(Objects.equals(getTransportType(), "Bus"))){
            g.drawImage(busStopImage, x-15, y-15,null);
        }else if(transportStop&&(Objects.equals(getTransportType(), "Bike"))) {
            g.drawImage(bikeStationImage, x-15, y-15,null);
        }

    }

    public void drawLinks(Graphics g){
        for (Map.Entry<Node,Integer> entry: adjacentNodes.entrySet()){
            Node destination= entry.getKey();
            int distance= entry.getValue();

            //Line draw details
            Graphics2D g2d = (Graphics2D) g;

            if((Objects.equals(getTransportType(), "Walk"))) {
                g2d.setColor(new Color(128,128,128));
                g2d.setStroke(new BasicStroke(3.0f));
            } else if ((Objects.equals(getTransportType(), "Car"))) {
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5.0f));
            }

            g2d.drawLine(x,y, destination.getX(), destination.getY());
        }
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDistance(Integer distance){this.distance=distance;}

    public String getTransportType() {
        return transportType;
    }

    public boolean getTransportStop(){
        return transportStop;
    }

    @Override
    public String toString(){
        return name;
    }
}
