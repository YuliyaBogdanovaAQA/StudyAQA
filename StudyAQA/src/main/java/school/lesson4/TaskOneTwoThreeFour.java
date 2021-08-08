package school.lesson4;

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
        Animal.quantity();
    }

    public String getName() {
        return name;
    }
//Task 2
 /*
    public void run(int runCurrentDistance) {

        System.out.println("Tne " + name + " ran " + runCurrentDistance);
    }

    public void swim(int swimCurrentDistance) {
        System.out.println("Tne " + name + " swam " + swimCurrentDistance);
    }
*/

//end task2

    // Task3
    int runMaxDistance;
    int swimMaxDistance;

    public int getRunMaxDistance() {
        return runMaxDistance;
    }

    public int getSwimMaxDistance() {
        return swimMaxDistance;
    }

    public void run(int runCurrentDistance) {
        if (checkAction(runCurrentDistance, runMaxDistance())) {
            System.out.println("Tne " + getName() + " ran " + runCurrentDistance);
        } else
            System.out.println("Tne " + getName() + " can't run " + runCurrentDistance +
                    ". This animals can't run a distance over " + getRunMaxDistance() + " meters");
    }

    public void swim(int runCurrentDistance) {
        if (checkAction(runCurrentDistance, swimMaxDistance())) {
            System.out.println("Tne " + getName() + " swam " + runCurrentDistance);
        } else
            System.out.println("Tne " + getName() + " can't swim " + runCurrentDistance +
                    ". This animals can't swim a distance over " + getSwimMaxDistance() + " meters");
    }

// ограничения: бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.
//принимаю включительно (верхняя граница возможностей).

    public boolean checkAction(int currentDistance, int maxDistance) {
        return (currentDistance <= maxDistance && currentDistance > 0);
    }

    protected abstract int runMaxDistance();

    protected abstract int swimMaxDistance();

//end task 3

    //task 4
    private static int quantity = 0;

    static int quantity() {
        return quantity++;
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        Cat.quantity();
    }

    //for task 3
    @Override
    protected int runMaxDistance() {
        return runMaxDistance = 200;
    }

    @Override
    protected int swimMaxDistance() {
        return swimMaxDistance = 0;
    }

    @Override
    public void swim(int runCurrentDistance) {
        System.out.println("Tne " + getName() + " is cat. Cats can't swim.");
    }

    //end for task3
    //Task 4
    private static int quantity = 0;

    public static int quantity() {
        return quantity++;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
        Dog.quantity();

    }

    //for task3
    @Override
    protected int runMaxDistance() {
        return runMaxDistance = 500;
    }

    @Override
    protected int swimMaxDistance() {
        return swimMaxDistance = 10;
    }
// end for task3

    //Task 4
    private static int quantity = 0;

    public static int quantity() {
        return quantity++;
    }
}

public class TaskOneTwoThreeFour {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Pushok");
        Dog dog = new Dog("Tuzik");
        Cat cat2 = new Cat("Tuchka");
        Cat cat3 = new Cat("Asya");
        Dog dog2 = new Dog("Sharik");

        cat1.run(350);
        cat2.swim(200);
        dog.run(500);
        dog.swim(11);
    }
}