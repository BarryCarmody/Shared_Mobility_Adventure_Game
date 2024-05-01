package Game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.SplashScreen;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.geom.Line2D;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Rectangle;
import java.util.Objects;

import Menu.PopupScreen;
import Menu.LevelCompletePopup;

public class Board extends JPanel implements MouseListener, MouseMotionListener{

    private Dimension boardSize;
    private static Player player;

    //private static Bus bus1;

    private static Maps graph;

    private Image backgroundImage;

    private Timer timer;

    private JLabel coordinatesLabel;

    private static List<Node> nodeList;

    private HashMap<Line2D,String> routeLine = new HashMap<Line2D,String>();

    private static boolean active;

    private Level level;

    private ArrayList<Object[]> routeTransports;

    private List<Panel> routePanels = new ArrayList<>();

    private Leaderboard leaderboard;

    private Education edu;

    public Board(){

        initBoard();
        edu = new Education();
        leaderboard = new Leaderboard();
        setFocusable(true);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        boardSize= new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setBackground(new Color(80,80,80));

        gameInit();

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

//        startMusic();

        coordinatesLabel = new JLabel("X: 0 Y: 0");
        coordinatesLabel.setForeground(Color.BLACK);
        add(coordinatesLabel);

    }

    private void gameInit() {
            graph = new Maps();
            level = new Level(1);

        }


    public static boolean getActive(){
        return active;
    }

    public static void setActive(boolean active) {
        Board.active = active;
    }

    private void nextLocation(Node destination){
        resetNodeDist();
        if (player.route!=null) {
            player.route.clear();
        }

        player.route = Maps.routeBetweenNodes(graph,player.currentNode,destination);

        int t=player.getCurrentSpotOnRouteInv();
        List<Node> temp=new ArrayList();
        for (int i=t; i<player.route.size(); i++){
            temp.add(player.route.get(i));
        }
        player.route=temp;

        routeLine.clear();
        routeLine=new HashMap<>();

        player.route.add(destination);

        for (int i=0; i<player.route.size()-1; i++){
            Node base=player.route.get(i);
            Node step=player.route.get(i+1);

            String transport=base.getTransportType();
            Line2D line = new Line2D.Double(base.getX(), base.getY(), step.getX(), step.getY());

            routeLine.put(line,transport);

            repaint();
        }
    }


    private void goThere(Node destination) {
        routeLine.clear();

        //Check if Taxi needs to be called
        for(Node node: player.getRoute()){
            if(Objects.equals(node.getTransportType(), "Car")){
                Car.callTaxi(node);
                break;
            }
        }


        setActive(true);
        player.moving=true;
        for (Bus bus: Bus.getBusList()){
            bus.setMoving(true);
        }

    }

    public void startMusic() {
       
        javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
            Music.loadMusic("Game/Music/Dreams.wav");
            Music.playMusic();
            // Cast the source to Timer and stop it
            ((javax.swing.Timer)e.getSource()).stop();
        });
        timer.setRepeats(false); 
        timer.start();
    }


    private void drawPlayer(Graphics p){
        if (player.isVisible()){
            player.drawPlayer(p);
        }
    }

    private void drawNodes(Graphics p){

        //Draw Main Nodes First
        for (Node selectedNode: nodeList){
            if(Objects.equals(selectedNode.getTransportType(), "Walk")) {
                selectedNode.drawLinks(p);
            }
        }

        for (Node selectedNode: nodeList){
            if(Objects.equals(selectedNode.getTransportType(), "Car")) {
                selectedNode.drawLinks(p);
            }
        }

        for (Node selectedNode: nodeList){
            if(Objects.equals(selectedNode.getTransportType(), "Walk")) {
                selectedNode.drawTransport(p);
            }
        }

        //Layer Special Nodes After
        for (Node selectedNode: nodeList){
            if(selectedNode.getTransportStop()) {
                selectedNode.drawTransport(p);
            }
        }
    }

    private void drawBuses(Graphics p){
        for (Bus bus: Bus.getBusList()){
            bus.drawBus(p);
        }
    }

    private void drawBikes(Graphics p){
        if(Level.getBike()!=null){
            Level.getBike().drawBike(p);
        }
    }

    private void drawCars(Graphics p){
//        if (Car.taxi != null) {
//            Car.taxi.drawCar(p);
//        }
        for (Car car: Car.getCarList()){
            if(car.getVisible()) {
                car.drawCar(p);
            }
        }
    }

    private void drawRouteLines(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3.0f));

        for(Line2D line: routeLine.keySet()){
            if(Objects.equals(routeLine.get(line), "Bike")) {
                g2d.setColor(Color.GREEN);
            }else if(Objects.equals(routeLine.get(line), "Bus")) {
                g2d.setColor(Color.YELLOW);
                g2d.setStroke(new BasicStroke(5.0f));
            }else if(Objects.equals(routeLine.get(line), "Car")) {
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(5.0f));
            }else {
                g2d.setColor(Color.BLUE);
            }
            g2d.draw(line);
        }

    }

    private void drawButtons(Graphics g){
        for (Panel button: Level.getButtonList()){
            button.draw(g);
        }
        for (Panel panel: routePanels){
            panel.draw(g);
        }
    }

    private void drawCo2Bar(Graphics g){
        player.getCo2Bar().draw(g);

    }

    private void drawGems(Graphics g){
        for (Gem gem: Level.gemList){
            if (gem.isVisible()) {
                gem.draw(g);
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);

        doDrawing(g);
    }

    //Generate the Route Panels
    private void generateRoutePanels(){
        routeTransports= new ArrayList<>();
        Object[] currentTransport= new Object[4];

        for (int i=0; i<player.route.size()-1;i++){
            if (i == 0) {
                if(Objects.equals(player.route.get(1).getTransportType(), "Walk")){
                    currentTransport=new Object[]{"Walk",player.route.get(0),player.route.get(1),player.route.get(0).calculateDistance(player.route.get(1))}; //{Transport Type, Start node, End node, Distance}
                }else{
                    currentTransport=new Object[]{player.route.get(1).getTransportType(),player.route.get(1),player.route.get(1),0};
                }
            }else if(Objects.equals(player.route.get(i).getTransportType(), player.route.get(i+1).getTransportType())){
                currentTransport[2]=player.route.get(i+1); //Adjust End Node of transport
                currentTransport[3]=(int) currentTransport[3]+player.route.get(i).calculateDistance(player.route.get(i+1));
            }else{
                routeTransports.add(currentTransport);
                currentTransport=new Object[]{player.route.get(i+1).getTransportType(),player.route.get(i+1),player.route.get(i+1),0};
            }
        }
        if(Objects.equals(player.route.get(player.route.size()-2).getTransportType(), "Walk")){
            routeTransports.add(currentTransport);
        }

        routePanels.clear();
        int height=70;
        int i=0;
        for (Object[] transport: routeTransports) {
            Node node=(Node) transport[1];
            int estTime;
            int estCO2;
            int estCO2upper;
            String C02string;
            if (Objects.equals(node.getTransportType(), "Walk")){
                estTime= (int) Math.ceil((int) transport[3]/Sprite.speed/10)+1;
                estCO2=0;
                estCO2upper=0;
                C02string="0%";
            }else if (Objects.equals(node.getTransportType(), "Bike")){
                estTime= (int) Math.ceil((int) transport[3]/Bike.speed/10)+1;
                estCO2=0;
                estCO2upper=0;
                C02string="0%";
            }else if (Objects.equals(node.getTransportType(), "Bus")) {
                estTime = (int) Math.ceil((int) transport[3]/Bus.speed/10)+1;
                estCO2=(estTime*Bus.getCo2Emission()*1000)/Player.getCo2max();
//                estCO2upper=estCO2+2;
//                C02string=estCO2+"% - "+estCO2upper+"%";
                C02string=estCO2+"%";
            }else {
                estTime = (int) Math.ceil((int) transport[3]/Car.speed/10)+1;
                estCO2=(estTime*Car.getCo2Emission()*1000)/Player.getCo2max()+3;
//                estCO2upper=estCO2+6;
//                C02string=estCO2+"% - "+estCO2upper+"%";
                C02string=estCO2+"%";
            }

            String content=transport[0].toString()+"NLDistance: "+transport[3].toString()+"NLTravel Time: "+estTime+"NLEstimated CO2: "+C02string;
            routePanels.add(new Panel(Commons.BOARD_WIDTH-220,380+i*(height+10),height,200, content,"Route"+transport[0].toString()));
            System.out.println(Arrays.toString(transport));
            i+=1;
        }
    }

    private void doDrawing(Graphics g) {

        drawNodes(g);
        drawRouteLines(g);
        drawBuses(g);
        drawBikes(g);
        drawCars(g);
        drawPlayer(g);
        drawGems(g);
        drawButtons(g);
        drawCo2Bar(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
        revealEndGate();
        player.act();
        collectGem();
        level.timeRunning();
        for (Bus bus: Bus.getBusList()){
            bus.act();
        }
        if (Level.getBike() !=null){
            Level.getBike().act();
        }

        if(Car.getCarList().size()>0) {
            for (Car car : Car.getCarList()) {
                car.act();
            }
        }
        Level.updatePanels();
        levelFinished();
        gameOver();
    }

    private void doGameCycle() {
        update();
        repaint();
    }

    private void levelFinished(){
        // if player is at the of a level
        if (player.getCurrentNode()==Level.gemList.get(Level.gemList.size()-1).getLocation()&&!active) {

            level.nextLevel();
            Gem.loadGemSound("Game/Music/coin_pick_up_project.wav");
            Gem.playGemSound();
            edu.presentQuestion();
            final PopupScreen levelCompletePopup = new LevelCompletePopup(level);
            levelCompletePopup.setRelativeContainer(this);
            levelCompletePopup.drawPopupScreen();
            System.out.println(Score.getScore());
            level.nextLevel();
        }

    }


//    private void gameOver(){
//        if(level.getTime()==0||player.getCo2level()==0){
//            setActive(false);
//            System.out.println("LOSER");
//        }
//    }

    private void gameOver() {
        if ((level.getTime() == 0 || player.getCo2level() == 0) && !leaderboard.isDisplayed()) {
            setActive(false);
            leaderboard.promptForInitialsAndDisplay();  // only display leaderboard if it hasn't been already displayed
            System.out.println("LOSER");
        }
    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }

    }



    public int nodeNumber(Node checkNode){
        for (int i=0; i<nodeList.size();i++){
            if (checkNode.equals(nodeList.get(i))){
                return i;
            }
        }
        return -1;
    }

    public static void resetNodeDist(){
        for (Node n: nodeList){
            n.setDistance(Integer.MAX_VALUE);
        }
    }

    public void collectGem(){
        for (Gem gem: Level.gemList) {
            //Collects when player is walking
            if (player.getCurrentNode()==gem.getLocation()&&player.isVisible()&&!gem.isCollected()) {
                if(!gem.isEndGate()){
                    gem.pickUp();
                }

                //Level.updatePanels();


            }else if(Level.getBike()!=null){
                //Collects when player is on bike
                if(Level.getBike().getCurrentNode().getX()==gem.getLocation().getX()&&Level.getBike().getCurrentNode().getY()==gem.getLocation().getY()&&!gem.isCollected()) {
                    gem.pickUp();
                    //Level.updatePanels();

                }
            }
        }
    }

    public void revealEndGate(){
        if(Level.getGemsCollected()>=Level.getGemThreshold()){
            Level.gemList.get(Level.gemList.size()-1).setVisible(true);
        }
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Board.player = player;
    }

    public static List<Node> getNodeList() {
        return nodeList;
    }

    public static void setNodeList(List<Node> nodeList) {
        Board.nodeList = nodeList;
    }

    public static Maps getGraph() {
        return graph;
    }

    public static void setGraph(Maps graph) {
        Board.graph = graph;
    }

    @Override
    //Action if mouse clicked
    public void mouseClicked(MouseEvent e){
        for(Panel button: Level.getButtonList()){
            if(!Objects.equals(button.getType(),"Text")) {
                Rectangle buttonBox = new Rectangle(button.getX(), button.getY(), button.getWidth(), button.getHeight());
                if(buttonBox.contains(e.getPoint())){
                    if(Objects.equals(button.getType(),"Bike")){
                        routeLine.clear();
                        Level.setBikeFilter(!Level.isBikeFilter());
                    }else if(Objects.equals(button.getType(),"Bus")){
                        routeLine.clear();
                        Level.setBusFilter(!Level.isBusFilter());
                    }else if(Objects.equals(button.getType(),"Car")){
                        routeLine.clear();
                        Level.setCarFilter(!Level.isCarFilter());
                    }
                }
            }
        }
        //Click on Node set as target node and plan the route
        if (!active) {
            for (Node node : graph.getNodes()) {
                if(Objects.equals(node.getTransportType(), "Walk")) {
                    Rectangle nodeBox = new Rectangle(node.getX() - 20, node.getY() - 20, 30, 30);
                    //int nodeNum = nodeNumber(node);
                    if (nodeBox.contains(e.getPoint())) {
                        if(player.route!=null){
                            player.route.clear();
                        }
//                        System.out.println("Node clicked: " + node);
                        player.setTargetNode(node);
                        //repaint();
                        break;
                    }
                }
            }
        }
        if(player.getTargetNode()!=null) {
//            System.out.println("Resetting");
            //resetNodeDist();
            nextLocation(player.getTargetNode());
            generateRoutePanels();
        }
    }

    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseMoved(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        coordinatesLabel.setText("X: "+x+" Y: "+y);
    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    private class TAdapter extends KeyAdapter {


        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();


            if (key==KeyEvent.VK_RIGHT){
                System.out.println(nodeList);
                System.out.println(nodeList.get(107));

            } else if (key==KeyEvent.VK_SPACE) {
                if(!active) {
                    goThere(player.getTargetNode());
                }
                System.out.println("Player Route is "+player.route);
            }
//            else if (key==KeyEvent.VK_DOWN) {
//                player.route.clear();
//                resetNodeDist();
//                routeLine.clear();
//            }


        }
    }
}
