package johnderinger;

import java.util.Arrays;

/**
 * Is the simples sorting algorithm that works by repeatedly swapping the adjacent elements if they
 *  are in the wrong order. The algorithm starts at the beginning of the dataset. It compares the first two elements,
 *  and if the first is greater than the second, it swaps them. It continues doing this for each pair of adjacent
 *  elements to the end of the dataset. It then starts again with the first two elements, repeating again until
 *  no more swaps have occurred.
 *
 * Time Complexity:
 *   Best Case: O(n)
 *   Average Case: O(n^2)
 *   Worst Case: O(n^2)
 *   Space Complexity: O(1)
 */
public class MyBubbleSort {

    public static void main (String[] args) {

        int[] data = {41, 67, 6, 3, 23};
        bubbleSort(data, 1);


        System.out.println("Sorted Array [" + Arrays.toString(data) + "]");
    }

    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int sortedIndex = 0; sortedIndex < data.length - 1 - i; sortedIndex++) {
                System.out.println("Iteration [" + Arrays.toString(data) + "]");
                System.out.println("Is [" + data[sortedIndex] + "] < [" + data[sortedIndex + 1] + "]");
                if (data[sortedIndex] > data[sortedIndex + 1]) {
                    swap(data, sortedIndex, sortedIndex + 1);
//                    swapping = true;
//                    break;
                }
//                swapping = false;
            }
        }
    }

    private static boolean swapping = true;
    public static void bubbleSort(int[] data, int x) {
        // swapping == false when the array is sorted
        while (swapping) {
            for (int sortedIndex = 1; sortedIndex < data.length; sortedIndex++) {
                System.out.println("Iteration [" + Arrays.toString(data) + "]");
                System.out.println("Is [" + data[sortedIndex] + "] < [" + data[sortedIndex - 1] + "]");
                if (data[sortedIndex] < data[sortedIndex - 1]) {
                    swap(data, sortedIndex, sortedIndex - 1);
                    swapping = true;
                    break;
                }
                swapping = false;
            }
        }
    }

    private static void swap (int[] data, int index1, int index2) {
//        System.out.println("swap Array Before [" + Arrays.toString(data) + "]");
        System.out.println("swap Array value [" + data[index1] + "] with [" + data[index2] + "]");

        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
        System.out.println("swap Array After [" + Arrays.toString(data) + "]");
        System.out.println("=====================");
    }

//    public static void bubbleSort(int[] data) {
//        boolean swapped = true; // initialize to begin first pass
//        int temp; // temp swap data
//
//        while (swapped) {
//            // initialize to false for each iteration
//            swapped = false;
//            // Note the nested loop, common with quadratic algorithms
//            for (int i = 0; i < data.length - 1; i++) {
//                // If left value is greater than it's right sibling -> swap
//                if (data[i] > data[i + 1]) {
//                    // data swap
//                    temp = data[i];
//                    data[i] = data[i + 1];
//                    data[i + 1] = temp;
//                    // flags the outer loop that we need to continue
//                    swapped = true;
//                }
//            }
//        }
//    }
}
