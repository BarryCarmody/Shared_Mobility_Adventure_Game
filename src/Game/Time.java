package Game;

public class Time {
    private int currentTime;
    private int targetTime;


    public int calculateTime(){
        return targetTime-currentTime;
    }

    public void setTargetTime(int targetTime){
        this.targetTime = targetTime;
    }
}
