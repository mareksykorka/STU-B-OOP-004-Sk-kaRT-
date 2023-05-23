package sk.stuba.fei.uim.oop.chain;

import lombok.Getter;
import sk.stuba.fei.uim.oop.chain.shapes.*;
import sk.stuba.fei.uim.oop.logic.AppDefs;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Chain {
    @Getter
    private int length;
    @Getter
    private int radius;
    @Getter
    private int spacing;
    @Getter
    private ShapeTypes shapeType;
    private ArrayList<ChainLink> chainLinks;

    public Chain() {
        this.length = AppDefs.DEF_LENGTH;
        this.radius = AppDefs.DEF_RADIUS;
        this.spacing = AppDefs.DEF_SPACING;
        this.shapeType = AppDefs.DEF_SHAPE;
        this.chainLinks = new ArrayList<>();
    }

    public void setLength(int length) {
        this.length = length;
        this.updateChainLength();
        this.updateChain();
    }

    public void setRadius(int radius) {
        this.radius = radius;
        this.updateChainShapeRadius();
        this.updateChain();
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
        this.updateChain();
    }

    public void setShapeTypes(ShapeTypes shapeType) {
        System.out.println(shapeType);
        this.shapeType = shapeType;
        this.updateChain();
    }

    public void addChainLink(Point mousePoint) {
        this.updateChainLength();
        if (this.chainLinks.size() > 1) {
            Point previousCenter = this.chainLinks.get(this.chainLinks.size() - 1).getCenter();
            this.chainLinks.add(new ChainLink(mousePoint, new Line2D.Double(mousePoint.x, mousePoint.y, previousCenter.x, previousCenter.y)));
        } else {
            this.chainLinks.add(new ChainLink(mousePoint, null));
        }
        this.updateChain();
    }

    private void updateChainLength() {
        while (this.chainLinks.size() >= this.length) {
            this.chainLinks.remove(0);
            this.chainLinks.get(0).removeLine();
        }
    }

    private void updateChainShapeRadius() {
        for (ChainLink cl : this.chainLinks) {
            AppShape s = cl.getShape();
            if (s != null) {
                s.setRadius(this.radius);
            }
        }
    }

    private void updateChain() {
        for (ChainLink cl : this.chainLinks) {
            cl.removeShape();
        }
        for (int i = this.chainLinks.size()-1; i >= 0; i-=this.spacing) {
            this.chainLinks.get(i).createShape(this.shapeType, this.radius, Color.RED);
        }
        this.chainLinks.get(0).createShape(this.shapeType, this.radius, Color.RED);
    }


    public void draw(Graphics2D g2D) {
        for (int i = this.chainLinks.size() - 1; i >= 0; i--) {
            this.chainLinks.get(i).draw(g2D);
        }
        for (int i = this.chainLinks.size() - 1; i >= 0; i--) {
            this.chainLinks.get(i).drawShape(g2D);
        }
    }
}
