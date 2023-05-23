package sk.stuba.fei.uim.oop.graphic;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    public CanvasPanel() {
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
    }
}
