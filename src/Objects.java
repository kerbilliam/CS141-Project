import java.awt.*;

public class Objects {
    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(1200, 1200);
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(17,45,139,241);

        g.setColor(Color.RED);
        g.drawLine(25, 75, 100, 25);
        g.drawLine(100, 25, 175, 75);
        g.drawLine(25, 75, 175, 75);


        g.setColor(Color.RED);
        g.fillRect(600,600,30,10);
        g.setColor(Color.GREEN);
        g.fillRect(520,600,80,10);
        g.fillRect(630,600,80,10);
        g.setColor(Color.BLUE);
        g.fillRect(420,600,100,10);
        g.fillRect(710,600,100,10);







    }

    }
