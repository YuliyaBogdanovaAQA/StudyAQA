package areaTriangle;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() throws MyTriangleException {
        double area = 0;
        if (checkTriangle()) {
            double perimeter = (double) a + (double) b + (double) c;
            double p = perimeter / 2;
            area = Math.sqrt(p * (p - (double) a) * (p - (double) b) * (p - (double) c));
        } else {
            area = 0;
        }
        if (area > 0) {
            return area;
        } else throw new MyTriangleException();
    }

    public boolean checkTriangle() {
        boolean isTriangle = true;
        if ((a + b) <= c ||
                (b + c) <= a ||
                (c + a) <= b ||
                a <= 0 || b <= 0 || c <= 0) {
            isTriangle = false;
        }
        return isTriangle;
    }
}