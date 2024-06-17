/**
 * The Dutch national flag problem is a famous computer science related programming problem
 * proposed by Edsger Dijkstra.
 * The flag of the Netherlands consists of three colors : Red, White and Blue.
 * Given balls of these three colors arranged randomly in a line (the actual number of balls
 * does not matter), the task is to arrange them such that all balls of same color are together
 * and their collective color groups are in the correct order
 *
 * The Problem can be reconstructed for a given list consisting 0s, 1s and 2s write a
 * function that displays 0s first, then 1s and rest of the 2s in last.
 *
 * 0 – Red
 * 1 – White
 * 2 – Blue
 *
 * http://en.wikipedia.org/wiki/Dutch_national_flag_problem
 *
 * This problem can also be viewed in terms of rearranging elements of an array.
 * Suppose each of the possible elements could be classified into exactly one of three
 * categories (bottom, middle, and top). For example, if all elements are in 0 ... 1, the
 * bottom could be defined as elements in 0 ... 0.1 (not including 0.1), the middle as
 * 0.1 ... 0.3 (not including 0.3) and the top as 0.3 and greater. (The choice of these
 * values illustrates that the categories need not be equal ranges). The problem is then
 * to produce an array such that all "bottom" elements come before (have an index less than
 * the index of) all "middle" elements, which come before all "top" elements. And to do this
 * sorting without later moving any element after placing it in the array.
 *
 * One algorithm is to have the top group grow down from the top of the array,
 * the bottom group grow up from the bottom, and keep the middle group just above the bottom.
 * The algorithm stores the locations just below the top group, just above the bottom,
 * and just above the middle in three indexes.
 * At each step, examine the element just above the middle. If it belongs to the top group,
 * swap it with the element just below the top. If it belongs in the bottom,
 * swap it with the element just above the bottom. If it is in the middle, leave it.
 * Update the appropriate index. Complexity is Θ(n) moves and examinations.
 *
 * Using this algorithm in quicksort to partition elements, with the middle group being
 * elements equal to the pivot, lets quicksort avoid "resorting" elements that equal the pivot.
 *
 * Re-arrange an array containing only 0s, 1s and 2s,
 * so that all 1s follow all 0s and all 2s follow 1s. e.g. 00000011111111222222.
 * Linear time algorithm.
 *
 * Input: {0 0 1 1 2 2 0 0 2 0 1 1 1 0 1}
 * Output:{0 0 0 0 0 0 1 1 1 1 1 1 2 2 2}
 *
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int [] A = {0,0,1,1,2,2,0,0,2,0,1,1,1,0,1};
        //solveDutchFlag(A);
        dutchFlagSort(A, 1, 2);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println("");

        for (int i = 0; i < A.length; i++) {
            System.out.print("[" + i + "=" + A[i] + "]");
        }
    }

    public static void solveDutchFlag(int [] A) {
        if (null == A) {
            return ;
        }
        int len = A.length - 1;
        int low = 0;
        int mid = 0;
        int high = len;

        while (mid <= high) {
            if (A[mid] == 0) {
                int temp = A[low];
                A[low] = A[mid];
                A[mid] = temp;
                ++low;
                ++mid;
            } else if (A[mid] == 2) {
                int temp = A[high];
                A[high] = A[mid];
                A[mid] = temp;
                --high;
            } else {
                ++mid;
            }
        }
    }

    public static void dutchFlagSort(int[] arr, int p, int k) {
        int p_index = 0;
        int k_index = arr.length - 1;
        for(int i = 0; i <= k_index;){
            if(arr[i] < p){
                swap(arr, i, p_index);
                p_index++;
                i++;
            }
            else if(arr[i] >= k){
                swap(arr, i, k_index);
                k_index--;
            }
            else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
