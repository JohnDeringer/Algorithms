package johnderinger.leetcode;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public static void main (String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();

        int[] nums = new int[] {1,2,3,1};
//        int[] nums = new int[] {1,2,3,4};
//        int[] nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(c.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length, 100);
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
