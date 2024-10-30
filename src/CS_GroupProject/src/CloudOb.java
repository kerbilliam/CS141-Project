import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;



public class CloudOb extends JComponent {

    private int width;
    private int height;

    public CloudOb(int w, int h) {
        width = w;
        height = h;
    }
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Ellipse2D.Double e1 = new Ellipse2D.Double(200,75,100,100);
        Ellipse2D.Double e2 = new Ellipse2D.Double(235,55,175,140);
        Ellipse2D.Double e3 = new Ellipse2D.Double(350,90,90,90);
        Ellipse2D.Double e4 = new Ellipse2D.Double(380,90,30,30);
        g2d.setColor(Color.BLUE);
        g2d.fill(e1);
        g2d.fill(e2);
        g2d.fill(e3);
        g2d.fill(e4);


    }

    }

