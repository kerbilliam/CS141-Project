import java.awt.*;

public class PlayingWithDrawingPanel {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(320, 180);
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        g.drawOval(10, 30, 100, 100);

        g.setColor(Color.BLUE);
        g.fillOval(30,60,20,20);
        g.fillOval(70,60,20,20);

        g.setColor(Color.RED);
        g.drawLine(40,100,80,100);

        g.setColor(Color.BLACK);
        g.drawOval(150, 50, 100, 100);

        g.setColor(Color.BLUE);
        g.fillOval(170,80,20,20);
        g.fillOval(210,80,20,20);

        g.setColor(Color.RED);
        g.drawLine(180,120,220,120);

        g.setColor(Color.BLACK);
        g.drawOval(10, 30, 100, 100);
        g.setColor(Color.BLUE);
        g.fillOval(30,60,20,20);
        g.fillOval(70,60,20,20);

        g.setColor(Color.RED);
        g.drawLine(40,100,80,100);


    }

}
