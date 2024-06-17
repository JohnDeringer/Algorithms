import java.util.Arrays;
import java.util.Random;

/**
 * HeapSort
 *
 * Heapsort is an in-place sorting algorithm with <b>worst case</b> and average
 * complexity of O(n log n).
 * The basic idea is to turn the array into a binary heap structure,
 * which has the property that it allows
 * efficient retrieval and removal of the maximal element.
 * We repeatedly "remove" the maximal element from the heap,
 * thus building the sorted list from back to front.
 * Heapsort requires random access,
 * so can only be used on an array-like data structure.
 *
 * http://rosettacode.org/wiki/Sorting_algorithms/Heapsort#Java
 *
 * Worst case: O(n log n)
 * Avg case: O(n log n)
 *
 *  BEGIN:   [32, 67, 76, 23, 41, 58, 85, 14,  1]
 *  siftDown:[32, 67, 85, 23, 41, 58, 76, 14,  1]
 *  siftDown:[85, 67, 76, 23, 41, 58, 32, 14,  1]
 *  heapify: [85, 67, 76, 23, 41, 58, 32, 14,  1]
 *
 *  siftDown:[76, 67, 58, 23, 41,  1, 32, 14, 85]
 *  siftDown:[67, 41, 58, 23, 14,  1, 32, 76, 85]
 *  siftDown:[41, 23, 32,  1, 14, 58, 67, 76, 85]
 *  siftDown:[32, 23, 14,  1, 41, 58, 67, 76, 85]
 *  siftDown:[23,  1, 14, 32, 41, 58, 67, 76, 85]
 *  siftDown:[ 1, 14, 23, 32, 41, 58, 67, 76, 85]
 *  END:     [ 1, 14, 23, 32, 41, 58, 67, 76, 85]
 */
public class HeapSort {

    public HeapSort(int[] a) {
        heapSort(a);
    }

    public static void heapSort(int[] data) {
        int count = data.length;

        // first place a in max-heap order
        heapify(data, count);

        print("after heapify", data);
/*
        int end = count - 1;
        while (end > 0) {
            // swap the root(maximum value) of the heap with the
            // last element of the heap
            int tmp = data[end];
            data[end] = data[0];
            data[0] = tmp;

            writeCount++;

            System.out.println("Swapping root[" + end + ":" + data[0] +
                    "] and [" + 0 + ":" + data[end] + "]");

            print("after_root_swap", data);

            // put the heap back in max-heap order
            siftDown(data, 0, end - 1);

            print("after siftDown", data);
            // decrement the size of the heap so that the previous
            // max value will stay in its proper place
            end--;
        }
 */
    }

    public static void heapify(int[] data, int count) {
        // start is assigned the index of the last parent node
        //  so the shiftDown process starts with the last parent node
        //   (start, count-1)
        int start = (count - 2) / 2; // binary heap

        while (start >= 0) {
            // sift down the node at index start to the proper place
            // such that all nodes below the start index are in heap
            // order
            siftDown(data, start, count - 1);
            //print("after_siftDown", data);
            start--;
        }

        // after sifting down the root all nodes/elements are in heap order
    }

    public static void siftDown(int[] data, int start, int end) {
        // end represents the limit of how far down the heap to sift
        int root = start;
        // While the root has at least one child
        while ((2 * root + 1) <= end) {
            // root*2+1 points to the left child
            int child = 2 * root + 1;
            // take the highest of the left or right child
            if (child + 1 <= end && data[child] < data[child + 1]) {
                comparisonCount++;
                //... then point to the right child instead
                child = child + 1;
            }

            // out of max-heap order
            // Swap the child with root if child is greater
            if (data[root]  <  data[child]) {
                comparisonCount++;
                int tmp  =  data[root];
                data[root]  =  data[child];
                data[child] =  tmp;

                writeCount++;
//                System.out.println(
//                    "siftDown.Swapping[" + root + ":" + data[child] +
//                        "] and [" + child + ":" + data[root] + "]");
//
//                print("siftDown:after_swap", data);

                // return the swapped root to test against it's new children
                root = child;
            } else {
                return;
            }
        } // End while

    }

    public static void main(String[] args) {
//        int MAX = 20;
//        int SIZE = 7;
//        int MAX = 100;
//        int SIZE = 70;
//        int[] numbers = new int[SIZE];
//        Random generator = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = generator.nextInt(MAX);
//            StdOut.print(numbers[i] + " ");
//        }
//        StdOut.println("");

        //long startTime = System.currentTimeMillis();

        //int[] data = {32, 67, 76, 23, 41, 58, 85, 14, 1};
       // int[] data = {41, 67, 6, 3, 23};
        //int[] data = {1, 19, 17, 3, 2, 7, 36, 25, 100};
        //int[] data = {100, 19, 36, 17, 3, 25, 1, 2, 7};
        int[] data = {1, 3, 36, 2, 19, 25, 100, 17, 7};

        print("BEGIN", data);

        new HeapSort(data);

        print("END", data);

        System.out.println("Comparison Count: " + comparisonCount);
        System.out.println("Write Count: " + writeCount);

//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println("Heapsort ElapsedTime: " + elapsedTime);
//
//        for (int i = 0; i < numbers.length - 1; i++) {
//            StdOut.print(numbers[i] + " ");
//            if (numbers[i] > numbers[i + 1]) {
//                System.out.println("ERROR - INCORRECT ORDER");
//            }
//        }
    }

    static void print(String label, int[] data) {

        System.out.println(label + ":" + Arrays.toString(data));

    }

    public static int comparisonCount = 0;
    public static int writeCount = 0;

}
