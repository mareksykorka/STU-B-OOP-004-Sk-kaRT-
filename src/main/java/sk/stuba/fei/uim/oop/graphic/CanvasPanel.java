package sk.stuba.fei.uim.oop.graphic;

import sk.stuba.fei.uim.oop.chain.Chain;


import javax.swing.*;
import java.awt.*;


public class CanvasPanel extends JPanel {
    private Chain chain;
    public CanvasPanel(Chain chain) {
        this.chain = chain;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        this.chain.draw(g2D);
    }
}
