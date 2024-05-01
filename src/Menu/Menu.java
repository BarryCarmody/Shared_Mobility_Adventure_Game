package Menu;

public class Menu {
    static int width = 800;
    static int height = 600;
    static String title = "EcoRiders";

    public static void main(String[] args) {
        Window window = new Window(width, height, title);
        Thread thread = new Thread(window);
        thread.start();
    }
}
