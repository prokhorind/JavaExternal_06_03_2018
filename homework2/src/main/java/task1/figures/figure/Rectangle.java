package task1.figures.figure;

/**
 * Created by kleba on 15.03.2018.
 */
public class Rectangle extends Shape {


    public void area() {
        System.out.println("area= a*b");
    }

    public Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
