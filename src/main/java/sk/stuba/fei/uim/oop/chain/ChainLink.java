package sk.stuba.fei.uim.oop.chain;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.chain.shapes.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ChainLink {
    @Getter
    private Point center;

    @Getter
    @Setter
    private AppShape shape;

    private Line2D connectingLine;

    public ChainLink(Point mousePoint, Line2D line) {
        this.center = mousePoint;
        this.connectingLine = line;
        this.shape = null;
    }

    public void removeLine() {
        this.connectingLine = null;
    }

    public void createShape(ShapeTypes shapeType, int radius, Color color) {
        switch (shapeType) {
            case CIRCLE:
                this.shape = new Circle(this.center, radius, color);
                break;
            case SQUARE:
                this.shape = new Square(this.center, radius, color);
                break;
            case HOURGLASS:
                this.shape = new Hourglass(this.center, radius, color);
                break;
            default:
                this.removeShape();
                break;
        }
    }

    public void removeShape() {
        this.shape = null;
    }


    public void drawChainLink(Graphics2D g2D) {
        g2D.setColor(Color.BLACK);
        g2D.fill(new Ellipse2D.Double(this.center.x - 2, this.center.y - 2, 4, 4));
        if (this.connectingLine != null) {
            g2D.draw(this.connectingLine);
        }
    }

    public void drawShape(Graphics2D g2D) {
        if (this.shape != null) {
            this.shape.draw(g2D);
        }
    }

}
