import java.util.Arrays;

/**
 * Bubble sort
 * <p/>
 * The bubble sort is generally considered to be the simplest sorting algorithm.
 * Because of its simplicity and ease of visualization, it is often taught in
 * introductory computer science courses.
 * Because of its O(n2) performance, it is not used often for large
 * (or even medium-sized) datasets.
 * The bubble sort works by passing sequentially over a list,
 * comparing each value to the one immediately after it.
 * If the first value is greater than the second, their positions are switched.
 * Over a number of passes, at most equal to the number of elements in the list,
 * all of the values drift into their correct positions
 * (large values "bubble" rapidly toward the end, pushing others down around them).
 * Because each pass finds the maximum item and puts it at the end, the portion of
 * the list to be sorted can be reduced at each pass. A boolean variable is used
 * to track whether any changes have been made in the current pass; when a pass
 * completes without changing anything, the algorithm exits.
 * <p/>
 * http://rosettacode.org/wiki/Bubble_Sort
 */
public class BubbleSort {
  static int count = 0;

  public static void bubbleSort(int[] data) {
    //int i;
    boolean swapped = true; // init flag to begin first pass
    int temp; // temp data

    while (swapped) {
      // initialize to false for each iteration
      swapped = false;
      for (int i = 0; i < data.length - 1; i++) {
        // If left is greater than right sibling -> swap
        if (data[i] > data[i + 1]) {
          comparisonCount++;
          // swap elements
          temp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = temp;

          writeCount++;
          count++;
          System.out.println("swap:" + data[i + 1] + "|" + data[i]);
          printOrder("swap:" + count++, data);
          
          // flags the outer loop that we need to continue
          swapped = true;
        } else {
          System.out.println("noswap:" + data[i] + "|" + data[i + 1]);
          printOrder("noswap", data);
          //System.out.println("swapped :" + swapped);
        }
      }
    }
  }

//  public static void bubbleSort(int[] data, int compIndex) {
//    if (compIndex < (data.length - 1)) {
//      for (int i = compIndex; i < data.length - 1; i++) {
//        if (data[i] > data[i + 1]) {
//          int temp = data[i];
//          data[i] = data[i + 1];
//          data[i + 1] = temp;
//
//          System.out.println("swap:" + data[i + 1] + "|" + data[i]);
//          printOrder("swap:" + count++, data);
//
//          bubbleSort(data, (i + 1));
//        } else {
//          System.out.println("noswap:" + data[i] + "|" + data[i + 1]);
//          printOrder("noswap", data);
//        }
//      }
//    }
//  }

  public static void main(String[] args) {

    // int[] data = {32, 67, 76, 23, 41, 58, 85, 14, 1};
    int[] data = {41, 67, 6, 3, 23};
    printOrder("loop", data);
    bubbleSort(data);

    System.out.println("Comparison Count: " + comparisonCount);
    System.out.println("Write Count: " + writeCount);
    printOrder("recurse", data);
    System.out.println("=================");

//    int[] data2 = {41, 67, 6, 3, 23};
//
//    bubbleSort(data2, 0);
//
//    System.out.println("Comparison Count: " + comparisonCount);
//    System.out.println("Write Count: " + writeCount);
  }

  private static void printOrder(String label, int[] A) {
    System.out.println(label + ":" + Arrays.toString(A));

  }

  public static int comparisonCount = 0;
  public static int writeCount = 0;

}
