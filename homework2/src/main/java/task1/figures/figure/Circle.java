package task1.figures.figure;

/**
 * Created by kleba on 15.03.2018.
 */
public class Circle extends Shape {

    double radius;


    public void area() {
        System.out.println("area=pr^2");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x="+x +";"+
                "y="+y +";"+
                "radius=" + radius +
                '}';
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius=radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
