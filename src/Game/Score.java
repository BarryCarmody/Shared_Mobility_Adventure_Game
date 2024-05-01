package Game;

public class Score {

    // cumulative score for the player
    private static int score;

    private static int levelscore;

    public void addLevelScore(){score+=levelscore;
    }

    // increment player score upon gem retrieval
    public static void incrementLevelScore(int points){
        setLevelscore(getLevelscore()+points);
    }

    public static void incrementScore(int points) {
        score += points;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Score.score = score;
    }

    public static int getLevelscore() {
        return levelscore;
    }

    public static void setLevelscore(int levelscore) {
        Score.levelscore = levelscore;
    }
}
