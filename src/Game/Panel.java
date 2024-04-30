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

        }else if(Objects.equals(this.type, "RouteWalk")) {
            g.setColor(new Color(153, 255, 255));
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "RouteBus")) {
            g.setColor(new Color(255, 255, 153));
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.YELLOW);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "RouteBike")) {
            g.setColor(new Color(153, 255, 153));
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.GREEN);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

        }else if(Objects.equals(this.type, "RouteCar")) {
            g.setColor(new Color(255, 153, 153));
            g.fillRect(getX(),getY(),getWidth(),getHeight());

            g.setColor(Color.RED);
            g.drawRect(getX(),getY(),getWidth(),getHeight());

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
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int textX;
        int textY;
        if (Objects.equals(type, "RouteWalk")||Objects.equals(type, "RouteBike")||Objects.equals(type, "RouteBus")||Objects.equals(type, "RouteCar")) {
            textX = getX()+5;
            textY = getY() +2+ fm.getAscent();
        }else{
            textX = getX() + (getWidth() - fm.stringWidth(content))/2;
            textY = getY() + ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        }
        String[] lines= content.split("NL");
        for (String line: lines){
            g.drawString(line,textX,textY);
            textY+=fm.getHeight();
        }
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

    public String getContent() {
        return content;
    }
}
