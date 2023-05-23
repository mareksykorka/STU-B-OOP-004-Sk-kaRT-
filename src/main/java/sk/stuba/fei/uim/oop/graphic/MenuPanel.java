package sk.stuba.fei.uim.oop.graphic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.chain.shapes.ShapeTypes;
import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class MenuPanel extends JPanel {
    @Getter
    private JLabel labelLength;
    @Getter
    private JLabel labelRadius;
    @Getter
    private JLabel labelSpacing;
    @Getter
    private JSlider sliderLength;
    @Getter
    private JSlider sliderRadius;
    @Getter
    private JSlider sliderSpacing;
    @Getter
    private JComboBox stylesComboBox;

    public MenuPanel(Logic logic) {
        this.setLayout(new GridBagLayout());
        this.setBorder(new LineBorder(Color.DARK_GRAY,1));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        this.labelLength = new JLabel("Length");
        this.labelLength.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.labelLength, gbc);

        gbc.gridx = 1;
        this.labelRadius = new JLabel("Radius");
        this.labelRadius.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.labelRadius, gbc);

        gbc.gridx = 2;
        this.labelSpacing = new JLabel("Spacing");
        this.labelSpacing.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.labelSpacing, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0f;
        gbc.insets = new Insets(0,5,0,5);
        this.sliderLength = new JSlider(SwingConstants.VERTICAL, 20, 200, 50);
        this.sliderLength.setMajorTickSpacing(10);
        this.sliderLength.setMinorTickSpacing(10);
        this.sliderLength.setSnapToTicks(true);
        this.sliderLength.setPaintTicks(true);
        this.sliderLength.setPaintLabels(true);
        this.sliderLength.setFocusable(false);
        this.sliderLength.addChangeListener(logic);
        this.add(this.sliderLength, gbc);

        gbc.gridx = 1;
        this.sliderRadius = new JSlider(SwingConstants.VERTICAL, 1, 20, 5);
        this.sliderRadius.setMajorTickSpacing(1);
        this.sliderRadius.setMinorTickSpacing(1);
        this.sliderRadius.setSnapToTicks(true);
        this.sliderRadius.setPaintTicks(true);
        this.sliderRadius.setPaintLabels(true);
        this.sliderRadius.setFocusable(false);
        this.sliderRadius.addChangeListener(logic);
        this.add(this.sliderRadius, gbc);

        gbc.gridx = 2;
        this.sliderSpacing = new JSlider(SwingConstants.VERTICAL, 1, 20, 5);
        this.sliderSpacing.setMajorTickSpacing(1);
        this.sliderSpacing.setMinorTickSpacing(1);
        this.sliderSpacing.setSnapToTicks(true);
        this.sliderSpacing.setPaintTicks(true);
        this.sliderSpacing.setPaintLabels(true);
        this.sliderSpacing.setFocusable(false);
        this.sliderSpacing.addChangeListener(logic);
        this.add(this.sliderSpacing, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0f;
        gbc.weighty = 0.0f;
        gbc.insets = new Insets(5,5,5,5);
        Vector<ShapeTypes> cBoxOptions = new Vector<>(List.of(ShapeTypes.values()));
        this.stylesComboBox = new JComboBox<>(cBoxOptions);
        this.stylesComboBox.setSelectedIndex(0);
        this.stylesComboBox.setFocusable(false);
        this.stylesComboBox.addItemListener(logic);
        this.add(this.stylesComboBox, gbc);
    }
}
