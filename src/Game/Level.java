package Game;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {

    public int number;

    private static Bike bike;

    private static boolean bikeFilter = true;

    private static boolean busFilter = true;

    private static boolean carFilter = true;

    private static int gemsAvailable;

    private static int gemThreshold;

    private static int gemsCollected;

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

            Score.setLevelscore(0);
            setGemThreshold(3);
            Board.setNodeList(Maps.createMap1(Board.getGraph()));
            Node startNode=Board.getNodeList().get(56);
            Board.setPlayer(new Player(startNode));

            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),0);
            new Bus(new BusRoute(BusNumber.J4,true,new ArrayList<>(Maps.getJ4Route())),150);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),10);
            new Bus(new BusRoute(BusNumber.J4,false,new ArrayList<>(Maps.getJ4Route())),140);

            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),60);
            new Bus(new BusRoute(BusNumber.W31,true,new ArrayList<>(Maps.getW31Route())),210);
            new Bus(new BusRoute(BusNumber.W31,false,new ArrayList<>(Maps.getW31Route())),180);

            Panel levelScore=new Panel(Commons.BOARD_WIDTH-220,30,40,200,"Level Score: 0");
            buttonList.add(levelScore);
            Panel gemsRequired=new Panel(Commons.BOARD_WIDTH-220,80,40,200,"Gems Required: 0/"+getGemThreshold());
            buttonList.add(gemsRequired);
            Panel panelTitle =new Panel(Commons.BOARD_WIDTH-220,130,40,200,"Select Transport");
            buttonList.add(panelTitle);
            Panel bikeButton=new Panel(Commons.BOARD_WIDTH-220,180,60,200,"Include Bike in Route","Bike");
            buttonList.add(bikeButton);
            Panel busButton=new Panel(Commons.BOARD_WIDTH-220,250,60,200,"Include Bus in Route","Bus");
            buttonList.add(busButton);
            Panel carButton=new Panel(Commons.BOARD_WIDTH-220,320,60,200,"Include Car in Route","Car");
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


            //Create Gems
            Random random=new Random();

            gemsAvailable=6;

            while (gemList.size()<gemsAvailable){
                //Generates random int between 0 and 107 (number of walkable nodes)
                int randomNumber= random.nextInt(108);

                //Check if there is any current Gems too close
                boolean flag =false;

                if(eucDist(startNode,Board.getNodeList().get(randomNumber))>1500/Level.gemsAvailable) {
                    if (gemList.isEmpty()) {
                        gemList.add(new Gem(Board.getNodeList().get(randomNumber)));
                    } else {

                        for (Gem gem : gemList) {
                            if (eucDist(gem.getLocation(), Board.getNodeList().get(randomNumber)) < 1500 / Level.gemsAvailable) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            gemList.add(new Gem(Board.getNodeList().get(randomNumber)));
                        }
                    }
                }
            }
        }
    }

    public int eucDist(Node start, Node destination){
        int xdist = (start.getX()-destination.getX())*(start.getX()-destination.getX());
        int ydist = (start.getY()-destination.getY())*(start.getY()-destination.getY());
        int ed= (int) Math.sqrt(xdist+ydist);

        return ed;
    }


    public static void updatePanels() {
        buttonList.get(0).setContent("Level Score: " + Score.getLevelscore());
        buttonList.get(1).setContent("Gems Required: "+getGemsCollected()+"/"+getGemThreshold());
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

    public static void setGemThreshold(int gemThreshold) {
        Level.gemThreshold = gemThreshold;
    }

    public static int getGemThreshold() {
        return gemThreshold;
    }

    public static int getGemsCollected() {
        return gemsCollected;
    }

    public static void setGemsCollected(int gemsCollected) {
        Level.gemsCollected = gemsCollected;
    }
}
