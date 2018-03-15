package task1.figures.figure;

/**
 * Created by kleba on 15.03.2018.
 */
public class Triangle extends Shape {

    private String type;
    public Triangle(double x, double y,String type) {
        super(x, y);
        this.type=type;
    }

    public void area() {
        System.out.println("area=1/2*A/H");
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x="+x+";"+
                "y="+y+";"+
                "type='" + type + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
