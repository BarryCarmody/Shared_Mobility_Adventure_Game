package Game;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public int number;

    private static Bike bike;

    private static boolean bikeFilter = true;

    private static boolean busFilter = true;

    private static boolean carFilter = true;

    public static List<Panel> buttonList = new ArrayList<>();

    public static List<Gem> gemList = new ArrayList<>();

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

            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),0);
            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),150);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),10);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),140);

            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),60);
            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),210);
            new Bus(new BusRoute(BusNumber.W31,false,new ArrayList<>(Maps.getW31Route())),180);

            Panel panelTitle =new Panel(Commons.BOARD_WIDTH-220,30,40,200,"Select Transport");
            buttonList.add(panelTitle);
            Panel bikeButton=new Panel(Commons.BOARD_WIDTH-220,80,60,200,"Include Bike in Route","Bike");
            buttonList.add(bikeButton);
            Panel busButton=new Panel(Commons.BOARD_WIDTH-220,150,60,200,"Include Bus in Route","Bus");
            buttonList.add(busButton);
            Panel carButton=new Panel(Commons.BOARD_WIDTH-220,220,60,200,"Include Car in Route","Car");
            buttonList.add(carButton);
            Panel co2Container=new Panel(Commons.BOARD_WIDTH-270, 30,Commons.BOARD_HEIGHT-90,40,"","Container");
            buttonList.add(co2Container);

            Car.setCarGraph(new Maps());
            Car.setCarNodeList(Maps.createMap1(Car.getCarGraph()));

            List<Node> carStart= new ArrayList<Node>();
            carStart.add(Board.getNodeList().get(441));
            carStart.add(Board.getNodeList().get(440));
            carStart.add(Board.getNodeList().get(439));
            carStart.add(Board.getNodeList().get(438));
            carStart.add(Board.getNodeList().get(437));
            carStart.add(Board.getNodeList().get(436));
            carStart.add(Board.getNodeList().get(435));
            carStart.add(Board.getNodeList().get(434));
            carStart.add(Board.getNodeList().get(433));
            carStart.add(Board.getNodeList().get(432));
            Car.setPotentialStarts(carStart);

            Gem G1 = new Gem(Board.getNodeList().get(43));
            gemList.add(G1);

            Gem G2 = new Gem(Board.getNodeList().get(93));
            gemList.add(G2);

        }
    }

    public static List<Panel> getButtonList() {
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

    public static boolean isCarFilter() {
        return carFilter;
    }

    public static void setCarFilter(boolean carFilter) {
        Level.carFilter = carFilter;
    }

}
