//I added an additional text for myself to better control the operation of the algorithm

package school.lesson4;

class Plate {
    protected int food;
    private int n;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (checkFood(n)) {
            food -= n;
            System.out.println("The cat are eating");
        } else {
            while ((checkFood(n)) == false) {
                addFood();
            }
            food -= n;
            System.out.println("The cat are eating");
        }
    }

    public void addFood() {
        int add = 100;
        this.food += add;
        System.out.println("The food isn't enough. Add food " + add + ".\nNow the food in plate is " + food);
    }

    public void printInfo() {
        System.out.println("Rest food in plate is " + food);
    }

    public boolean checkFood(int n) {
        return (food - n) >= 0;
    }
}

class CatTaskFive {
    private String name;
    protected int appetite;
    public boolean full = false;

    public String getName() {
        return name;
    }

    public void eat(Plate p) {

        p.decreaseFood(appetite);
        appetite -= appetite;
        full = true;
    }

    public CatTaskFive(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public void printInfo() {
        System.out.println("The cat " + getName() + "  want to eat " + getAppetite() +
                "\tThe cat is full: " + full);
    }
}

public class TaskFive {
    public static void main(String[] args) {
        Plate plate = new Plate(500);
        CatTaskFive[] cats = new CatTaskFive[5];
        cats[0] = new CatTaskFive("Barsik", 100, false);
        cats[1] = new CatTaskFive("Pushok", 300, false);
        cats[2] = new CatTaskFive("Basya", 150, false);
        cats[3] = new CatTaskFive("Iriska", 200, false);
        cats[4] = new CatTaskFive("Tuchka", 50, false);

        for (int i = 0; i < cats.length; i++) {
            if (cats[i].full == false) {       // or like this: (cats[i].getAppetite()> 0) - doesn't mater/
                cats[i].printInfo();
                cats[i].eat(plate);
                cats[i].printInfo();
                plate.printInfo();
                System.out.println();
            }
        }
    }
}