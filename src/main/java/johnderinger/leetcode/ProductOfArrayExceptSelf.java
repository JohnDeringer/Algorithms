package johnderinger.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that
 *   answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 *  (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4}; // Output: [24,12,8,6]
//        int[] nums = new int[]{-1,1,0,-3,3}; // Output: [0,0,9,0,0]

        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        System.out.println("Output: " + Arrays.toString(p.productExceptSelf(nums)));

    }

    /**
     * A Prefix Product Array is an array where each element at index i
     *    contains the product of all elements to the left of i.
     * A Suffix Product Array is an array where each element at index i
     *    contains the product of all elements to the right of i (including the element at index i)
     *
     * Intuition here is to create a prefix product array where ith element will store product till
     *  nums[i] and iterate from right to left.
     *  While iterating maintain the suffix product curr which will store product from i+1 to last element.
     * Now for each element the answer product will be suffix product* prefix[i-1].
     *
     * @param nums The test input array
     * @return The output array containing multiplication results
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        System.out.println("");

        // {1,2,3,4} Output: [24,12,8,6]

        /*
           Prefix Array: The prefix array stores the product of all elements from the beginning of the array up to the current index.
         */
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("prefix START Iteration [" + (i + 1) + "] prefix [" + prefix + "] nums [" + Arrays.toString(nums) + "] result [" + Arrays.toString(result) + "]");

            result[i] = prefix;
            System.out.println("After: Setting result[" + i + "] with prior iteration prefix value [" + prefix + "] result [" + Arrays.toString(result) + "]");

            System.out.println("Update prefix value by multiplying prefix value [" + prefix + "] and [nums[" + i + "]: value [" + nums[i] + "]]");
            prefix *= nums[i];
            System.out.println("Update prefix value to [" + prefix + "]");

            System.out.println("prefix AFTER: nums [" + Arrays.toString(nums) + "] result [" + Arrays.toString(result) + "]");

            System.out.println("===============");
        }

        System.out.println("======================="); // nums [1, 2, 3, 4], result [1, 1, 2, 6]

        /*
         Suffix Array: The suffix array stores the product of all elements from the end of the array up to the current index.
         Suffix Products: Iterate through the array from right to left, calculating the product of all elements to the
           right of the current element, and multiplying it with the corresponding prefix product in the result array.
         */
        int suffix = 1;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            System.out.println("suffix START Iteration [" + ++count + "] suffix [" + suffix + "] nums [" + Arrays.toString(nums) + "] result [" + Arrays.toString(result) + "]");

            int priorValue = result[i];
            result[i] *= suffix;
            System.out.println("After: Setting result[" + i + "] with the product of the prior iteration suffix value [" + suffix +
                    "] and [result [" + i + "]: value [" + priorValue + "]] result [" + Arrays.toString(result) + "]");

            System.out.println("Update suffix value by multiplying suffix value [" + suffix + "] and [nums[" + i + "]: value [" + nums[i] + "]]");
            suffix *= nums[i];
            System.out.println("Update suffix value to [" + suffix + "]");

            System.out.println("suffix AFTER: nums [" + Arrays.toString(nums) + "] result [" + Arrays.toString(result) + "]");

            System.out.println("===============");
            // nums [1, 2, 3, 4], result [24, 12, 8, 6]
        }

        return result;

    }

}
