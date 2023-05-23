package sk.stuba.fei.uim.oop.chain.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Hourglass extends AppShape{
    public Hourglass(Point center, int radius, Color color) {
        super(center, radius, color);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(super.color);
        int[] xPoints = {super.center.x - super.radius,super.center.x + super.radius,super.center.x,super.center.x - super.radius,super.center.x + super.radius,super.center.x - super.radius};
        int[] yPoints = {super.center.y - super.radius,super.center.y - super.radius,super.center.y,super.center.y + super.radius,super.center.y + super.radius,super.center.y - super.radius};
        g2D.fill(new Polygon(xPoints, yPoints, xPoints.length));
    }
}
