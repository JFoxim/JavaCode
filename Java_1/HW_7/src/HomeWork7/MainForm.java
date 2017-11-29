package HomeWork7;

/**
 * Java. Level 1  HomeWork 7.
 *
 * @author Shangareev Rinat
 * @version dated 21.10.2017
 */

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JButton btnStart;
    private JLabel labelCat1;
    private JLabel labelCat2;
    private JLabel plateLabel1;
    private JButton btnAddFood;

    public MainForm(Plate plate, Cat[] cats) {

        plateLabel1.setText(plate.toString());
        cats[0].setLabel(labelCat1);
        cats[1].setLabel(labelCat2);

        for (Cat cat : cats){
            cat.getLabel().setText(cat.toString());
            cat.getLabel().setText(cat.toString());
        }

        btnAddFood.addActionListener(e -> {
            plate.addFood(2);
            plateLabel1.setText(plate.toString());
           });
        btnStart.addActionListener(e -> {
            for (Cat cat : cats){
                cat.eat(plate);
                cat.getLabel().setText(cat.toString());
            }
            plateLabel1.setText(plate.toString());
        });
    }

    public void load(){
        this.frameInit();
        this.setTitle("Домашнее задание 7");
        this.setPreferredSize(new Dimension(700, 500));
        this.add(panelMain);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}


