package johnderinger;

import java.util.Arrays;
import java.util.Random;

/**
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element as a pivot
 *   and partitions the given array around the picked pivot by placing the pivot in its correct position in the
 *   sorted array.
 * The key process in quickSort is a partition() . The target of partitions is to place the pivot (any element can be chosen to be a pivot) at its correct position in the sorted array and put all smaller elements to the left of the pivot, and all greater elements to the right of the pivot.
 *
 * Partition is done recursively on each side of the pivot after the pivot is placed
 *   in its correct position and this finally sorts the array.
 *
 * Time Complexity:
 *  Best Case : Ω (n log (n))
 *  Average Case: θ (n log (n))
 *  Worst Case: O(n^2) - The worst-case Scenario for Quicksort occur when the pivot at each step consistently
 *      results in highly unbalanced partitions.
 */
public class MyQuickSort {

    static int[] origArray;

    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;
        origArray = arr.clone();

        System.out.println("-------------------");
        System.out.println("Before QuickSort: " + Arrays.toString(arr));
        quickSort(arr, 0, N - 1);
        System.out.println("After QuickSort: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        System.out.println("quickSort: array " + Arrays.toString(array) + " lowIndex [" + lowIndex + "] highIndex [" + highIndex + "]");

        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex];
        System.out.println("Retrieve new pivot value [" + pivot + "] from the end of the array [" + Arrays.toString(array) + "]");
//        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
//        System.out.println("quickSort: Select a new pivot using random index [" + pivotIndex + "]");
        // Place the pivot at the end of the array.
//        System.out.println("Place the pivot index [" + pivotIndex + "] value [" + array[pivotIndex] + "] at the end of the array [" + Arrays.toString(array) + "]");
//        swap(array, pivotIndex, highIndex);
//        int pivot = array[highIndex];
//        System.out.println("The pivot value [" + pivot + "] has been placed at the end of the array [" + Arrays.toString(array) + "]");

        System.out.println("-----------------");

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            System.out.println("quickSort: while leftPointer [" + leftPointer + "] < rightPointer [" + rightPointer + "]");

            // Increment left pointer until the left pointer value is less than or equal to the pivot
            System.out.println("-----------------");
            System.out.println("Enter left loop - Array " + Arrays.toString(array) + ", origArray " + Arrays.toString(origArray));
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                System.out.println("leftPointer array[" + leftPointer + "] value [" +
                        array[leftPointer] + "] <= pivot value [" + pivot + "] increment leftPointer to index [" + (leftPointer+1) + "]");
                leftPointer++;
            }
            if (leftPointer >= rightPointer) {
                System.out.println("leftPointer [" + leftPointer + "] >= rightPointer [" + rightPointer + "] exit left while loop");
            } else {
                System.out.println("leftPointer array[" + leftPointer + "] value [" +
                        array[leftPointer] + "] >= pivot value [" + pivot + "] exit left while loop");
            }
            System.out.println("-----------------");


            // Decrement right pointer until the right pointer value is greater than or equal to the pivot
            System.out.println("-----------------");
            System.out.println("Enter right loop - Array " + Arrays.toString(array) + ", origArray " + Arrays.toString(origArray));
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                System.out.println("rightPointer array[" + rightPointer + "] value [" +
                        array[rightPointer] + "] >= pivot value [" + pivot + "] decrement rightPointer to index[" + (rightPointer-1) + "]");
                rightPointer--;
            }
            if (leftPointer >= rightPointer) {
                System.out.println("leftPointer [" + leftPointer + "] >= rightPointer [" + rightPointer + "] exit right while loop");
            } else {
                System.out.println("rightPointer array[" + rightPointer + "] value [" +
                        array[rightPointer] + "] <= pivot value [" + pivot + "] exit right while loop");
            }
            System.out.println("-----------------");

            System.out.println("Exit left and right loops - Array " + Arrays.toString(array) + ", origArray " + Arrays.toString(origArray));
            System.out.println("quickSort: swap leftPointer array[" + leftPointer + "] value [" +
                    array[leftPointer] + "] with rightPointer array[" + rightPointer + "] value [" + array[rightPointer] + "]");

            swap(array, leftPointer, rightPointer);
        }

        System.out.println("quickSort: swap leftPointer array[" + leftPointer + "] value [" +
                array[leftPointer] + "] with highIndex(pivot) array[" + highIndex + "] value [" + array[highIndex] + "]");
        swap(array, leftPointer, highIndex);

        // Sort numbers less than the pivot
        quickSort(array, lowIndex, leftPointer - 1);
        // Sort numbers greater than the pivot
        quickSort(array, leftPointer + 1, highIndex);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int leftPointer, int rightPointer)
    {
        System.out.println("-------------------");
        System.out.println("swap: leftPointer[" + leftPointer + "] value [" + arr[leftPointer] +
                "] with rightPointer[" + rightPointer + "] value [" + arr[rightPointer] + "]");

        System.out.println("Before swap: " + Arrays.toString(arr));
//        System.out.println("swap leftPointer [" + leftPointer + "] rightPointer [" + rightPointer + "]");
//        System.out.println("swap values [" + arr[leftPointer] + "] and [" + arr[rightPointer] + "]");

        int temp = arr[leftPointer];
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;

        System.out.println("After swap: " + Arrays.toString(arr));
        System.out.println("-------------------");
    }

    // To print sorted array
//    public static void printArr(int[] arr)
//    {
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }


}
