package Game;

import java.awt.*;
import java.util.Objects;

public class Button {

    private int x;

    private int y;

    private int height;

    private int width;

    private String type;

    private boolean selected;

    private String content;


    public Button(int x, int y, int height, int width, String content){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.type="Text";
        this.content=content;
    }

    public Button(int x, int y, int height, int width, String content, String type){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.type=type;
        this.content=content;
        this.selected=true;
    }

    public void draw(Graphics g) {
        if(Objects.equals(this.type, "Text")) {
            g.setColor(Color.YELLOW);
        }else if(selected) {
            g.setColor(Color.WHITE);
        }else{
            g.setColor(Color.lightGray);
        }
        g.fillRect(getX(),getY(),getWidth(),getHeight());

        g.setColor(Color.BLUE);
        g.drawRect(getX(),getY(),getWidth(),getHeight());

        //Add Text
        g.setColor(Color.BLUE);
        FontMetrics fm = g.getFontMetrics();
        int textX=getX() + (getWidth() - fm.stringWidth(content))/2;
        int textY=getY() + ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(content, textX, textY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public String getType() {
        return type;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
