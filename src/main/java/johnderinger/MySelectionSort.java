package johnderinger;

import java.util.Arrays;

/**
 * An in-place and non-stable sorting algorithm that generally performs worse than the similar insertion sort.
 *   The algorithm divides the input array into two parts, the sorted part which begins at index[0] and builds right
 *   as the data is sorted, and the unsorted items occupying the remainder of the array. Initially the sorted part
 *   is empty and the unsorted part occupies the full array. It then finds the smallest element in the array and
 *   exchanges it with the element in the first position, then find the second smallest element and exchanges it
 *   with the element in the second position, and continues until the entire array is sorted.
 *
 * Time Complexity:
 *   Best Case: O(n^2)
 *   Average Case: O(n^2)
 *   Worst Case: O(n^2)
 *   Space Complexity: O(1)
 */

public class MySelectionSort {

    public static void main (String[] args) {

        int[] data = {41, 67, 6, 3, 23};
        selectionSort(data, 1);
    }

    // 41, 67, 6, 3, 23
    public static void selectionSort(int[] data, int x) {
        System.out.println("Unsorted Array [" + Arrays.toString(data) + "]");

        for (int sortedIndex = 0; sortedIndex < data.length; sortedIndex++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int unsortedIndex = sortedIndex; unsortedIndex < data.length; unsortedIndex++) {
                int unsortedValue = data[unsortedIndex];
                if (unsortedValue < minValue) {
                    minValue = unsortedValue;
                    minIndex = unsortedIndex;
                }
                if (unsortedIndex == data.length -1) {
                    swap (data, minIndex, sortedIndex);
                }
            }
        }

        System.out.println("Sorted Array [" + Arrays.toString(data) + "]");
    }

    // 41, 67, 6, 3, 23
    private static void swap (int[] data, int index1, int index2) {
        System.out.println("swap Array Before [" + Arrays.toString(data) + "]");
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
        System.out.println("swap Array After [" + Arrays.toString(data) + "]");
    }

    public static void selectionSort(int[] data) {
        // Iterate through array - nums[outer_i] - and replace each
        // index in array with the next ordered value in array
        for (int outer_i = 0; outer_i < data.length - 1; outer_i++) {
            int smallestValue = Integer.MAX_VALUE;
            int smallest_i = outer_i + 1;

            // Note the nested loop, common with quadratic algorithms
            // Iterate through every item in the array, excluding
            // previous filled, finding the smallest value
            for (int inner_i = outer_i; inner_i < data.length; inner_i++) {
                if (data[inner_i] < smallestValue) {
                    smallest_i = inner_i;
                    smallestValue = data[inner_i];
                }
            }

            // Once the smallest value is found
            //  swap smallest_i & outer_i
            if (outer_i != smallest_i) {
                int temp = data[outer_i];
                data[outer_i] = data[smallest_i];
                data[smallest_i] = temp;
            }
        }
    }
}
