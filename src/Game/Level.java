package Game;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public int number;

    private static Bike bike;

    private static boolean bikeFilter = true;

    private static boolean busFilter = true;

    public static List<Button> buttonList = new ArrayList<>();

    public Level(int number){
        this.number=number;
        initLevel();
    }

    public static void setBike(Bike bike) {
        Level.bike = bike;
    }

    public static Bike getBike() {
        return bike;
    }

    public void initLevel(){
        if (number==1){
            Board.setNodeList(Maps.createMap1(Board.getGraph()));
            Board.setPlayer(new Player(Board.getNodeList().get(0)));
            //new Bus(Maps.getJ4(),0);
            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),0);
            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),150);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),10);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),140);

            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),60);
            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),210);
            new Bus(new BusRoute(BusNumber.W31,false,new ArrayList<>(Maps.getW31Route())),180);

            Button buttonTitle=new Button(1230,30,40,250,"Select Transport");
            buttonList.add(buttonTitle);
            Button bikeButton=new Button(1230,80,80,250,"Include Bike in Route","Bike");
            buttonList.add(bikeButton);
            Button busButton=new Button(1230,170,80,250,"Include Bus in Route","Bus");
            buttonList.add(busButton);
        }
    }

    public static List<Button> getButtonList() {
        return buttonList;
    }

    public static boolean isBikeFilter() {
        return bikeFilter;
    }

    public static void setBikeFilter(boolean bikeFilter) {
        Level.bikeFilter = bikeFilter;
    }

    public static boolean isBusFilter() {
        return busFilter;
    }

    public static void setBusFilter(boolean busFilter) {
        Level.busFilter = busFilter;
    }
}
