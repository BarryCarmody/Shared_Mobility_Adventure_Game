package Game;

import java.awt.*;

public class Gem {

    private Node location;

    private static final int PWIDTH=18;

    private static final int PHEIGHT=24;

    private boolean collected;

    private boolean visible;

    public Gem(Node location){
        this.location=location;
        this.collected=false;
        this.visible=true;
    }

    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        int[] xPoints={Math.round(location.getX()), Math.round(location.getX()+PWIDTH/2), Math.round(location.getX()), Math.round(location.getX()-PWIDTH/2)};
        int[] yPoints={Math.round(location.getY()-PHEIGHT/2), Math.round(location.getY()), Math.round(location.getY()+PHEIGHT/2),  Math.round(location.getY())};

        g.fillPolygon(xPoints,yPoints,4);
    }



}
