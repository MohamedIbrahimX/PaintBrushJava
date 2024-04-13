package paintbrush;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle; 
import java.awt.Stroke;

public class Eraser {
    private int x1, y1, x2, y2;

    public Eraser(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
    }

    
    public void updateEndPoint(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    // Draw function
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE); 

        
        g2d.setStroke(new BasicStroke(10)); // Set eraser stroke width

        
        g2d.drawLine(x1, y1, x2, y2);
    }
        
}
