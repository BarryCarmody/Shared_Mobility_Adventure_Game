package Game;

public class Score {

    private static int score;

    private static int levelscore;

    public void addLevelScore(){
        score+=levelscore;
    }

    public static void incrementLevelScore(int points){
        setLevelscore(getLevelscore()+points);
    }

    public static int getScore() {
        return score;
    }

    public static int getLevelscore() {
        return levelscore;
    }

    public static void setLevelscore(int levelscore) {
        Score.levelscore = levelscore;
    }
}
