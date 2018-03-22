package task;


import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by kleba on 15.03.2018.
 */
public class Line implements Serializable {

    private Point pointFirst;
    private Point pointSecond;

    public Line(Point pointsFirst,Point pointSecond) {
        this.pointFirst=pointsFirst;
        this.pointSecond=pointSecond;
    }

    public void setPointFirst(Point pointFirst) {
        this.pointFirst = pointFirst;
    }

    public Point getPointFirst() {
        return pointFirst;
    }

    public void setPointSecond(Point pointSecond) {
        this.pointSecond = pointSecond;
    }

    public Point getPointSecond() {
        return pointSecond;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(pointFirst);
        sb.append("\t");
        sb.append(pointSecond);
        sb.append("]");
        sb.append("\n");
        return sb.toString();
    }
}


