package sk.stuba.fei.uim.oop.chain.shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends AppShape{
    public Square(Point center, int radius, Color color) {
        super(center, radius, color);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(super.color);
        g2D.fill(new Rectangle2D.Double(super.center.x - super.radius, super.center.y - super.radius, super.radius * 2, super.radius * 2));
    }
}
