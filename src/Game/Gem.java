package Game;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Gem {

    private Node location;

    private static final int PWIDTH = 18;

    private static final int PHEIGHT = 24;

    private boolean collected;

    private boolean visible;

    private int value;

    private boolean endGate;

    private Image gemImage;

    private static Clip gemSoundClip = null;



    public Gem(Node location){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=100;
        this.endGate=false;
        loadImage();
    }

    public Gem(Node location, int value){
        this.location=location;
        this.collected=false;
        this.visible=true;
        this.value=value;
        this.endGate=false;
        loadImage();
    }

    public Gem(Node location, int value, boolean gate){
        this.location=location;
        this.collected=false;
        this.visible=false;
        this.value=value;
        this.endGate=gate;
    }

    public void draw(Graphics g) {
        if (visible && gemImage != null) {
            int x = location.getX() - PWIDTH / 2;
            int y = location.getY() - PHEIGHT / 2;
            g.drawImage(gemImage, x, y, null);
        }else if (endGate) {
            g.setColor(Color.CYAN);
            g.drawOval(location.getX() - 15, location.getY() - 15, 30, 30);

        } else {
            g.setColor(Color.CYAN);
            int[] xPoints = {Math.round(location.getX()), Math.round(location.getX() + PWIDTH / 2), Math.round(location.getX()), Math.round(location.getX() - PWIDTH / 2)};
            int[] yPoints = {Math.round(location.getY() - PHEIGHT / 2), Math.round(location.getY()), Math.round(location.getY() + PHEIGHT / 2), Math.round(location.getY())};

            g.fillPolygon(xPoints, yPoints, 4);
        }
    }



    public static void loadGemSound(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            gemSoundClip = AudioSystem.getClip();
            gemSoundClip.open(inputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public static void playGemSound() {
        if (gemSoundClip != null) {
            gemSoundClip.start();
            gemSoundClip.loop(0);
        }
    }

    public void pickUp() {
        setVisible(false);
        setCollected(true);
        Score.incrementLevelScore(value);
        Level.setGemsCollected(Level.getGemsCollected() + 1);
        loadGemSound("Game/Music/coin_pick_up_project.wav");
        playGemSound();

    }

    public void loadImage() {
        ImageIcon gemIcon = new ImageIcon("Game/Images/diamond-417896_1280.png");
        Image newpic = gemIcon.getImage();
        int scaledWidth = 30;
        int scaledHeight = 30;
        gemImage = newpic.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);

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


    public boolean isEndGate() {
        return endGate;
    }
}
