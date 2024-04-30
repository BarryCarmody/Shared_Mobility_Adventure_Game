package Menu;

import Game.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LevelCompletePopup extends PopupScreen {

    private Level previousLevel;

    public LevelCompletePopup(final Dimension size, final Level previousLevel) {
        super(size);
        this.setupInternal(previousLevel);
    }

    public LevelCompletePopup(final Level previousLevel) {
        this(new Dimension(400, 300), previousLevel);
    }

    private void setupInternal(final Level previousLevel) {
        this.previousLevel = previousLevel;
        this.setPopupType(PopupScreenType.LEVEL_COMPLETE);
    }

    @Override
    protected void addElements() {
        try {
            // Text
            final JLabel nextLevelMessage = new JLabel("<html>Well done, you have completed: " + previousLevel.getDescription() + "<br/>" +
                    "Obtained Gems: " + previousLevel.getGemsObtained() + "/" + previousLevel.getGemTarget() + "</html>");
            nextLevelMessage.setFont(new Font("Britannic Bold", Font.BOLD, 25));

            // Button
            final JButton nextLevelButton = new CustomButton("Next Level");
            nextLevelButton.addActionListener(this);

            // Add all to grid
            this.addComponentToGrid(Box.createVerticalStrut(1), new Point(0, 0), new Dimension(4, 1));
            this.addComponentToGrid(Box.createHorizontalStrut(1), new Point(0, 1), new Dimension(1, 1));
            this.addComponentToGrid(nextLevelMessage, new Point(1, 1), new Dimension(2, 1));
            this.addComponentToGrid(Box.createHorizontalStrut(1), new Point(3, 1), new Dimension(1, 1));
            this.addComponentToGrid(Box.createHorizontalStrut(1), new Point(0, 2), new Dimension(1, 1));
            this.addComponentToGrid(nextLevelButton, new Point(1, 2), new Dimension(2, 1), GridBagConstraints.NONE, new Insets(0, 0, 0, 0));
            this.addComponentToGrid(Box.createHorizontalStrut(1), new Point(0, 2), new Dimension(1, 1));
            this.addComponentToGrid(Box.createVerticalStrut(1), new Point(0, 3), new Dimension(4, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void removeElements() {
        this.getContentPane().removeAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Level complete button clicked");
        this.removePopupScreen();
    }
}
