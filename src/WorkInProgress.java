import java.awt.*;

public class WorkInProgress {

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400); // panel size
        Graphics g = panel.getGraphics();

        Circle circle1 = new Circle(100, 100, 50); //current shapes
        Circle circle2 = new Circle(200, 200, 30);

        Rectangle rectangle1 = new Rectangle(300, 250, 100, 50);

        while (true) {
            g.clearRect(0, 0, panel.getWidth(), panel.getHeight()); // background can be changed

            circle1.draw(g);
            circle2.draw(g);

            rectangle1.draw(g);

            if (circle1.collidesWith(circle2)) {
                // Collision interaction can change later to different object, checks to see if the circles are colliding with one another
                circle1.setColor(Color.RED);
                circle2.setColor(Color.RED);
            } else {
                circle1.setColor(Color.BLUE);
                circle2.setColor(Color.GREEN);
            }

            if (rectangle1.collidesWith(circle1)) {
                rectangle1.setColor(Color.RED);
                circle1.setColor(Color.RED);
            } else {
                rectangle1.setColor(Color.YELLOW);
                circle1.setColor(Color.BLUE);
            }

            panel.sleep(20); // Pause for animation
        }
    }
}

class Circle {
    int x, y, radius;
    Color color;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.BLUE;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public boolean collidesWith(Circle other) {
        double distance = Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
        return distance < radius + other.radius; //collision interaction
    }

    public void setColor(Color color) {
        this.color = color; // object color
    }
}

class Rectangle{
    int x,y,width,height;
    Color color;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.YELLOW;

    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width, height);
    }
    public boolean collidesWith(Circle other) {
        double distance = Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
        return distance < width + other.radius;
    }
    public void setColor(Color color) {
        this.color = color;
}
}