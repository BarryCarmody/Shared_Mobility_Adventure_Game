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
import Game.Commons;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class Board extends JPanel implements MouseMotionListener{

    private Dimension boardSize;
    private Player player;

    private Map graph;

    private Image backgroundImage;

    private Timer timer;

    private JLabel coordinatesLabel;

    private List<Node> nodeList;

    private List<Line2D> routeLines = new ArrayList<>();

    public Board(){

        initBoard();
        setFocusable(true);

    }
    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        boardSize= new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setBackground(Color.BLACK);

        try {
            backgroundImage = ImageIO.read(new File("C:/Users/barry/OneDrive/Desktop/Notes/Semester2/COMP30820/Ass/GAYM/src/Game/Images/full.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

        gameInit();

        coordinatesLabel = new JLabel("X: 0 Y: 0");
        coordinatesLabel.setForeground(Color.WHITE);
        add(coordinatesLabel);

        addMouseMotionListener(this);
    }

    private void gameInit() {

        graph = new Map();
        nodeList=Map.createLevel1(graph);
        player=new Player(nodeList.get(0));

    }

    private void nextLocation(Node destination){
        List<Node> route = Map.routeBetweenNodes(graph,player.currentNode,destination);
        route.add(destination);

        for (int i=0; i<route.size() -1; i++){
            Node base=route.get(i);
            Node step=route.get(i+1);

            Line2D line = new Line2D.Double(base.getX(), base.getY(), step.getX(), step.getY());
            routeLines.add(line);
            repaint();
        }

    }

    private void getThere(Node destination) {
        player.route = Map.routeBetweenNodes(graph,player.currentNode,destination);
        player.route.add(destination);
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
        drawPlayer(g);
        drawRouteLines(g);

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
                nextLocation(nodeList.get(19));
            } else if (key==KeyEvent.VK_UP) {
                getThere(nodeList.get(19));
            }
        }
    }
}
