package sk.stuba.fei.uim.oop.chain;

import lombok.Getter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ChainLink {
    @Getter
    private Point center;

    private Line2D connectingLine;

    public ChainLink(Point mousePoint, Line2D line){
        this.center = mousePoint;
        this.connectingLine = line;
    }

    public void removeLine(){
        this.connectingLine = null;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.BLACK);
        g2D.fill(new Ellipse2D.Double(this.center.x - 2, this.center.y - 2, 2 * 2, 2 * 2));
        if(this.connectingLine != null){
            g2D.draw(this.connectingLine);
        }
    }
}
