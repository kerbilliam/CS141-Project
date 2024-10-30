import javax.swing.*;

public class Object {
    public static void main(String[] args) {
        int w = 640;
        int h = 480;
        JFrame f = new JFrame();
        DrawingCanvas dc = new DrawingCanvas(w,h);
       //CloudOb ec  = new CloudOb(w,h);
        f.setSize(w,h);
        f.setTitle("Obstacle");
        f.add(dc);
        //f.add(ec);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
