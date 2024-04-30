package Game;

import java.util.*;

public class Leaderboard {
        ArrayList<Stats> stats;
        HashMap<String, Integer> Map;
        public  Leaderboard () {
                this.stats = new ArrayList<>();
                this.Map = new HashMap<>();
        }

        public void addStats(Stats s) {
                stats.add(s);
        }

        public void sortStatsByScore() {
                stats.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        }

        public  HashMap<String, Integer> finalLeaderboard(){
                for (int i=0;i<5;i++) {
                        Stats currentStats = stats.get(i);
                        currentStats.setPlayerName();
                        Map.put(currentStats.getPlayerName(), currentStats.getScore());
                }
            System.out.println("Leaderboard");
            return Map;
        }

//        public static void main (String[] args) {
//                Leaderboard leaderboard = new Leaderboard();
//                Stats object1 = new Stats();
//                object1.setScore(1);
//                Stats object2 = new Stats();
//                object2.setScore(2);
//                Stats object3 = new Stats();
//                object3.setScore(3);
//                Stats object4 = new Stats();
//                object4.setScore(4);
//                Stats object5 = new Stats();
//                object5.setScore(5);
//                Stats object6 = new Stats();
//                object6.setScore(6);
//                Stats object7 = new Stats();
//                object7.setScore(7);
//                Stats object8 = new Stats();
//                object8.setScore(8);
//                Stats object9 = new Stats();
//                object9.setScore(9);
//                Stats object10 = new Stats();
//                object10.setScore(10);
//                Stats object11 = new Stats();
//                object11.setScore(11);
//                leaderboard.addStats(object1);
//                leaderboard.addStats(object2);
//                leaderboard.addStats(object3);
//                leaderboard.addStats(object4);
//                leaderboard.addStats(object5);
//                leaderboard.addStats(object6);
//                leaderboard.addStats(object7);
//                leaderboard.addStats(object8);
//                leaderboard.addStats(object9);
//                leaderboard.addStats(object10);
//                leaderboard.addStats(object11);
//                leaderboard.sortStatsByScore();
//                System.out.println(leaderboard.finalLeaderboard());
//
//        }

}
