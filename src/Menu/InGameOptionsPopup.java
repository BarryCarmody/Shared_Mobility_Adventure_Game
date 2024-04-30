package Menu;

import Game.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InGameOptionsPopup extends PopupScreen {

    private Level currentLevel;

    public InGameOptionsPopup(final Dimension size, final Level currentLevel) {
        super(size);
        this.setupInternal(currentLevel);
    }

    public InGameOptionsPopup(final Level currentLevel) {
        this(new Dimension(400, 400), currentLevel);
    }

    private void setupInternal(final Level currentLevel) {
        this.currentLevel = currentLevel;
        this.setPopupType(PopupScreenType.LEVEL_COMPLETE);
    }

    @Override
    protected void addElements() {
        try {
            // Text
            final JLabel nextLevelMessage = new JLabel("<html>Level: " + currentLevel.getDescription() + "<br/>" +
                    "Current Gems: " + currentLevel.getGemsObtained() + "<br/>" +
                    "Target Gems: " + currentLevel.getGemTarget() + "<br/><br/>" +
                    "Instructions: Here's how to play! TODO <br/>" +
                    "</html>");
            nextLevelMessage.setFont(new Font("Britannic Bold", Font.BOLD, 25));

            // Button
            final JButton nextLevelButton = new CustomButton("Continue");
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
        System.out.println("In game options button clicked");
        this.removePopupScreen();
    }
}
