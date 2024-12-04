package levelDesign;

import java.awt.*;

public class WorkInprogress3 {
    public static DrawingPanel panel = new DrawingPanel(800, 400); // panel size
    public static Graphics g = panel.getGraphics();
    
    public static void levelThree() {
        Rectangle rectangle1 = new Rectangle(350, 200, 100, 450);
        Rectangle rectangle2 = new Rectangle(350, 0, 100, 150);

        g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed


        rectangle1.draw(g);
        rectangle2.draw(g);
    }
}
