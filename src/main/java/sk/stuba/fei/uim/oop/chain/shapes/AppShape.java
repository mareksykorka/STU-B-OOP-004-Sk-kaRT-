package sk.stuba.fei.uim.oop.chain.shapes;

import lombok.Setter;

import java.awt.*;

public abstract class AppShape {
    protected Point center;
    @Setter
    protected int radius;
    @Setter
    protected Color color;

    protected AppShape(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public abstract void draw(Graphics2D g2D);
}