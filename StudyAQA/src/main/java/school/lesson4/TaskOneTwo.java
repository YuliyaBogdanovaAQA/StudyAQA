package school.lesson4;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int currentDistance) {
        System.out.println("Tne " + name + " ran " + currentDistance);
    }

    public void swim(int currentDistance) {
        System.out.println("Tne " + name + " swam " + currentDistance);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

public class TaskOneTwo {

    public static void main(String[] args) {
        Cat cat = new Cat("Pushok");
        Dog dog = new Dog("Tuzik");

        cat.run(150);
        dog.swim(200);

    }
}
