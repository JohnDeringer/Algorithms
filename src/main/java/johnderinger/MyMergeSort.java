package johnderinger;

import java.util.Arrays;

/**
 * Merge sort is a sorting algorithm that follows the divide-and-conquer approach. It works by recursively
 * dividing the input array into smaller sub-arrays and sorting those sub-arrays then merging them back
 * together to obtain the sorted array.
 *
 * Time Complexity:
 * Best Case: O(n log n), When the array is already sorted or nearly sorted.
 * Average Case: O(n log n), When the array is randomly ordered.
 * Worst Case: O(n log n), When the array is sorted in reverse order.
 */
public class MyMergeSort {

    public static void main(String[] args)
    {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is: " + Arrays.toString(arr));

        MyMergeSort ob = new MyMergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is: " + Arrays.toString(arr));
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int leftIndex, int rightIndex)
    {
        if (leftIndex < rightIndex) {

            // Find the middle point
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // Sort first and second halves
            sort(arr, leftIndex, middleIndex);
            sort(arr, middleIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(arr, leftIndex, middleIndex, rightIndex);
        }
    }

    // Merges two sub-arrays of arr[].
    // First sub-array is arr[l..m]
    // Second sub-array is arr[m+1..r]
    void merge(int[] arr, int leftIndex, int middleIndex, int rightIndex)
    {
        // Find sizes of two sub-arrays to be merged
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        // Create temp arrays to avoid modifying original array
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data to temp arrays
        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = arr[leftIndex + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = arr[middleIndex + 1 + j];
        }

        // Merge the temp arrays

        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = leftIndex;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }



}
