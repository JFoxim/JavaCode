/**
 * Java. Level 1  HomeWork 7.
 *
 * @author Shangareev Rinat
 * @version dated 21.10.2017
 */


public class MainApp {
    public static void main(String[] args){
        Cat[]cats={new Cat("Murzik",5),new Cat("Barsik",7),
                new Cat("Murka",2),new Cat("Vasyka",15)};
        Plate plate = new Plate(20);
        System.out.println(plate.toString());
        for(Cat cat:cats){
            cat.eat(plate);
            System.out.println(cat.toString()+", satiety: "+cat.getSatiety());
        }
        System.out.println(plate.toString());
    }

}


class Cat{
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate){
        //plate.setFood(plate.getFood() - appetite);
        if (plate.decreasefood(appetite) > 0)
            satiety = true;
    }

    boolean getSatiety(){
        return satiety;
    }

    int getAppetite(){
        return  appetite;
    }

    @Override
    public  String toString(){
        return name + ", appetite: " + appetite;
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
        return  "Plate: "+food;
    }
}

