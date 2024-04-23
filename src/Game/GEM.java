package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GEM {
    private int value=1000;
    private boolean collected;
    private Point position;
    private Image gemImage;

    public GEM(int value) {
        Random rand=new Random();
        this.value = value;
        this.collected = false;
        this.position = new Point(rand.nextInt(Commons.BOARD_WIDTH),rand.nextInt(Commons.BOARD_HEIGHT));
        loadImage();
    }

    public int getValue() {
        return value;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void loadImage(){
        ImageIcon gemIcon=new ImageIcon("C:/Users/Justh/OneDrive/Documents/MScComputerScience/Semester2/Java_COMP30820/Project/BarrysGame/src/Game/Images/yellowgem.png");
        Image newpic=gemIcon.getImage();
        int scaledWidth = 30;  // Desired width
        int scaledHeight = 30;
        gemImage=newpic.getScaledInstance(scaledWidth,scaledHeight,Image.SCALE_DEFAULT);

    }

    public void drawGEM(Graphics g) {
        if (!collected) {
            g.drawImage(gemImage,position.x,position.y, null);
        }
    }

};



