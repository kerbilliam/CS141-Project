import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;



public class DrawingCanvas extends JComponent {

    private int width;
    private int height;

    public DrawingCanvas(int w, int h){
        width = w;
        height = h;

    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        // Graphics2D smooths out object not necessary just looks nicer and comes with more options
        Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250); // X = 0 & Y = 0 is in upper left of a drawing panel
        // Increase x to move right, decrease to move left, increase y to move down and decrease y to move up
        g2d.setColor(new Color(100, 149,237));
        // RGB values to set the color of an object
        g2d.fill(r);
        // g2d.fill(r) fills shape with the set color(current cornflower blue)

    }
}
