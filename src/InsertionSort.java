import java.util.Arrays;

/**
 * Insertion sort belongs to the O(n^2) sorting algorithms.
 * Unlike many sorting algorithms with quadratic complexity,
 * it is actually applied in practice for sorting small arrays of data.
 * For instance, it is used to improve quicksort routine.
 *
 * Insertion sort algorithm somewhat resembles selection sort.
 * Array is imaginary divided into two parts - sorted one and unsorted one.
 * At the beginning, sorted part contains first element of the array and
 * unsorted one contains the rest. At every step, algorithm takes first
 * element in the unsorted part and inserts it, in order, in the
 * sorted one. When unsorted part becomes empty, algorithm stops.
 * Stable, In-place
 */
public class InsertionSort {

    static void insertionSort(int[] data) {
        int outerX, innerX, value;
        for (outerX = 1; outerX < data.length; outerX++) {
            value = data[outerX];
            // Inialize inner index to outerX - ignore previously moved items
            innerX = outerX;

            //System.out.print("data[outer] [" + data[outer] + "]" +
           //  );

            // move left to compare value with left items
            while (innerX > 0 &&
                    value < data[innerX - 1]) {
                comparisonCount++;
                writeCount++;
                // Move item right one index to make room for value
                data[innerX] = data[innerX - 1];
                System.out.println("Data Shift:" + Arrays.toString(data));
                innerX--;
            }

            System.out.println("ASSIGN VALUE:" + value + " INDEX:" + innerX);

          //  if (innerX != outerX) {
                writeCount++;
                data[innerX] = value;
          //  }

            System.out.println("DATA:" + Arrays.toString(data));
        }
    }

    public static void main(String[] args) {

        //int[] data = {32, 67, 76, 23, 41, 58, 85, 14, 1};
        int[] data = {41, 67, 6, 3, 23};

        insertionSort(data);

        System.out.println("END:" + Arrays.toString(data));
        System.out.println("Comparison Count: " + comparisonCount);
        System.out.println("Write Count: " + writeCount);
    }

    public static int comparisonCount = 0;
    public static int writeCount = 0;

}
