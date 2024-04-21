package Game;

import java.awt.*;

public class GEM {
    private int value;
    private boolean collected;
    private Point position;

    public GEM(int value, Point position) {
        this.value = value;
        this.collected = false;
        this.position = position;
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

    public void draw(Graphics g) {
        if (!collected) {
            g.setColor(Color.BLUE);
            g.fillOval(position.x, position.y, 10, 10); // Adjust size as needed
        }
    }
}
