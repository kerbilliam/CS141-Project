package levelDesign;

import java.awt.*;

public class WorkInprogress3 {
    public static void levelThree() {
        DrawingPanel panel = new DrawingPanel(800, 400); // panel size
        Graphics g = panel.getGraphics();


        Rectangle rectangle1 = new Rectangle(350, 200, 100, 450);
        Rectangle rectangle2 = new Rectangle(350, 0,100,150);

        g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed


        rectangle1.draw(g);
        rectangle2.draw(g);
    }
}
