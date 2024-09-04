package johnderinger.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Follow up: If you have figured out the O(n) solution,
 *   try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {

    public static void main (String[] args) {
        MaxSubArray m  = new MaxSubArray();
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4}; // [4,-1,2,1] has the largest sum 6.
//        int[] nums = new int[]{1}; // The subarray [1] has the largest sum 1.
//        int[] nums = new int[]{5,4,-1,7,8}; // The subarray [5,4,-1,7,8] has the largest sum 23.
//        int[] nums = new int[]{-1};
        int[] nums = new int[]{-2, -1};
//        int[] nums = new int[]{5,-4,-1,-7,8};

//        System.out.println("output [" + m.maxSubArray(nums) + "]");
        System.out.println("output [" + m.maxSubArray(nums) + "]");
    }

   public int maxSubArray(int[] arr) {
        int size = arr.length;
        int max_sum = Integer.MIN_VALUE,
                running_total = 0, start = 0, end = 0, s = 0;

       System.out.println("===================");

        for (int i = 0; i < size; i++) {
            running_total += arr[i];

            // Update max sum, if running total is greater.
            // Update start index if running total is below zero, on the prior iteration
            // Update end index, if max_sum has increased
            if (max_sum < running_total) {
                max_sum = running_total;
                start = s;
                end = i;
            }

            // If running total is less than zero, increment start index
            if (running_total < 0) {
                running_total = 0;
                s = i + 1;
            }

            System.out.println("Running_total value: " + running_total);
            System.out.println("Maximum Sum: " + max_sum);
            System.out.println("Starting index: " + start);
            System.out.println("Ending index: " + end);
            System.out.println("===================");
        }
        System.out.println("Maximum sum: " + max_sum);
        System.out.println("Starting index: " + start);
        System.out.println("Ending index: " + end);

        return max_sum;
   }


}
