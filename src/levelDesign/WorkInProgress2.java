package levelDesign;

import java.awt.*;

public class WorkInProgress2 {
    public static void levelTwo() {
        DrawingPanel panel = new DrawingPanel(800, 400); // panel size
        Graphics g = panel.getGraphics();


        Rectangle rectangle1 = new Rectangle(350, 200, 100, 700);
        Rectangle rectangle2 = new Rectangle(550, 0,100,200);

        g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed


        rectangle1.draw(g);
        rectangle2.draw(g);
    }
}
