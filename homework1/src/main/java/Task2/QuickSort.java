package Task2;

/**
 * Created by prokhorind on 10.03.2018.
 */
public class QuickSort {
    public static void quickSort(int[] array, int min, int max){

        int middlePos = (min +max) / 2;
        int middleElement = array[middlePos];
        int i = min;
        int j = max;

        while (i <= j) {
            while (array[i] > middleElement) {
                i++;
            }

            while (array[j] < middleElement) {
                j--;
            }

            if (i <= j) {
                int change= array[i];
                array[i] = array[j];
                array[j] = change;
                i++;
                j--;
            }
        }

        if (max > i) {
            quickSort(array, i, max);
        }

        if (min < j) {
            quickSort(array, min, j);
        }

        if (min >= max) {
            return;
        }
    }

}

