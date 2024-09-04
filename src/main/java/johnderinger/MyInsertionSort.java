package johnderinger;

import java.util.Arrays;

/**
 * An in-place and non-stable sorting algorithm that generally performs worse than the similar insertion sort.
 *   The algorithm divides the input array into two parts, the sorted part which begins at index[0] and builds
 *    right as the data is sorted, and the unsorted items occupying the remainder of the array.
 */
public class MyInsertionSort {

    public static void main (String[] args) {
//        int[] data = {1, 10, 41, 67, 6, 3, 23};
        int[] data = new int[10];

        insert(data, 0,1);
        insert(data, 1, 10);
        insert(data, 2, 41);
        insert(data, 3, 45);
        insert(data, 4, 5);
        insert(data, 5, 61);
        insert(data, 6, 7);

        insertionSort(data, 1);
    }

    private static void insert(int[] data, int index, int value) {
        System.out.println("Data [" + Arrays.toString(data) + "]");
        data[index] = value;
        for (int i = 0; i <= index; i++ ) {
            System.out.println("Is data[" + index + "][" + data[index] + "] < data[" + i + "][" + data[i] + "]");
            if (data[index] < data[i]) {
                swap(data, index, i);
            }
        }
    }

    private static void insertionSort(int[] data, int x) {
        System.out.println("Unsorted Array [" + Arrays.toString(data) + "]");

        for (int unsortedIndex = 1; unsortedIndex < data.length; unsortedIndex++) {
            for (int sortedIndex = 0; sortedIndex < unsortedIndex; sortedIndex++) {
                System.out.println("SortedIndex [" + sortedIndex + "] value [" + data[sortedIndex] + "]");
                System.out.println("UnsortedIndex [" + unsortedIndex + "] value [" + data[unsortedIndex] + "]");
                System.out.println("Is [" + data[unsortedIndex] + "] less than [" + data[sortedIndex] + "]");
                if (data[unsortedIndex] < data[sortedIndex]) {
                    System.out.println("Yes, Swap");
                    swap (data, unsortedIndex, sortedIndex);
//                    unsortedIndex--;
                }
                System.out.println("==================");
            }
        }

        System.out.println("Sorted Array [" + Arrays.toString(data) + "]");
    }

    private static void swap (int[] data, int index1, int index2) {
        System.out.println("swap Array Before [" + Arrays.toString(data) + "]");
        System.out.println("swap [" + index1 + "][" + data[index1] +
                "] with [" + index2 + "][" + data[index2] + "]");

        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;

        System.out.println("swap Array After [" + Arrays.toString(data) + "]");
        System.out.println("=======================");
    }

    public static void insertionSort(int[] data) {
        int outer_i, inner_i, value;
        for (outer_i = 1; outer_i < data.length; outer_i++) {
            value = data[outer_i];
            inner_i = outer_i;
            // Note the nested loop, common with quadratic algorithms
            // iterate right to left,
            //  compare ‘value’ with element to the left
            while (inner_i > 0 && value < data[inner_i - 1]) {
                // Move element right one index per iteration
                //  to make room for ‘value’ as it moves left
                data[inner_i] = data[inner_i - 1];
                inner_i--;
            }
            data[inner_i] = value;
        }
    }

}
