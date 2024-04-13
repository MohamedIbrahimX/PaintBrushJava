package paintbrush;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;


public class FreeHand {
        private List<Point> points;
        private Color color;

        public FreeHand(Color color) {
            this.points = new ArrayList<>();
            this.color = color;
        }

        public void addPoint(int x, int y) {
            points.add(new Point(x, y));
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(10));

            for (int i = 1; i < points.size(); i++) {
                Point p1 = points.get(i - 1);
                Point p2 = points.get(i-1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
