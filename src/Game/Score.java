package Game;
//Score Class
public class Score {
    int number;

    public int getScore(){
        return number;
    }
    public void setScore( int number){
        this.number = number;
    }

    public void addScore(){
        number = number + 1;
    }

}



