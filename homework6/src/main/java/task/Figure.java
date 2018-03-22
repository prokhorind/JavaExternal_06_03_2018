package task;

import java.io.Serializable;

/**
 * Created by kleba on 15.03.2018.
 */
public class Figure implements Serializable{

    private Line[] lines;
    private String name;
    public Figure(Line[] lines ,String name) {
        this.lines = lines;
        this.name=name;
    }

    public Figure(Object[] object, String name) {
        Line line;
        this.name=name;
        this.lines = new Line[object.length];
        for(int i=0;i<lines.length;i++){
          lines[i]= (Line) object[i];
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    public Line[] getLines() {
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Name=");
            sb.append(name);
            sb.append(";");
            sb.append("\n");
            for(Line f: lines){
                if(f!=null) {
                    sb.append("Line:");
                    sb.append(f);
                    sb.append("\n");
                }
            }
        return sb.toString();
    }
}
