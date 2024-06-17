/**
 * A binary search or half-interval search algorithm finds the position of a specified
 * value (the input "key") within a sorted array. [1][2] In each step, the algorithm
 * compares the input key value with the key value of the middle element of the array.
 * If the keys match, then a matching element has been found so its index, or position,
 * is returned. Otherwise, if the sought key is less than the middle element's key,
 * then the algorithm repeats its action on the sub-array to the left of the middle
 * element or, if the input key is greater, on the sub-array to the right.
 * If the remaining array to be searched is reduced to zero, then the key cannot
 * be found in the array and a special "Not found" indication is returned.
 * <p>
 * A binary search halves the number of items to check with each iteration,
 * so locating an item (or determining its absence) takes logarithmic time.
 * A binary search is a dichotomic divide and conquer search algorithm.
 * <p>
 * Worst case: O(log n)
 * Avg case: O(log n)
 * Best case: O(1)
 */
public class BinarySearch {
  public static final int NOT_FOUND = -1;

  public static int search(int[] arr, int searchValue) {
    int left = 0;
    int right = arr.length - 1;
    return binarySearch(arr, searchValue, left, right);
  }

  private static int binarySearch(int[] arr, int searchValue, int left, int right) {
    if (right < left) {
      return NOT_FOUND;
    }
        /*
        int mid = mid = (left + right) / 2;
        There is a bug in the above line;
        Joshua Bloch suggests the following replacement:
        */
    System.out.println("left [" + Integer.toBinaryString(left) + "]");
    System.out.println("right [" + Integer.toBinaryString(right) + "]");

    int mid = (left + right) >>> 1;
    //int mid = (left + right) / 2;
    System.out.println("mid [" + Integer.toBinaryString(mid) + "]");
    if (searchValue > arr[mid]) {
      // right side of tree
      return binarySearch(arr, searchValue, mid + 1, right);
    } else if (searchValue < arr[mid]) {
      // left side of tree
      return binarySearch(arr, searchValue, left, mid - 1);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] values = {1, 3, 5, 6, 88, 89, 99, 106, 111, 123, 433, 455, 786, 899, 900, 903, 1001, 1200, 1323, 1344, 1478, 5690};
    int searchValue = 6;
    System.out.println("Searching for value [" + searchValue + "]");
    System.out.println("Found Index [" + search(values, searchValue) + "]");
  }
}
