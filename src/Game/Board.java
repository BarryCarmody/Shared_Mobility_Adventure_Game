package Game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Toolkit;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.util.Objects;

public class Board extends JPanel implements MouseListener, MouseMotionListener{

    private Dimension boardSize;
    private static Player player;

    //private static Bus bus1;

    private static Maps graph;

    private Image backgroundImage;

    private Timer timer;

    private JLabel coordinatesLabel;

    private static List<Node> nodeList;

    private List<Line2D> routeLines = new ArrayList<>();

    private static boolean active;

    private Level level;

    public Board(){

        initBoard();
        setFocusable(true);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        boardSize= new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setBackground(Color.LIGHT_GRAY);

//        try {
//            backgroundImage = ImageIO.read(new File("C:/Users/barry/OneDrive/Desktop/Notes/Semester2/COMP30820/Ass/GAYM/src/Game/Images/full.png"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

        gameInit();

        coordinatesLabel = new JLabel("X: 0 Y: 0");
        coordinatesLabel.setForeground(Color.BLACK);
        add(coordinatesLabel);

        //addMouseMotionListener(this);
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
        if (player.route!=null) {
            player.route.clear();
        }

        player.route = Maps.routeBetweenNodes(graph,player.currentNode,destination);
        routeLines.clear();
        routeLines= new ArrayList<>();

        player.route.add(destination);

        for (int i=0; i<player.route.size()-1; i++){
            Node base=player.route.get(i);
            Node step=player.route.get(i+1);

            Line2D line = new Line2D.Double(base.getX(), base.getY(), step.getX(), step.getY());
            routeLines.add(line);
            repaint();
        }
        System.out.println(player.route);
    }

    private void goThere(Node destination) {
        routeLines.clear();
        setActive(true);
        player.moving=true;
        for (Bus bus: Bus.getBusList()){
            bus.setMoving(true);
        }

    }

    private void drawPlayer(Graphics p){
        if (player.isVisible()){
            player.draw(p);
        }
    }

    private void drawNodes(Graphics p){

        //Draw Main Nodes First
        for (Node selectedNode: nodeList){
            if(Objects.equals(selectedNode.getTransportType(), "Walk")) {
                selectedNode.drawLinks(p);
                selectedNode.draw(p);
            }
        }

        //Layer Special Nodes After
        for (Node selectedNode: nodeList){
            if(selectedNode.getTransportStop()) {
                selectedNode.draw(p);
            }
        }
    }

    private void drawBuses(Graphics p){
        for (Bus bus: Bus.getBusList()){
            bus.draw(p);
        }
    }

    private void drawBikes(Graphics p){
        if(Level.getBike()!=null){
            Level.getBike().draw(p);
        }
    }

    private void drawRouteLines(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(4.0f));

        for (Line2D line: routeLines){
            g2d.draw(line);
        }
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        drawNodes(g);
        drawRouteLines(g);
        drawPlayer(g);
        drawBuses(g);
        drawBikes(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
        player.act();
        for (Bus bus: Bus.getBusList()){
            bus.act();
        }
        if (Level.getBike() !=null){
            Level.getBike().act();
        }
    }

    private void doGameCycle() {
        update();
        repaint();
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

    public void resetNodeDist(){
        for (Node n: nodeList){
            n.setDistance(Integer.MAX_VALUE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (!active) {
            for (Node node : graph.getNodes()) {
                if(Objects.equals(node.getTransportType(), "Walk")) {
                    Rectangle nodeBox = new Rectangle(node.getX() - 20, node.getY() - 20, 30, 30);
                    //int nodeNum = nodeNumber(node);
                    if (nodeBox.contains(e.getPoint())) {
                        System.out.println("Node clicked: " + node);
                        player.setTargetNode(node);
                        repaint();
                        break;
                    }
                }
            }
        }
        //System.out.println("Route from " + player.currentNode +" to: "+targetNode);
        resetNodeDist();
        nextLocation(player.getTargetNode());
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Board.player = player;
    }

//    public static Bus getBus1() {
//        return bus1;
//    }
//
//    public static void setBus1(Bus bus1) {
//        Board.bus1 = bus1;
//    }

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


            if (key==KeyEvent.VK_SPACE){

            } else if (key==KeyEvent.VK_UP) {
                if(!active) {
                    goThere(player.getTargetNode());
                }
            }
        }
    }
}
