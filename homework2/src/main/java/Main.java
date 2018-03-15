import task1.figures.DynamicArray;
import task1.figures.figure.Circle;
import task1.figures.figure.Shape;
import task1.figures.figure.Rectangle;
import task1.figures.figure.Triangle;
import task2.Figure;
import task2.Point;
import task2.Poligon;


/**
 * Created by kleba on 15.03.2018.
 */
public class Main {

    public static  void  main(String[] args){
        Shape f1= new Circle(1,2,5);
        Shape f2= new Rectangle(3,4);
        Shape f3= new Triangle(5,6,"Right");

        DynamicArray dm = new DynamicArray();
        dm.addValue(f1);
        dm.addValue(f2);
        dm.addValue(f3);

        for(int i=0;i<dm.countValues();i++){
            System.out.println(dm.getObject()[i]);

        }


        Point p1= new Point(1,5);
        Point p2= new Point(1,2);
        Point p3= new Point(4,2);
        Point p4= new Point(4,5);
        Point[] points={p1,p2,p3,p4};
        Figure figure1 = new Figure("square",points);
        Point[] points2={p1,p2};
        Figure figure2 = new Figure("line",points2);
        Point[] points3={p3};
        Figure figure3= new Figure("dot",points3);

        Figure[] figures= {figure1,figure2,figure3};

        Poligon pg = new Poligon(figures);
        System.out.println(pg);
        }
    }

