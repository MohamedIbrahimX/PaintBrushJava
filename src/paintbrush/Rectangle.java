package paintbrush;

import java.awt.*;

public class Rectangle {
    int x1, y1, x2, y2;
    Color color;
    boolean Dotted;
    boolean filled;

    public Rectangle(int _x1, int _y1,Color _c, boolean _Dotted, boolean _filled) {
        this.x1 = _x1;
        this.y1 = _y1;
        this.x2 = _x1;
        this.y2 = _y1;
        this.color = _c;
        this.Dotted = _Dotted;
        this.filled = _filled;
    }

    public void updateEndPoint(int _x2, int _y2) {
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
        
        

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        g2d.drawRect(x, y, width, height);
        
        if (filled) {
            g2d.fillRect(x, y, width, height);
        } else {
            g2d.drawRect(x, y, width, height);
        }
    }
}

