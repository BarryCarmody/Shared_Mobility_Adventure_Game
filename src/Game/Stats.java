package Game;

import java.util.Scanner;  // Import the Scanner class


public class Stats {
    String playerName;
    int score;

    public void setName(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        playerName = myObj.nextLine();   // Setting playerName
    }

    public String getPlayerName(){
        return playerName; // returning playerName
    }

    public int acquireScore(){
        return score;
    }
}
