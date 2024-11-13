import java.awt.*;
public class cadenobject {
public static final int WIDTH = 500;
public static final int HEIGHT = 500;

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
//        grass(panel);
//        spinWheel(panel);
//        drawSword(panel);
        face(panel);
    }
    public static void grass(DrawingPanel panel){
        Graphics g = panel.getGraphics();

        g.setColor(new Color(139, 69, 19)); // Brown color for dirt
        g.fillRect(0, 750, 800, 50);
        // Draw the "grass" on top of the dirt
        g.setColor(Color.GREEN);            // Green color for grass
        g.fillRect(0, 750, 800, 20);
    }

    public static void spinWheel(DrawingPanel panel) {
        // Set up the drawing panel and graphics
        Graphics g = panel.getGraphics();

        // Wheel parameters
        int centerX = 400;
        int centerY = 400;
        int radius = 100;
        int numSpokes = 4;
        int angleIncrement = 10;

        int angle = 0;

        // Infinite loop to keep the wheel spinning
        while (true) {
            // Clear the previous frame
            g.setColor(Color.white);
            g.fillRect(0, 0, 800, 800);

            // Draw the wheel's outline and spokes
            g.setColor(Color.RED);
            g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            for (int i = 0; i < numSpokes; i++) {
                double spokeAngle = Math.toRadians(angle + (360 / numSpokes) * i);
                int xEnd = centerX + (int) (radius * Math.cos(spokeAngle));
                int yEnd = centerY + (int) (radius * Math.sin(spokeAngle));
                g.drawLine(centerX, centerY, xEnd, yEnd);
            }

            // Update angle for spinning effect
            angle += angleIncrement;
            if (angle >= 360) {
                angle -= 360;
            }

            panel.sleep(50); // Controls speed of the animation
        }

    }
    public static void drawSword(DrawingPanel panel) {
        // Set up the drawing panel and graphics
        Graphics g = panel.getGraphics();

        // Sword parameters
        int swordHeight = 20;     // Thickness of the sword
        int swordYPosition = 390; // Vertical position (centered on the Y-axis)
        int maxSwordLength = 600; // Max length of the sword
        int speed = 10;           // Speed at which the sword extends and retracts

        int swordLength = 0; // Initial length of the sword
        boolean extending = true; // Direction of movement

        // Animation loop for extending and retracting the sword
        while (true) {
            // Clear the previous frame
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 800);

            // Draw the sword in red
            g.setColor(Color.RED);
            g.fillRect(0, swordYPosition, swordLength, swordHeight);

            // Update the sword length based on the direction
            if (extending) {
                swordLength += speed; // Extend the sword
                if (swordLength >= maxSwordLength) {
                    extending = false; // Change direction to retract
                }
            } else {
                swordLength -= speed; // Retract the sword
                if (swordLength <= 0) {
                    extending = true; // Change direction to extend
                }
            }

            // Delay for the animation speed
            panel.sleep(30);
        }
    }

    public static void face(DrawingPanel panel){
        Graphics g = panel.getGraphics();
        int width = 100;
        int height = 100;
        int x = WIDTH / 2 - width / 2;
        int y = HEIGHT / 2 - height / 2;

        int eyeWidth = 20;
        int eyeHeight = 20;
        int eyeX = (int)(x + (width * .25) - eyeWidth / 2);
        int eyeY = y + (height / 2) - eyeHeight / 2;

        int RighteyeX= (int)(x + (width * .75) - eyeWidth / 2.0);

        boolean blinking = false;
        int counter = 0;
        Color eyeColor = Color.WHITE;
        while(true){

            g.setColor(Color.BLACK);
            g.fillOval(x,y,width,height);

            g.setColor(eyeColor);
            g.fillOval(eyeX ,eyeY , eyeWidth, eyeHeight );

            g.setColor(eyeColor);
            g.fillOval(RighteyeX,eyeY , eyeWidth, eyeHeight );

            g.setColor(Color.WHITE);
            g.fillRect(225, 275, 50,10);

            counter ++;
            if(counter >= 10) {
                blinking = true;
                counter = 0;
            } else {
                blinking = false;
            }

            if(blinking) {
                eyeColor = Color.BLACK;
            } else {
                eyeColor = Color.WHITE;
            }

            panel.sleep(60);

        }
    }
}
