import task1.figures.DynamicArray;
import task1.figures.figure.Circle;
import task1.figures.figure.Shape;
import task1.figures.figure.Rectangle;
import task1.figures.figure.Triangle;
import task2.Line;
import task2.Point;
import task2.Figure;

import java.io.*;
import java.util.Arrays;


/**
 * Created by kleba on 15.03.2018.
 */
public class Main {

    public static  void  main(String[] args){

        Point p1 = new Point(1,5);
        Point p2 = new Point(1,2);
        Point p3 = new Point(4,2);
        Point p4 = new Point(4,5);
        Point p5 = new Point(3,2);
        Point p6 = new Point(3,5);
        Point p7 = new Point(2,2);
        Point p8 = new Point(2,5);
        Point[] points = {p1,p2,p3,p4};
        Figure rectangle = new Figure(createFigure(points).getObject() ,"Rectangle");
        points= new Point[]{p1,p2,p3};
        Figure triangle = new Figure(createFigure(points).getObject() ,"Triangle");
        points= new Point[]{p1,p2,p3,p4,p5,p6,p7,p8};
        Figure tree = new Figure(createFigure(points).getObject() ,"Tree");
        writeInFile(rectangle,"rectangle.txt");
        writeInFile(triangle,"triangle.txt");
        writeInFile(tree,"tree.txt");
        System.out.println(readFromFile("rectangle.txt"));
        System.out.println(readFromFile("triangle.txt"));
        System.out.println(readFromFile("tree.txt"));
        }

        public static boolean writeInFile(Figure figure,String name){

            try(FileOutputStream fous =new FileOutputStream(name);
                ObjectOutputStream oos=new ObjectOutputStream(fous)){
                oos.writeObject(figure);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        public static Figure readFromFile(String name){
            Figure figure = null;
            try(FileInputStream fin = new FileInputStream(name);
                ObjectInputStream ois = new ObjectInputStream(fin);){
                figure = (Figure) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return figure;
        }

        public static DynamicArray createFigure(Point[] points){
            DynamicArray dmLine = new DynamicArray();
            for(int i = 0; i< points.length;i++){
                if(i+1==points.length){
                    dmLine.addValue(new Line(points[i],points[0]));
                }else {
                    dmLine.addValue(new Line(points[i],points[i+1]));
                }
            }
            return dmLine;
        }
    }

