package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class BusRoute{

    private BusNumber number;

    private List<Node> route;

    public BusRoute(BusNumber number, boolean direction, List<Node> route) {
        this.number=number;
        this.route= route;

        if (direction==false){
            Collections.reverse(this.route);
        }
    }

    public List<Node> getRoute(){
        return route;
    }

}
