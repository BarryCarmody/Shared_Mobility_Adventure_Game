package Game;

import java.util.ArrayList;

public class Level {

    private int gemTargetMultiplier = 100;
    private int gemsObtained = 0;

    public int number;

    public Bus bus1;

    public boolean bikeButton;

    public boolean busButton;

    public boolean carButton;

    public Level(int number) {
        this.number = number;
        initLevel();
    }

    public void initLevel() {
        if (number == 1) {
            Board.setNodeList(Maps.createMap1(Board.getGraph()));
            Board.setPlayer(new Player(Board.getNodeList().get(0)));
            //new Bus(Maps.getJ4(),0);
            new Bus(new BusRoute(BusNumber.J4, true, new ArrayList<>(Maps.getJ4Route())), 0);
            new Bus(new BusRoute(BusNumber.J4, true, new ArrayList<>(Maps.getJ4Route())), 150);
            new Bus(new BusRoute(BusNumber.J4, false, new ArrayList<>(Maps.getJ4Route())), 10);
            new Bus(new BusRoute(BusNumber.J4, false, new ArrayList<>(Maps.getJ4Route())), 140);

            new Bus(new BusRoute(BusNumber.W31, true, new ArrayList<>(Maps.getW31Route())), 60);
            new Bus(new BusRoute(BusNumber.W31, true, new ArrayList<>(Maps.getW31Route())), 210);
            new Bus(new BusRoute(BusNumber.W31, false, new ArrayList<>(Maps.getW31Route())), 180);
        }
    }

    public String getDescription() {
        return "Level " + number;
    }

    public int getGemTarget() {
        return gemTargetMultiplier * number;
    }

    public int getGemsObtained() {
        return gemsObtained;
    }

    public void addGem() {
        gemsObtained++;
    }
}
