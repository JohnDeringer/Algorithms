package johnderinger;

public class MyBinarySearch {

    public static void main (String[] args) {
        // Begin with a sorted array
        // -1, 0, 1, 2, 3, 4, 7, 9, 10, 20
        int[] arr = new int[10];
        arr[0] = -1;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 3;
        arr[5] = 4;
        arr[6] = 7;
        arr[7] = 9;
        arr[8] = 10; // Number to search for
        arr[9] = 20;

        int searchValue = 10;

        // Search for the number 10
        System.out.println("binarySearch index [" + binarySearch(arr, 0, arr.length - 1, searchValue) + "]");
    }

    public static int binarySearch(int[] arr, int leftIndex, int rightIndex, int searchValue) {
        // Number not found
        if (leftIndex > rightIndex) {
            return -1;
        }

        // Recompute the mid / pivot
        int mid = leftIndex + (rightIndex - leftIndex) / 2;
//        int mid = (left + right) / 2;

        // Success
        if (searchValue == arr[mid]) {
            return mid;
        }

        // Search the left half of the array
        if (searchValue < arr[mid]) {
            return binarySearch(arr, leftIndex, mid - 1, searchValue);
        }

        // Search the right half of the array
        return binarySearch(arr, mid + 1, rightIndex, searchValue);
    }


}
