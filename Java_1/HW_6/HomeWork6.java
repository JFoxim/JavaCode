/**
 * Java. Level 1  Lesson 6.
 *
 * @author Shangareev Rinat
 * @version dated 11.10.2017
 */

public class HomeWork6 {

    public static void main(String[] args){
        Animal[] animals = { new Cat("Murzik", "white", 5),
                new Dog("Tuzik", "black", 8),
                new Dog("Drujok", "white", 2),
                new Cat("Barsik", "black", 1)};
        for (Animal animal : animals)
            System.out.println(animal + animal.run(100) +";"+
                  animal.swim(1) +";"+ animal.jump(1) +";"+" say " + animal.voice());
    }
}


class Cat extends Animal {
    Cat(String name, String color, int age){
        super(name, color, age);
    }

    @Override
    String run(float distance) {
      if (distance >= 0 && distance <= 200)
          return super.run(distance) + " true";
      else
          return super.run(distance) + " false";
    }

    @Override
    String jump(float height) {
        if (height >= 0 && height <= 2)
            return super.jump(height) + " true";
        else
            return super.jump(height) + " false";
    }

    @Override
    public String voice(){
        return "meow";
    }
}

class Dog extends Animal {
    Dog(String name, String color, int age){
        super(name, color, age);
    }

    @Override
    String run(float distance) {
        if (distance >= 0 && distance <= 500)
            return super.run(distance) + " true";
        else
            return super.run(distance) + " false";
    }

    @Override
    String swim(float distance) {
        if (distance >= 0 && distance <= 10)
            return super.swim(distance) + " true";
        else
            return super.swim(distance) + " false";
    }

    @Override
    String jump(float height) {
        if (height >= 0 && height <= 0.5f)
            return super.jump(height) + " true";
        else
            return super.jump(height) + " false";
    }

    @Override
    String voice() {
        return "gaf-gaf";
    }
}


abstract class Animal {
    String name;
    String color;
    int age;

    Animal(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    String run(float distance){ return " run:"; }

    String swim(float distance){return " swim:";}

    String jump(float height){return " jump:";}

    abstract String voice();

    @Override
    public String toString() {
        return  "{" +name +", " +color +", "+age+"}";
    }
}
