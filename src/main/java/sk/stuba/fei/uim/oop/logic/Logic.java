package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.chain.Chain;
import sk.stuba.fei.uim.oop.chain.shapes.ShapeTypes;
import sk.stuba.fei.uim.oop.graphic.CanvasPanel;
import sk.stuba.fei.uim.oop.graphic.MainWindow;
import sk.stuba.fei.uim.oop.graphic.MenuPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

public class Logic extends UniversalAdapter {

    private MainWindow mainWindow;
    @Getter
    private CanvasPanel canvas;
    @Getter
    private MenuPanel menu;
    @Getter
    private Chain chain;

    public Logic(MainWindow window) {
        this.mainWindow = window;
        this.menu = new MenuPanel(this);
        this.chain = new Chain();
        this.canvas = new CanvasPanel(this.chain);
        this.canvas.addMouseMotionListener(this);
        this.canvas.addMouseListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
        if (e.getSource() instanceof JSlider) {
            JSlider eSlider = (JSlider) e.getSource();
            if (!eSlider.getValueIsAdjusting()) {
                if (eSlider.equals(this.menu.getSliderLength())) {
                    this.chain.setLength(eSlider.getValue());
                }
                if (eSlider.equals(this.menu.getSliderRadius())) {
                    this.chain.setRadius(eSlider.getValue());
                }
                if (eSlider.equals(this.menu.getSliderSpacing())) {
                    this.chain.setSpacing(eSlider.getValue());
                }
            }
        }
        this.mainWindow.repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        super.itemStateChanged(e);
        if (e.getSource() instanceof JComboBox) {
            JComboBox eComboBox = (JComboBox) e.getSource();
            if (eComboBox.equals(this.menu.getStylesComboBox())) {
                this.chain.setShapeTypes((ShapeTypes) eComboBox.getSelectedItem());
            }
        }
        this.mainWindow.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        this.chain.addChainLink(e.getPoint());
        this.mainWindow.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        this.chain.addChainLink(e.getPoint());
        this.mainWindow.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        this.chain.addChainLink(e.getPoint());
        this.mainWindow.repaint();
    }
}
