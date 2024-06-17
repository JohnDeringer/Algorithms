import java.util.*;

/**
 * Mergesort is an O(n log n) comparison-based, divide and conquer algorithm
 * with most implementations producing a stable sort.
 * <p/>
 * Conceptually, a merge sort works as follows
 * <ul><li>Divide the unsorted list into n sublists,
 * each containing 1 element (a list of 1 element is considered sorted).</li>
 * <li>Repeatedly merge sublists to produce new sublists until there is only
 * 1 sublist remaining. This will be the sorted list.</li></ul>
 * <p/>
 * A natural merge sort is similar to a bottom up merge sort except that any
 * naturally occurring runs (sorted sequences) in the input are exploited.
 * In the bottom up merge sort, the starting point assumes each run is one
 * item long. In practice, random input data will have many short runs that
 * just happen to be sorted. In the typical case, the natural merge sort may
 * not need as many passes because there are fewer runs to merge.
 * <p/>
 * <p/>
 * Start: [32, 67, 76, 23, 41, 58, 85, 14, 1]
 * <p/>
 * merge: start[0] middle[1] end[2]
 * // merge(0-1)
 * data:[32, 67, 76, 23, 41, 58, 85, 14, 1]
 * tmp: [32, 67,  0,  0,  0,  0,  0,  0, 0]
 * data:[32, 67, 76, 23, 41, 58, 85, 14, 1]
 * <p/>
 * merge: start[2] middle[3] end[4]
 * // merge (2-3)
 * data:[32, 67, 76, 23, 41, 58, 85, 14, 1]
 * tmp: [ 0,  0, 23, 76,  0,  0,  0,  0, 0]
 * data:[32, 67, 23, 76, 41, 58, 85, 14, 1]
 * <p/>
 * merge: start[0] middle[2] end[4]
 * // merge (0-3)
 * data:[32, 67, 23, 76, 41, 58, 85, 14, 1]
 * tmp: [23, 32, 67, 76, 0,   0,  0,  0, 0]
 * data:[23, 32, 67, 76, 41, 58, 85, 14, 1]
 * <p/>
 * merge: start[4] middle[5] end[6]
 * // merge (4-5)
 * data:[23, 32, 67, 76, 41, 58, 85, 14, 1]
 * tmp: [0,   0,  0,  0, 41, 58,  0,  0, 0]
 * data:[23, 32, 67, 76, 41, 58, 85, 14, 1]
 * <p/>
 * <p/>
 * merge: start[7] middle[8] end[9]
 * // merge (7-8)
 * data:[23, 32, 67, 76, 41, 58, 85, 14,  1]
 * tmp: [ 0,  0,  0,  0,  0,  0,  0,  1, 14]
 * data:[23, 32, 67, 76, 41, 58, 85,  1, 14]
 * <p/>
 * merge: start[6] middle[7] end[9]
 * // merge (6-8)
 * data:[23, 32, 67, 76, 41, 58, 85,  1, 14]
 * tmp: [ 0,  0,  0,  0,  0,  0,  1, 14, 85]
 * data:[23, 32, 67, 76, 41, 58,  1, 14, 85]
 * <p/>
 * merge: start[4] middle[6] end[9]
 * // merge (4-8)
 * data:[23, 32, 67, 76, 41, 58, 1, 14, 85]
 * tmp: [0, 0, 0, 0, 1, 14, 41, 58, 85]
 * data:[23, 32, 67, 76, 1, 14, 41, 58, 85]
 * <p/>
 * merge: start[0] middle[4] end[9]
 * // merge (0-8)
 * data:[23, 32, 67, 76, 1, 14, 41, 58, 85]
 * tmp: [1, 14, 23, 32, 41, 58, 67, 76, 85]
 * data:[1, 14, 23, 32, 41, 58, 67, 76, 85]
 * <p/>
 * End: [1, 14, 23, 32, 41, 58, 67, 76, 85]
 */
public class Mergesort {

    static int interationCount = 0;

    public static void main(String[] args) {

        //int[] data = {32, 67, 76, 23, 41, 58, 85, 14, 1};
       // int[] data = {41, 67, 6, 3, 23};
        int[] data = {3, 67, 6, 41, 23};
        System.out.println("Start: " + Arrays.toString(data));

        mergesort(data, 0, data.length);

        System.out.println("End: " + Arrays.toString(data));
    }

    public static void mergesort(int data[], int start_i, int end_i) {

        //int mid2 = (end - start) / 2;

        // reached the end
        if (end_i - start_i == 1) {
            System.out.println(
                    "mergesort:end start[" + start_i + "] end[" + end_i + "]");
            return;
        }

       // interationCount++;

        int mid_i = start_i + (end_i - start_i) / 2;

        // left half
        mergesort(data, start_i, mid_i);
        // right half
        mergesort(data, mid_i, end_i);
        // merge
        merge(data, start_i, mid_i, end_i);
    }

    public static void merge(int data[], int start_i, int middle_i, int end_i) {

        System.out.println(
                "merge: start[" + start_i + "] middle[" +
                        middle_i + "] end[" + end_i + "] size [" + (end_i - start_i) + "]");

        int[] tmp_data = new int[data.length];
        int left_i = start_i;
        int right_i = middle_i;
        int tmp_i = start_i;

        while (left_i < middle_i || right_i < end_i) {

            if (left_i == middle_i) {
                // Reached the middle, assign data[right_i]
                tmp_data[tmp_i] = data[right_i];
                right_i++;
            } else if (right_i == end_i) {
                // Reached the end, assign data[left_i]
                tmp_data[tmp_i] = data[left_i];
                left_i++;
            } else if (data[left_i] < data[right_i]) {
                // Swap lower of left or right values
                tmp_data[tmp_i] = data[left_i];
                left_i++;
            } else {
                // Swap lower of left or right values
                tmp_data[tmp_i] = data[right_i];
                right_i++;
            }
            tmp_i++;

        } // End while

        // Update the data array with the sorted tmp values
        for (tmp_i = start_i; tmp_i < end_i; tmp_i++) {
            data[tmp_i] = tmp_data[tmp_i];
        }
        print("tmp", tmp_data);
        print("data", data);
    }

    static void print(String label, int[] data) {

        System.out.print(label + ":" + Arrays.toString(data));
        System.out.println();
    }

//    private int[] numbers;
//    private int[] helper;
//
//    public Mergesort(int[] numbers) {
//        this.numbers = numbers;
//    }
//
//    public void sort(int[] values) {
//        this.numbers = values;
//        int number = values.length;
//        this.helper = new int[number];
//        mergesort(0, number - 1);
//    }
//
//    private void mergesort(int low, int high) {
//        // Check if low is smaller then high, if not then the array is sorted
//        if (low < high) {
//            // Get the index of the element which is in the middle
//            int middle = (low + high) / 2;
//            // Sort the left side of the array
//            mergesort(low, middle);
//            // Sort the right side of the array
//            mergesort(middle + 1, high);
//            // Combine them both
//            merge(low, middle, high);
//        }
//    }
//
//    private void merge(int low, int middle, int high) {
//
//        // Copy both parts into the helper array
//        for (int i = low; i <= high; i++) {
//            helper[i] = numbers[i];
//        }
//
//        int i = low;
//        int j = middle + 1;
//        int k = low;
//        // Copy the smallest values from either the left or the right side back
//        // to the original array
//        while (i <= middle && j <= high) {
//            if (helper[i] <= helper[j]) {
//                numbers[k] = helper[i];
//                i++;
//            } else {
//                numbers[k] = helper[j];
//                j++;
//            }
//            k++;
//        }
//        // Copy the rest of the left side of the array into the target array
//        while (i <= middle) {
//            numbers[k] = helper[i];
//            k++;
//            i++;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int MAX = 20;
//        int SIZE = 7;
//        int[] numbers = new int[SIZE];
//        Random generator = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = generator.nextInt(MAX);
//            StdOut.print(numbers[i] + " ");
//        }
//        StdOut.println("");
//
//        Mergesort sorter = new Mergesort(numbers);
//
//        sorter.sort(numbers);
//
//        for (int i : numbers) {
//            StdOut.print(i + " ");
//        }
//    }

}
