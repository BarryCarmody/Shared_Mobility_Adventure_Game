package Game;

import java.util.*;

public class Leaderboard {
        ArrayList<Stats> stats = new ArrayList<>();

        public  Leaderboard () {
                sortStatsByScore();
                HashMap<String, Integer> Map = new HashMap<>();
                for (int i=0;i<10;i++){
                        Stats currentStats = stats.get(i);
                        currentStats.setPlayerName();
                        Map.put(currentStats.getPlayerName(), currentStats.getScore());
                }

        }

        private void addStats(Stats s) {
                stats.add(s);
        }

        public void sortStatsByScore() {
                stats.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        }

}
