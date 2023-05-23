package sk.stuba.fei.uim.oop.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CanvasPanel extends JPanel {
    public CanvasPanel() {
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.fill(new Rectangle2D.Double(1,1,100,100));
    }
}
