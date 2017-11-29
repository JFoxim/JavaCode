package HomeWork7;

/**
 * Java. Level 1  HomeWork 7.
 *
 * @author Shangareev Rinat
 * @version dated 21.10.2017
 */

import javax.swing.*;

public class MainApp implements Runnable {
    public static void main(String[] args){
        MainApp mainApp = new MainApp();
        SwingUtilities.invokeLater(mainApp);
    }

    @Override
    public void run() {
        Plate plate = new Plate(20);
        Cat[]cats={new Cat("Мурзик",15),new Cat("Барсик",7)};
        MainForm mainForm = new MainForm(plate, cats);
        mainForm.load();
    }

}


class Cat{
    private String name;
    private int appetite;
    private boolean satiety = false;
    private JLabel label;

    Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate){
        if (plate.decreasefood(appetite) > 0)
            satiety = true;
    }

    JLabel getLabel(){
        return label;
    }

    void setLabel(JLabel label){
        this.label = label;
    }

    boolean getSatiety(){
        return satiety;
    }

    int getAppetite(){
        return  appetite;
    }

    @Override
    public  String toString(){
        return name + ", аппетит: " + appetite + "\n, сытость: " +satiety;
    }
}

class Plate{
    private int food;

    Plate(int food){
        setFood(food);
    }

    void setFood(int food){
        if (food > 0)
            this.food = food;
    }

    int getFood(){
        return food;
    }

    int decreasefood(int food){
        if (food <= this.food)
           return this.food -=food;
        else return -1;
    }

    void addFood(int food){
        this.food += food;
    }

    @Override
    public  String toString(){
        return  "Количество еды в тарелке: "+food;
    }
}

