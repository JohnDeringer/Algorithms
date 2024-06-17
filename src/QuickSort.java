import java.util.Date;
import java.util.Random;

/**
 * Quicksort
 * Quicksort is a divide and conquer algorithm, also known as partition-exchange sort.
 * Quicksort first divides a large list into two smaller sub-lists:
 * the low elements and the high elements.
 * Quicksort can then recursively sort the sub-lists.
 *
 * The steps are:
 * 1. Pick an element, called a pivot, from the list.
 * 2. Reorder the list so that all elements with values less than the pivot come before
 *   the pivot, while all elements with values greater than the pivot come after it
 *   (equal values can go either way). After this partitioning, the pivot is in its final
 *   position. This is called the partition operation.
 * 3. Recursively sort the sub-list of lesser elements and the sub-list of greater elements.
 *   It is also known as partition-exchange sort.
 *   Quicksort's sequential and localized memory references work well with a cache.
 *   Quicksort can be implemented with an in-place partitioning algorithm,
 *   so the entire sort can be done with only O(log n) additional space
 *
 * Complexity analysis
 *   On the average quicksort has O(n log n) complexity, but strong proof of this fact is not trivial and
 *   not presented here. Still, you can find the proof in [1]. In worst case, quicksort runs O(n2) time,
 *   but on the most "practical" data it works just fine and outperforms other O(n log n) sorting algorithms.
 * Code snippets
 *   Partition algorithm is important per se, therefore it may be carried out as a separate function.
 *   The code for C++ contains solid function for quicksort, but Java code contains two separate functions
 *   for partition and sort, accordingly.
 *
 * http://www.algolist.net/Algorithms/Sorting/Quicksort
 *
 * Worst case: O(n²)
 * Avg case: O(n log n)
 * Best case: O(n log n)
 *
 * java QuickSort < quickSort.txt
 */
public class QuickSort {

    /**
     * Reorder the list so that all elements with values less than the pivot come before
     *  the pivot, while all elements with values greater than the pivot come after it.
     * @param data The array of numbers
     * @param left_i most left index position, will iterate(increment) toward the pivot
     * @param right_i most right index position, will iterator(decrement) toward the pivot
     * @return return the location of the pivot
     */
    public static int partition(int data[], int left_i, int right_i) {
        int l = left_i, r = right_i;
        int tmpValue;
        // Selecting the middle arr is a guess as a median value
        int pivotValue = data[(left_i + right_i) / 2];
        //int pivotValue = data[left_i];
       // int pivotValue = data[right_i];
System.out.println("pivot index [" + ((left_i + right_i) / 2) + "] value [" + pivotValue + "]");
        // Start at each end of the array and work inward toward the center swapping items, if necessary
        while (l <= r) {
            // select values in the 'left' array that are less than the pivot
            //  we will want to swap these with the 'right'
            while (data[l] < pivotValue) {
                l++;
            }
            // select values in the 'right' array that are less than the pivot
            //  we will want to swap these with the 'left'
            while (data[r] > pivotValue) {
                r--;
            }
            // Relative to the pivot
            // Swap lower values, on the right side, with higher values, on the left side
            if (l <= r) {
                System.out.println("swap (" + l + "," + r + ") values (" +
                        data[l] + "," + data[r] + ")");
                tmpValue = data[l];
                data[l] = data[r];
                data[r] = tmpValue;

        //        printOrder(data);

                System.out.println();

                // increment left index
                l++;
                // decrement right index
                r--;
            }
        }

        // Return the location of the pivot
        return l;
    }

    public static void quickSort(int data[], int left_i, int right_i) {
        System.out.println("");
        System.out.println("quickSort left [" + left_i + "] right [" + right_i + "]");

        // Returns the index of the pivot
        int pivot_i = partition(data, left_i, right_i);
        System.out.println("pivot index [" + pivot_i + "]");

        // Iterate recursively beginning at the pivot and moving to the left
        if (left_i < pivot_i - 1) {
            // Sort left half of array
            quickSort(data, left_i, pivot_i - 1);
        }
        // Iterate recursively beginning at the pivot and moving right
        if (pivot_i < right_i) {
            // Sort right half of array
            quickSort(data, pivot_i, right_i);
        }
    }

    public static void main(String argv[]) {
        //int[] A = {1001,899,1,903,3,5,6};
        //int[] data = {1001,899,1,903,3,5,6,88,5690,89,99,106,111,123,433,455,786,900,1200,1323,1344,1478};
        //int[] A = In.readInts(argv[0]);

        int[] data = {3, 67, 6, 41, 23, 2};

        //int[] data = getData(1000);

        printOrder(data);

        Date start = new Date();

        quickSort(data, 0, data.length - 1);

        Date end = new Date();

        printOrder(data);

        System.out.println("start: " + start.getTime());
        System.out.println("end: " + end.getTime());
        System.out.println("elapsed: " + (end.getTime() - start.getTime()) + " milliseconds");

        //System.out.println("data.toString: " + data.toString());
    }

    private static void printOrder(int[] A) {
        System.out.print("Order [ ");
        for (int a : A) System.out.print(a + " ");
        System.out.print("]");
        System.out.println();
    }

    public QuickSort() {
    }

    private static int[] getData(int size) {

        int[] numbers = new int[size];
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt();
        }

        return numbers;
    }

}
