package AudioANDfailScreen;

import levelDesign.DrawingPanel;

import java.awt.*;

public class FailedPassScreen {
    public void fail() {
        // Create a DrawingPanel with the desired dimensions
        DrawingPanel panel = new DrawingPanel(800, 600);
        Graphics g = panel.getGraphics();

        // Set the background color to black
        panel.setBackground(Color.BLACK);

        // Set the color and font for the "YOU FAILED!" message
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 60));

        // Draw the "YOU FAILED!" message
        g.drawString("YOU FAILED!", 200, 300); // Center it on the panel
    }
    public void clear() {
        // Create a DrawingPanel with the desired dimensions
        DrawingPanel panel = new DrawingPanel(800, 600);
        Graphics g = panel.getGraphics();

        // Set the background color to white
        panel.setBackground(Color.white);

        // Set the color and font for the message
        g.setColor(new Color(255,215,0));
        g.setFont(new Font("Times New Roman", Font.BOLD, 60));

        // Draw the "YOU PASSED!" message
        g.drawString("YOU PASSED!", 200, 300); // Center it on the panel
    }
}

