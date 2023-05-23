package sk.stuba.fei.uim.oop.graphic;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private Logic logic;

    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setTitle("Color chain drawing app");
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.requestFocus();

        this.logic = new Logic(this);

        this.add(logic.getCanvas());
        this.add(logic.getMenu(), BorderLayout.EAST);

        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }
}