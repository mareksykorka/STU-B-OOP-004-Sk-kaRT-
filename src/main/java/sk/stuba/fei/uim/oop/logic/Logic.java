package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.graphic.CanvasPanel;
import sk.stuba.fei.uim.oop.graphic.MainWindow;
import sk.stuba.fei.uim.oop.graphic.MenuPanel;

public class Logic extends UniversalAdapter {

    private MainWindow mainWindow;
    @Getter
    private CanvasPanel canvas;
    @Getter
    private MenuPanel menu;

    public Logic(MainWindow window) {
        this.mainWindow = window;
        this.menu = new MenuPanel(this);

        this.canvas = new CanvasPanel();
        this.canvas.addMouseMotionListener(this);
        this.canvas.addMouseListener(this);
    }
}
