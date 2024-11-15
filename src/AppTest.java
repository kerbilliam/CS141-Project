/*
 * A CLASS TO TEST THE FUNCTION OF PHYSICS
 */

import java.awt.*;

public class AppTest {
    static int width = 800;
    static int height = 800;
    public static void main(String[] args) throws Exception {
        Physics.inputAngle = 45; // in degrees
        Physics.inputVelocity = 80; // in meters(pixles?) per second
        Physics.deltaT = 0.5; // How often calculation is made
        Physics.dotSize = 7;
        // Scanner console = new Scanner(System.in);
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics2D g = panel.getGraphics();
        // Physics.tradjectTest(panel, g);
        Physics.play(panel, g);
    }
}
