package Task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Denis Prokhorin on 12.03.2018.
 */
public class SortTest {

     private Sort sort;
    @Before
    public void init(){
        sort=new Sort();
    }
    @After
    public void remove(){
        sort=null;
    }
    @Test
    public void sort() throws Exception {

        int[] input={1,-1,1,-5,-6,2,-3}  ;
        System.out.println("Before:");
        System.out.println(Arrays.toString(input));


        int[]output= sort.sort(input);
        System.out.println("After:");
        System.out.println(Arrays.toString(output));
        System.out.println("Number of negative values="+sort.findNubmerOfNegativeValues(input));
    }

}