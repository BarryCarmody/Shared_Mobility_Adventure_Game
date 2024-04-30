package Menu;

import javax.swing.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        initMenu();
    }

    private void initMenu() {
        String title = "CarbonFree";
        SwingUtilities.invokeLater(() -> {
            Window window = new Window(title);
        });
    }
}
