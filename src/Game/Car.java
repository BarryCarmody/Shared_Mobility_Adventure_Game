package Game;

import java.util.List;

public class Car extends Transport{

    static int speed = 12;

    private final int PHEIGHT=20;
    private final int PWIDTH=20;

    public List<Node> route;

    public int stopTime;

    public int stoppedTime;
    @Override
    public int getCurrentSpotOnRoute() {
        return 0;
    }


}
