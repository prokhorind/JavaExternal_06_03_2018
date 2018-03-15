package task1.figures.figure;

/**
 * Created by kleba on 15.03.2018.
 */
public abstract class Figure {

    protected double x;
    protected double y;

    public abstract void area();

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public abstract String toString() ;



}
