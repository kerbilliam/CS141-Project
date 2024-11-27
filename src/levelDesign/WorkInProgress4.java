package levelDesign;

import java.awt.*;

public class WorkInProgress4 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(800, 400); // panel size
        Graphics g = panel.getGraphics();


        Rectangle rectangle1 = new Rectangle(350, 200, 100, 450);
        Rectangle rectangle2 = new Rectangle(350, 0, 100, 150);
        Rectangle rectangle3 = new Rectangle(550, 75, 100, 200);

        g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed


        rectangle1.draw(g);
        rectangle2.draw(g);
        rectangle3.draw(g);
    }
}
