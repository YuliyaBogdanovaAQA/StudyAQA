package school.lesson4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

interface Form {

    double perimeter();

    double square();

    void printInfo();
}

class Circle implements Form {
    private int radius;
    private String colorOfFill;
    private String colorOfBorders;

    public Circle(String colorOfFill, String colorOfBorders, int radius) {
        this.colorOfFill = colorOfFill;
        this.colorOfBorders = colorOfBorders;
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * this.radius);
    }

    @Override
    public double square() {
        return (Math.PI * this.radius * this.radius);
    }

    @Override
    public void printInfo() {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        System.out.print("Circle:\ncolor of fill: " + this.colorOfFill +
                "\tcolor of borders(): " + this.colorOfBorders +
                "\tperimeter: " + decimalFormat.format(perimeter()) + "\tsquare(): " + decimalFormat.format(square()));
    }
}

class Rectangle implements Form {
    private int a;
    private int b;
    private String colorOfFill;
    private String colorOfBorders;

    public Rectangle(String colorOfFill, String colorOfBorders, int a, int b) {
        this.colorOfFill = colorOfFill;
        this.colorOfBorders = colorOfBorders;
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return (2 * (this.a + this.b));
    }

    @Override
    public double square() {
        return (this.a * this.b);
    }

    @Override
    public void printInfo() {
        System.out.print("Rectangle:\ncolor of fill: " + this.colorOfFill +
                "\tcolor of borders(): " + this.colorOfBorders +
                "\tperimeter: " + perimeter() + "\tsquare(): " + square());
    }
}

class Triangle implements Form {
    private int a;
    private int b;
    private int c;
    private String colorOfFill;
    private String colorOfBorders;

    public Triangle(String colorOfFill, String colorOfBorders, int a, int b, int c) {
        this.colorOfFill = colorOfFill;
        this.colorOfBorders = colorOfBorders;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return (this.a + this.b + this.c);
    }

    @Override
    public double square() {
        return (Math.sqrt(perimeter() / 2 * (perimeter() / 2 - this.a) * perimeter() / 2 * (perimeter() / 2 - this.b) * perimeter() / 2 * (perimeter() / 2 - this.c)));
    }

    @Override
    public void printInfo() {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.print("Triangle:\ncolor of fill: " + this.colorOfFill +
                "\tcolor of borders(): " + this.colorOfBorders +
                "\tperimeter: " + perimeter() + "\tsquare(): " + decimalFormat.format(square()));
    }
}

public class TaskEight {
    public static void main(String[] args) {

        List<Form> forms = new ArrayList<Form>();
        forms.add(new Triangle("Yellow", "White", 10, 13, 8));
        forms.add(new Rectangle("Green", "red", 10, 2));
        forms.add(new Circle("Grey", "Black", 5));

        for (Form form : forms) {
            form.printInfo();
            System.out.println();
        }
    }
}