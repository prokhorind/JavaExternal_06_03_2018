package Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denis Prokhorin on 12.03.2018.
 */
public class FigureTest {

 Figure figure;
    @Before
    public void init(){

        figure= new Figure();
    }
    @After
    public void remove(){
        figure=null;
    }

    @Test
    public void drawRectangle() throws Exception {
        System.out.println("Rectangle:");
        figure.drawRectangle(4, 5);
        System.out.println();
    }

    @Test
    public void drawRightTriangle() throws Exception {
            System.out.println("Right Rectangle:");
            figure.drawRightTriangle(4,4);
            System.out.println();
    }

    @Test
    public void drawEquilateralTriangle() throws Exception {
        System.out.println("EquilateralTriangle");
        figure.drawEquilateralTriangle(5);
        System.out.println();
    }

    @Test
    public void drawRhomb() throws Exception {
        System.out.println("Rhomb:");
        figure.drawRhomb(3);
        System.out.println();
    }

}