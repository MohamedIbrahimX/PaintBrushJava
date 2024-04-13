package paintbrush;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Line {
    int x1, y1, x2, y2;
    Color color;
    boolean Dotted;
    

    public Line(int _x1, int _y1,Color _c, boolean _Dotted) {
        this.x1 = _x1;
        this.y1 = _y1;
        this.x2 = _x1;
        this.y2 = _y1;
        this.color = _c;
        this.Dotted = _Dotted;
    }

    public void endPoint(int _x2, int _y2) {
        this.x2 = _x2;
        this.y2 = _y2;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        
        if (Dotted) {
            float[] dashPattern = {5, 5};
            Stroke dashedStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dashPattern, 0.0f);
            g2d.setStroke(dashedStroke);
        } else {
            g2d.setStroke(new BasicStroke(2));
        }
        
        g2d.drawLine(x1, y1, x2, y2);
    }
   
}
