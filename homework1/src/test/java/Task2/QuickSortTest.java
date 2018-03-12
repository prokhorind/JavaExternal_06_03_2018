package Task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Denis Prokhorin on 12.03.2018.
 */
public class QuickSortTest {



    @Test
    public void quickSort() throws Exception {
       int[] x =  {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Before");
        System.out.println(Arrays.toString(x));

        int min = 0;
        int max = x.length - 1;

        QuickSort.quickSort(x, min, max);
        System.out.println("After");
        System.out.println(Arrays.toString(x));
    }

}