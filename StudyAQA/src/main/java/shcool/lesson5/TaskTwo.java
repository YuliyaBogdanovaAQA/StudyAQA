package shcool.lesson5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class Fruit {
    private float weightFruit;

    protected Fruit(float weightFruit) {
        this.weightFruit = weightFruit;
    }

    public float getWeightFruit() {
        return weightFruit;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(1f);
    }
}

class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit> {
    private ArrayList<T> fruitInBox;

    public Box() {
        this.fruitInBox = new ArrayList<T>();
    }

    public ArrayList<T> getFruitInBox() {
        return new ArrayList<T>(fruitInBox);
    }

    public boolean compare(Fruit box) {
        return this.getWeight() == box.getWeightFruit();
    }

    public void addFruit(T... fruit) {
        this.fruitInBox.addAll(List.of(fruit));
    }

    public float getWeight() {
        float currentWeight = 0;
        for (T s : fruitInBox)
            currentWeight += s.getWeightFruit();
        return currentWeight;
    }

    public boolean compare(Box fruits) {
        if (this.getWeight() == fruits.getWeight()) {
            return true;
        } else
            return false;
    }

    public void move(Box<T> fruit) {
        fruit.fruitInBox.addAll((Collection<? extends T>) this.fruitInBox);
    }
}

public class TaskTwo {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Apple apple3 = new Apple();

        Box<Apple> boxApple = new Box<Apple>();
        Box<Orange> boxOrange = new Box<Orange>();
        Box<Apple> boxA = new Box<Apple>();
        Box<Orange> boxO = new Box<Orange>();

        boxApple.addFruit(apple1, apple2, apple3);
        boxOrange.addFruit(orange1);
        boxA.addFruit(apple3);
        boxO.addFruit(orange2);

        System.out.println(boxApple.compare(boxOrange));

        System.out.println("Apple box weight: " + boxApple.getWeight());
        System.out.println("Orange box weight: " + boxOrange.getWeight());

        boxA.move(boxApple);
        boxO.move(boxOrange);

        System.out.println("Apple box weight after moved: " + boxApple.getWeight());
        System.out.println("Orange box weight after moved: " + boxOrange.getWeight());
    }
}