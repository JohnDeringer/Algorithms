import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A simple and slow sorting algorithm that repeatedly selects the lowest or highest
 * element from the unsorted section and moves it to the end of the sorted section.
 * <p/>
 * First find the smallest element in the array and exchange it with the element in the
 * first position, then find the second smallest element and exchange it with the element
 * in the second position, and continue in this way until the entire array is sorted.
 * Its asymptotic complexity is O(n2) making it inefficient on large arrays.
 * <p/>
 * http://rosettacode.org/wiki/Sorting_algorithms/Selection_sort#Java
 *
 * Worst case: O(n²)
 * Best case: O(n²)
 * Avg case: O(n²)
 * Worst case space complexity: O(n) total, O(1) auxiliary
 */
public class SelectionSort {

    public static void sort(int[] data) {

        // Iterate through array - nums[outerX] - and replace each index in array
        //  with the next ordered value in array
        for (int outerX = 0; outerX < data.length - 1; outerX++) {
            int smallestValue = Integer.MAX_VALUE;
            int smallestX = outerX + 1;

             // Iterate through every item in the array, excluding previous filled,
             //  finding the smallest value (smallestX index)
            for (int innerX = outerX; innerX < data.length; innerX++) {
                if (data[innerX] < smallestValue) {
                    comparisonCount++;
                    smallestX = innerX;
                    smallestValue = data[innerX];
                //} else {
                //    System.out.println("KEEP:" + data[innerX] + " > " +  smallestValue);
                    //System.out.println("KEEP:" + Arrays.toString(data));
                }
            }

            System.out.println("SWAP:" + data[outerX] + " & " +  data[smallestX]);
            System.out.println("outerX [" + outerX + "] smallestX [" + smallestX + "]");

            // Swap smallestX value with outerX value
            if (outerX != smallestX) {
                writeCount++;
                int temp = data[outerX];
                data[outerX] = data[smallestX];
                data[smallestX] = temp;
            }

            System.out.println("DATA:" + Arrays.toString(data));
        }

    }

    public static void main(String[] args) {


        //int[] data = {1001,899,1,903,3,5,6,88,5690,89,99,106,111,123,433,455,786,900,1200,1323,1344,1478};
        //int[] data = {1001,899,1,903,3,5,6,88};
        int[] data = {41, 67, 6, 3, 23};
        System.out.println("BEG:" + Arrays.toString(data));
        SelectionSort.sort(data);

        System.out.println("END:" + Arrays.toString(data));
        System.out.println("Comparison Count: " + comparisonCount);
        System.out.println("Write Count: " + writeCount);

    }

    public static int comparisonCount = 0;
    public static int writeCount = 0;

}
