package Game;

import java.util.Scanner;  // Import the Scanner class

public class Stats {
    public int score;
    public String playerName;

    public Stats() {
        this.score = 0;
    }

    public void  setPlayerName(){
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter Player Name: ");
        this.playerName = myObj.nextLine();
        System.out.println("You're player name is " + this.playerName);
//        myObj.close();
    }


    public String getPlayerName(){
        return this.playerName; // returning playerName
    }

    public int getScore(){
        return score;
    }
    public void setScore ( int score){
        this.score = score;
    }

    public void incrementScore(int scorePoints){
        setScore(this.score+scorePoints); // Update the score
    }
}












