/*  THE KINEMATICS EQUATIONS
 *  
 * New Position
 *  r = ro + vo  t + 1/2 a t^2
 * 
 * New Velocity
 *  V = Vo + at
 * 
 *  THIS CLASS REFERENCES AppTest FOR ITS MAIN CLASS
 */
import java.awt.*;

public class Physics {
    private static final double G = -9.8; // gravity = 9.81 m/s
    private static final double deltaT = 0.5; // how often cacluation is made.

    static double inputVelocity;
    static double inputAngle;
    static byte dotSize;
    static double rx, ry;
    static double Vx, Vy;



    public static void play(DrawingPanel panel, Graphics2D g) {
        double angleRAD = inputAngle * Math.PI / 180;
        rx = 0; // reset x position
        ry = 0; // reset y position
        Vx = inputVelocity * Math.cos(angleRAD); // initial x velocity
        Vy = inputVelocity * Math.sin(angleRAD); // initial y velocity
    

        while (rx < AppTest.width && ry < AppTest.height) {
            panel.sleep(50);
            g.fillOval((int)rx, AppTest.height - (int)ry, dotSize, dotSize);

            rx += Vx * deltaT;
            ry += Vy * deltaT + (G * Math.pow(deltaT, 2)) / 2;
            Vy += G * deltaT; // update vertical velocity do to G
        }

    }

    public static void tradjectTest(DrawingPanel panel, Graphics2D g) {
        double angleRAD = inputAngle * Math.PI / 180;
        rx = 0; // reset x position
        ry = 0; // reset y position
        Vx = inputVelocity * Math.cos(angleRAD); // initial x velocity
        Vy = inputVelocity * Math.sin(angleRAD); // initial y velocity
        
        for (byte i = 0; i < 10; i++) {
            g.fillOval((int)rx, AppTest.height - (int)ry, dotSize, dotSize);

            rx += Vx * deltaT;
            ry += Vy * deltaT + (G * Math.pow(deltaT, 2)) / 2;
            Vy += G * deltaT; // update vertical velocity do to G
        }
    }

    private static void collision() {
        // check pixle color
        // check sourrounding pixle colors if shape is hollow
        // find the angle of slope
        // use angle to find normal
        // adjust velocity accoringly
    }
}
