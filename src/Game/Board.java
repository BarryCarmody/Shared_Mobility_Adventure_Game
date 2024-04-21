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

import static Game.BusNumber.J4;
import static java.lang.Math.round;

public class Board extends JPanel implements MouseListener, MouseMotionListener{

    private Dimension boardSize;
    private Player player;

    private Bus bus1;

    private Maps graph;

    private Image backgroundImage;

    private Timer timer;

    private JLabel coordinatesLabel;

    private Node targetNode;

    private List<Node> nodeList;

    private List<Line2D> routeLines = new ArrayList<>();

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
        setBackground(Color.BLACK);

        try {
            backgroundImage = ImageIO.read(new File("C:/Users/Justh/OneDrive/Documents/MScComputerScience/Semester2/Java_COMP30820/Project/BarrysGame/src/Game/Images/full.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

        gameInit();

        coordinatesLabel = new JLabel("X: 0 Y: 0");
        coordinatesLabel.setForeground(Color.WHITE);
        add(coordinatesLabel);

        //addMouseMotionListener(this);
    }

    private void gameInit() {

        graph = new Maps();
        nodeList= Maps.createMap1(graph);
        bus1= new Bus(Maps.getJ4());
        player=new Player(nodeList.get(16));

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
        //player.route= new ArrayList<>();
        //player.route = Map.routeBetweenNodes(graph,player.currentNode,destination);
        player.moving=true;
    }

    private void drawPlayer(Graphics p){
        if (player.isVisible()){
            player.draw(p);
        }
    }

    private void drawNodes(Graphics p){
        for (Node selectedNode: nodeList){
            selectedNode.draw(p);
        }
    }

    private void drawBuses(Graphics p){
        for (Bus bus: Bus.getBusList()){
            bus.draw(p);
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

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
        player.act();
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
        if (!player.moving) {
            for (Node node : graph.getNodes()) {
                Rectangle nodeBox = new Rectangle(node.getX() - 20, node.getY() - 20, 30, 30);
                //int nodeNum = nodeNumber(node);
                if (nodeBox.contains(e.getPoint())) {
                    System.out.println("Node clicked: " + node);
                    targetNode = node;
                    repaint();
                    break;
                }
            }
        }
        System.out.println("Route from " + player.currentNode +" to: "+targetNode);
        resetNodeDist();
        nextLocation(targetNode);
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
                System.out.println("ON");
                //nextLocation(targetNode);

            } else if (key==KeyEvent.VK_UP) {
                goThere(targetNode);
            }
        }
    }
}
