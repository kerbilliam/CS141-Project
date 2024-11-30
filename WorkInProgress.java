package levelDesign;

import java.awt.*;

public class WorkInProgress {
    public static DrawingPanel panel = new DrawingPanel(800, 400); // panel size
    public static Graphics g = panel.getGraphics();

    public static void level1() {
        Rectangle rectangle1 = new Rectangle(350, 200, 100, 700);






        g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed



        rectangle1.draw(g);

    }
}


 class Rectangle {
    int x, y, width, height;
    Color color;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.YELLOW;

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

}



