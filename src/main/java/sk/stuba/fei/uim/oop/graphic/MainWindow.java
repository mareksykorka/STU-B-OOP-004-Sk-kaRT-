package sk.stuba.fei.uim.oop.graphic;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setTitle("Colorful chain - drawing app");
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.requestFocus();

        Logic logic = new Logic(this);

        this.add(logic.getCanvas(), BorderLayout.CENTER);
        this.add(logic.getMenu(), BorderLayout.EAST);

        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }
}