package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public abstract class PopupScreen extends JFrame implements ActionListener {
    private boolean isOpen;
    private JFrame container;
    private PopupScreenType popupType;
    protected GridBagConstraints constraints = new GridBagConstraints();
    protected GridBagLayout layout = new GridBagLayout();

    public PopupScreen(final Dimension size) {
        this.setUndecorated(true); // remove title bar
        this.setSize(size);
        this.setPreferredSize(size);
        this.getContentPane().setLayout(layout);
        this.setAlwaysOnTop(true);
        this.isOpen = false;
    }

    public PopupScreen() {
        this(new Dimension(400, 300));
    }

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        this.getContentPane().addKeyListener(l); // not working? Escape key should close menu
    }

    public void drawPopupScreen() {
        if (!this.isOpen) {
            this.isOpen = true;
            if (container != null) {
                this.setLocationCenteredRelativeToContainer();
            }
            this.setVisible(true);
            this.addElements();
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    protected abstract void addElements();

    protected abstract void removeElements();

    public void removePopupScreen() {
        if (this.isOpen) {
            this.isOpen = false;
            this.setVisible(false);
        }
    }

    public void setPopupType(final PopupScreenType type) {
        this.popupType = type;
    }

    public PopupScreenType getPopupType() {
        return this.popupType;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    /**
     * Set the container who opened the popup, so it can be used for positioning later
     * @param container the source container
     */
    public final void setRelativeContainer(final JFrame container) {
        this.container = container;
    }

    /**
     * Centers the popup according to the container that opened it
     */
    private void setLocationCenteredRelativeToContainer() {
        final int centerX = container.getX() + container.getWidth() / 2;
        final int centerY = container.getY() + container.getHeight() / 2;
        this.setLocation(centerX - this.getWidth() / 2, centerY - this.getHeight() / 2);
    }

    protected void addComponentToGrid(final Component component, final Point location, final Dimension size) {
        this.addComponentToGrid(component, location, size, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0));
    }

    protected void addComponentToGrid(final Component component, final Point location, final Dimension size, final int fillType, final Insets insets) {
        this.constraints.gridx = location.x;
        this.constraints.gridy = location.y;
        this.constraints.gridwidth = size.width;
        this.constraints.gridheight = size.height;
        this.constraints.fill = fillType;
        this.constraints.weightx = 1.0;
        this.constraints.weighty = 1.0;

        this.constraints.insets = insets;

        this.layout.setConstraints(component, this.constraints);
        this.getContentPane().add(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
