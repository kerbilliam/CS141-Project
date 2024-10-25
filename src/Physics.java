/*  THE KINEMATICS EQUATIONS
 *  
 * New Position
 *  r = ro + vo  t + 1/2 a t^2
 * 
 * New Velocity
 *  V = Vo + at
 */
import java.awt.*;

public class Physics {
    public void phys(DrawingPanel panel, Graphics2D g, double angle, double velocity, int height, int width) {
        double angleRAD = angle * Math.PI / 180;
        double rx = 0, ry = 0; // initial position
        double Vx = velocity * Math.cos(angleRAD); // initial x velocity
        double Vy = velocity * Math.sin(angleRAD); // initial y velocity
        double G = -9.81; // gravity = 9.81 m/s
        double deltaT = 0.5; // how often calculation is made.
        int dotSize = 7;

        while (rx < width && ry < height) {
            panel.sleep(50);

            rx += Vx * deltaT;
            ry += Vy * deltaT + (G * Math.pow(deltaT, 2)) / 2;

            g.fillOval((int)rx, height - (int)ry, dotSize, dotSize);

            Vy += G * deltaT; // update vertical velocity do to G
        }

    }
}
