package Menu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ML extends MouseAdapter implements MouseMotionListener {
    public boolean isPressed = false;
    public int x = 0, y = 0;

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public boolean isPressed() {
        return this.isPressed;
    }

    public boolean isInRectangle(final Rectangle rectangle) {
        return this.x >= rectangle.x && this.x <= rectangle.x + rectangle.width &&
                this.y >= rectangle.y && this.y <= rectangle.y + rectangle.height;
    }
}
