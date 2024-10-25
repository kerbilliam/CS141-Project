import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        int width = 800;
        int height = 800;
        double angle = 45; // in degrees
        double velocity = 100; // in meters(pixles?) per second
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics2D g = panel.getGraphics();
        Physics play = new Physics();
        play.phys(panel, g, angle, velocity, height, width);
    }
}
