package areaTriangle;

public class Triangle {
    protected int a;
    protected int b;
    protected int c;

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
        if (((long) a + (long) b) <= (long) c ||
                ((long) b + (long) c) <= (long) a ||
                ((long) c + (long) a) <= (long) b ||
                a <= 0 || b <= 0 || c <= 0) {
            isTriangle = false;
        }
        return isTriangle;
    }
}