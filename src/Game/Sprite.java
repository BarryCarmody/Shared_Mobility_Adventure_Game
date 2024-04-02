package Game;

import java.awt.Image;
public class Sprite {
    private boolean visible;
    private Image image;

    int x;
    int y;

    int dx;
    int dy;

    public Sprite(){
        visible=true;
    }
    public void hide(){
        visible=false;
    }
    public boolean isVisible(){
        return visible;
    }

    protected void setVisible(boolean visible){
        this.visible=visible;
    }

    public void setImage(Image image){
        this.image=image;
    }

    public Image getImage(){
        return this.image;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setDX(int dx){
        this.dx=dx;
    }

    public void setDY(int dy){
        this.dy=dy;
    }

}
