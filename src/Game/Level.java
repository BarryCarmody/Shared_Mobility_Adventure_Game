package Game;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {

    private int gemTargetMultiplier = 100;
    private int gemsObtained = 0;

    public int number;

    private static Bike bike;

    private static boolean bikeFilter = false;

    private static boolean busFilter = false;

    private static boolean carFilter = false;

    private static int gemsAvailable;

    private static int gemThreshold;

    private static int gemsCollected;


    public static List<Panel> buttonList = new ArrayList<>();

    public static List<Gem> gemList = new ArrayList<>();

    private static int time;

    public Level(int number) {
        this.number = number;
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
            setGemThreshold(1);
            gemsAvailable=3;
            time=2000;

        }else{
            setGemThreshold(3);
            gemsAvailable=12;
            time=1500;
        }

        Score.setLevelscore(0);
        Board.setNodeList(Maps.createMap1(Board.getGraph()));
        Node startNode=Board.getNodeList().get(0);

        Board.setPlayer(new Player(startNode));

        Bus.busList.clear();

        new Bus(new BusRoute(BusNumber.J4, true, new ArrayList<>(Maps.getJ4Route())), 0);
        new Bus(new BusRoute(BusNumber.J4, true, new ArrayList<>(Maps.getJ4Route())), 150);
        new Bus(new BusRoute(BusNumber.J4, false, new ArrayList<>(Maps.getJ4Route())), 10);
        new Bus(new BusRoute(BusNumber.J4, false, new ArrayList<>(Maps.getJ4Route())), 140);

        new Bus(new BusRoute(BusNumber.W31, true, new ArrayList<>(Maps.getW31Route())), 60);
        new Bus(new BusRoute(BusNumber.W31, true, new ArrayList<>(Maps.getW31Route())), 210);
        new Bus(new BusRoute(BusNumber.W31, false, new ArrayList<>(Maps.getW31Route())), 180);


        Panel Backdrop=new Panel(Commons.BOARD_WIDTH-220,30,Commons.BOARD_HEIGHT-90,200,"", "backdrop");
        buttonList.add(Backdrop);

        Panel time=new Panel(Commons.BOARD_WIDTH-220,30,40,200,"Time Remaining: 0");
        buttonList.add(time);
        Panel levelScore=new Panel(Commons.BOARD_WIDTH-220,80,40,200,"Level Score: 0");
        buttonList.add(levelScore);
        Panel gemsRequired=new Panel(Commons.BOARD_WIDTH-220,130,40,200,"Gems Required: 0/"+getGemThreshold());
        buttonList.add(gemsRequired);
        Panel panelTitle =new Panel(Commons.BOARD_WIDTH-220,180,40,200,"Select Transport");
        buttonList.add(panelTitle);
        Panel bikeButton=new Panel(Commons.BOARD_WIDTH-220,230,40,200,"Include Bike in Route","Bike");
        buttonList.add(bikeButton);
        Panel busButton=new Panel(Commons.BOARD_WIDTH-220,280,40,200,"Include Bus in Route","Bus");
        buttonList.add(busButton);
        Panel carButton=new Panel(Commons.BOARD_WIDTH-220,330,40,200,"Include Car in Route","Car");
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
        gemList.clear();
        Random random=new Random();

        while (gemList.size()<=gemsAvailable){
            //Generates random int between 0 and 107 (number of walkable nodes)
            int randomNumber= random.nextInt(108);

            //Check if there is any current Gems too close
            boolean flag =false;

            if(eucDist(startNode,Board.getNodeList().get(randomNumber))>Math.min(1500/Level.gemsAvailable+1,400)) {
                if (gemList.isEmpty()) {
                    gemList.add(new Gem(Board.getNodeList().get(randomNumber)));

                } else {

                    for (Gem gem : gemList) {
                        if (eucDist(gem.getLocation(), Board.getNodeList().get(randomNumber)) < Math.min(1500/Level.gemsAvailable+1,400)) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        if(gemsAvailable-gemList.size()<=1) {
                            gemList.add(new Gem(Board.getNodeList().get(randomNumber), 250, true));
                        }else{
                            gemList.add(new Gem(Board.getNodeList().get(randomNumber)));
                        }
                    }
                }
            }
        }
    }

    public void nextLevel(){
        Score.setScore(Score.getScore()+Score.getLevelscore());

        number+=1;
        Score.setLevelscore(0);
        setGemsCollected(0);


        time=Math.max(1600-number*50,1000);
        //inverse triangular
        int temp=number;
        int i=1;
        while (temp>0) {
            temp-=i;
            i+=1;
        }
        setGemThreshold(i-1);
        gemsAvailable=getGemThreshold()+3;

        gemList.clear();
        Random random=new Random();

        while (gemList.size()<gemsAvailable){
            //Generates random int between 0 and 107 (number of walkable nodes)
            int randomNumber= random.nextInt(108);

            //Check if there is any current Gems too close
            boolean flag =false;

            if(eucDist(Board.getPlayer().currentNode, Board.getNodeList().get(randomNumber))>Math.min(1500/Level.gemsAvailable+1,400)) {
                if (gemList.isEmpty()) {
                    gemList.add(new Gem(Board.getNodeList().get(randomNumber)));
                } else {

                    for (Gem gem : gemList) {
                        if (eucDist(gem.getLocation(), Board.getNodeList().get(randomNumber)) < Math.min(1500/Level.gemsAvailable+1,400)) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        if(gemsAvailable-gemList.size()<=1) {
                            gemList.add(new Gem(Board.getNodeList().get(randomNumber), 250, true));
                            System.out.println("I Make GEM");
                        }else{
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

    //Makes the timer work
    public void timeRunning(){
        if (Board.getActive()){
            time=Math.max(0,time-1);
            System.out.println(time);
        }
    }


    public static void updatePanels() {
        buttonList.get(1).setContent("Time Remaining: "+ time/10);
        buttonList.get(2).setContent("Level Score: " + Score.getLevelscore());
        buttonList.get(3).setContent("Gems Required: "+getGemsCollected()+"/"+getGemThreshold());
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

    public int getTime() {
        return time;
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
