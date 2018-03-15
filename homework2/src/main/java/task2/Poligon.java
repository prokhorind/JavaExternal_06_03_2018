package task2;

import java.util.Arrays;

/**
 * Created by kleba on 15.03.2018.
 */
public  class Poligon {

    private Figure[] figures;

    public Poligon(Figure[] figures) {
        this.figures = figures;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public Figure[] getFigures() {
        return figures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Figure f: figures){
            sb.append(f);
            sb.append("\n");
        }
        return sb.toString();
    }
}
