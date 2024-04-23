package Game;

import java.awt.*;
import javax.swing.*;

public class Gem {

    private Node location;

    private static final int PWIDTH=18;

    private static final int PHEIGHT=24;

    private boolean collected;

    private boolean visible;

    private int value;

    private Image gemImage;

    public Gem(Node location){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=100;
        loadImage();
    }

    public Gem(Node location, int value){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=value;
    }

    public void draw(Graphics g) {
        if (visible && gemImage != null) {
            int x = location.getX() - PWIDTH / 2;
            int y = location.getY() - PHEIGHT / 2;
            g.drawImage(gemImage, x, y, null);
        }
    }

    public void pickUp(){
        setVisible(false);
        setCollected(true);
        Score.incrementLevelScore(value);
        Level.setGemsCollected(Level.getGemsCollected()+1);
    }

    public void loadImage(){
        ImageIcon gemIcon=new ImageIcon("C:/Users/Justh/IdeaProjects/BarrysGame/src/Game/Images/diamond-417896_1280.png");
        Image newpic=gemIcon.getImage();
        int scaledWidth = 30;  // Desired width
        int scaledHeight = 30;
        gemImage=newpic.getScaledInstance(scaledWidth,scaledHeight,Image.SCALE_DEFAULT);

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
