package task2;


import java.util.Arrays;

/**
 * Created by kleba on 15.03.2018.
 */
public class Figure {

    private String name;
    private Point[] points;

    public Figure(String name, Point[] points) {
        this.name = name;
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape{");
        sb.append("\n");
        sb.append("name=");
        sb.append(name);
        sb.append(";");
        sb.append("\n");
        for(Point p:points){
            sb.append(p);
            sb.append(";");
        }
        return sb.toString();
    }
}


