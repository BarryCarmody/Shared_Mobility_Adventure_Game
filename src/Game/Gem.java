package Game;

import java.awt.*;

public class Gem {

    private Node location;

    private static final int PWIDTH=18;

    private static final int PHEIGHT=24;

    private boolean collected;

    private boolean visible;

    private int value;

    private boolean endGate;

    public Gem(Node location){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=100;
        this.endGate=false;
    }

    public Gem(Node location, int value){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=value;
        this.endGate=false;
    }

    public Gem(Node location, int value, boolean gate){
        this.location=location;
        this.collected=false;
        this.visible=false;
        this.value=value;
        this.endGate=gate;
    }

    public void draw(Graphics g){
        if (endGate){
            g.setColor(Color.CYAN);
            g.drawOval(location.getX()-15, location.getY()-15, 30,30);

        }else {
            g.setColor(Color.CYAN);
            int[] xPoints = {Math.round(location.getX()), Math.round(location.getX() + PWIDTH / 2), Math.round(location.getX()), Math.round(location.getX() - PWIDTH / 2)};
            int[] yPoints = {Math.round(location.getY() - PHEIGHT / 2), Math.round(location.getY()), Math.round(location.getY() + PHEIGHT / 2), Math.round(location.getY())};

            g.fillPolygon(xPoints, yPoints, 4);
        }
    }

    public void pickUp(){
        setVisible(false);
        setCollected(true);
        Score.incrementLevelScore(value);
        Level.setGemsCollected(Level.getGemsCollected()+1);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Node getLocation() {
        return location;
    }

    public boolean isEndGate() {
        return endGate;
    }
}
