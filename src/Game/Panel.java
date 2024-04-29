package Game;

import java.awt.*;
import java.util.Objects;

public class Panel {

    private final int x;

    private int y;

    private int height;

    private final int width;

    private final String type;

    private String content;


    public Panel(int x, int y, int height, int width, String content){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.type="Text";
        this.content=content;
    }

    public Panel(int x, int y, int height, int width, String content, String type){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.type=type;
        this.content=content;
    }

    public void draw(Graphics g) {
        if(Objects.equals(this.type, "Text")) {
            g.setColor(Color.YELLOW);
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "backdrop")){
            g.setColor(Color.WHITE);

            g.fillRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "Container")){
            g.setColor(Color.BLACK);

            g.fillRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "Bar")){
            g.setColor(Color.RED);

            g.fillRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "Car")&&Level.isCarFilter()) {
            g.setColor(Color.WHITE);
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "Bus")&&Level.isBusFilter()) {
            g.setColor(Color.WHITE);
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "Bike")&&Level.isBikeFilter()) {
            g.setColor(Color.WHITE);
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else{
            g.setColor(Color.lightGray);
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());
        }

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

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
