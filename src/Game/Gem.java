package Game;

import java.awt.*;

public class Gem {

    private Node location;

    private static final int PWIDTH=18;

    private static final int PHEIGHT=24;

    private boolean collected;

    private boolean visible;

    private int value;

    public Gem(Node location){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=100;
    }

    public Gem(Node location, int value){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=value;
    }

    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        int[] xPoints={Math.round(location.getX()), Math.round(location.getX()+PWIDTH/2), Math.round(location.getX()), Math.round(location.getX()-PWIDTH/2)};
        int[] yPoints={Math.round(location.getY()-PHEIGHT/2), Math.round(location.getY()), Math.round(location.getY()+PHEIGHT/2),  Math.round(location.getY())};

        g.fillPolygon(xPoints,yPoints,4);
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
}
