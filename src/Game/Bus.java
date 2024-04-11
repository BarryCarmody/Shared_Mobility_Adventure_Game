package Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bus extends Transport {

    static int speed = 20;

    public static final String transportType = "Bus";

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    public List<Node> route;

    public static List<Bus> busList= new ArrayList<>();

    public Bus(BusRoute busroute){

        initBus(busroute.getRoute().get(0));
        setCurrentNode(busroute.getRoute().get(0));
        busList.add(this);
    }

    public void initBus(Node start){
        int START_X = start.getX() - (PWIDTH/2);
        int START_Y = start.getY() - (PHEIGHT/2);

        setX(START_X);
        setY(START_Y);
    }

    @Override
    public void directionOfMotion() {

    }

    @Override
    public void getCurrentSpotOnRoute() {

    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval((int) Math.round(getX()), (int) Math.round(getY()),PWIDTH,PHEIGHT);
    }

    public static List<Bus> getBusList() {
        return busList;
    }
}
