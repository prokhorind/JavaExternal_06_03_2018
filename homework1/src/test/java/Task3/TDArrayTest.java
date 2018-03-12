package Task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denis Prokhorin on 12.03.2018.
 */
public class TDArrayTest {

    private TDArray tdArray;

    @Before
    public void init(){
        tdArray = new TDArray(3,3);
        tdArray.initialize(0,6);
    }
    @After
    public void remove(){
        tdArray=null;
    }
    @Test
    public void compareLines() throws Exception {
        System.out.println("Task2");
        System.out.println("Before:");
        tdArray.print();
        System.out.println("After:");
        tdArray.compareLines();
        tdArray.print();

    }

    @Test
    public void sort() throws Exception {
        System.out.println("Task1");
        System.out.println("Before:");
        tdArray.print();
        System.out.println("After:");
        tdArray.sort();
        tdArray.print();
    }

    @Test
    public void selectValuesByHelix() throws Exception {
        System.out.println("Task3");
        System.out.println("Before:");
        tdArray.print();
        System.out.println("After:");
        tdArray.selectValuesByHelix();
    }

}