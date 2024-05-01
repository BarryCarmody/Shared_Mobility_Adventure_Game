package Game;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Leaderboard {
    // inner class to represent player
    public static class Player {
        private String initials;
        private int score;

        public Player(String initials, int score) {
            this.initials = initials;
            this.score = score;
        }

        public String getInitials() {
            return initials;
        }

        public int getScore() {
            return score;
        }
    }

    private JFrame frame;
    private DefaultListModel<String> listModel;
    private List<Player> players; // to store players
    private boolean isDisplayed = false; // flag to check if leaderboard has already been displayed

    // constructor
    public Leaderboard() {
        players = new ArrayList<>();
        setupUI();
        loadPlayers();
    }

    private void setupUI() {
        frame = new JFrame("Arcade Leaderboard");
        listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        list.setVisibleRowCount(10);
        list.setFixedCellHeight(30);
        list.setFixedCellWidth(100);

        frame.add(new JScrollPane(list));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
    }

    private void loadPlayers() {
        File file = new File("./Game/TopPlayers/TopPlayersList.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    addPlayer(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format error in the file: " + e.getMessage());
        }
    }

    public void addPlayer(String initials, int score) {
        players.add(new Player(initials, score));
        updateDisplay();
    }

    private void savePlayer(String initials, int score) {
        try (FileWriter fw = new FileWriter("./Game/TopPlayers/TopPlayersList.txt", true);
             PrintWriter out = new PrintWriter(new BufferedWriter(fw))) {
            out.println(initials + ", " + score);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void updateDisplay() {
        listModel.clear();
        sortLeaderboard();
        for (Player player : players) {
            listModel.addElement(player.getInitials() + " - " + player.getScore());
        }
    }

    // sort the leaderboard in descending order by score
    private void sortLeaderboard() {
        players.sort(Comparator.comparingInt(Player::getScore).reversed());
    }

    // check if the leaderboard has already been displayed
    public boolean isDisplayed() {
        return isDisplayed;
    }

    public void promptForInitialsAndDisplay() {
        String initials = null;
        while (initials == null || initials.length() != 3) {
            initials = JOptionPane.showInputDialog(frame, "Enter your initials (3 characters):", "Player Initials", JOptionPane.PLAIN_MESSAGE);
            if (initials == null || initials.length() != 3) {
                JOptionPane.showMessageDialog(frame, "Invalid initials. Please enter exactly 3 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        int score = Game.Score.getScore();
        addPlayer(initials.toUpperCase(), score);
        savePlayer(initials.toUpperCase(), score);
        display();
    }

    public void display() {
        if (!isDisplayed) {
            frame.setVisible(true);
            isDisplayed = true; // update flag
        }
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
//        leaderboard.addPlayer("ABC", 3400);
//        leaderboard.addPlayer("XYZ", 2700);
//        leaderboard.addPlayer("DEF", 3900);
//        leaderboard.display();
        leaderboard.promptForInitialsAndDisplay();
    }
}
