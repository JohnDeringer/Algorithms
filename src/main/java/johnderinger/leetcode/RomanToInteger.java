package johnderinger.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 *   I            1
 *   V            5
 *   X            10
 *   L            50
 *   C            100
 *   D            500
 *   M            1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 *   12 is written as XII, which is simply X + II.
 *   The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 *   Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 *   The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();

        System.out.println(romanToInteger.romanToInt("III")); // Output: 3
        System.out.println(romanToInteger.romanToInt("LVIII")); // Output: 58
        System.out.println(romanToInteger.romanToInt("MCMXCIV")); // Output: 1994
    }

    /**
     * Iterate through roman numeral, right to left
     * Store the previousValue with the currentValue, to be used in the next iteration
     * If currentValue is less than previousValue, subtract from result
     * If currentValue is greater than previousValue, add to result
     * @param s Roman numeral to be converted to integer
     * @return integer value of roman numeral
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(s.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
                System.out.println("Roman [" + s.charAt(i) + "] currentValue [" + currentValue + "] < prevValue [" + prevValue + "] result [" + result + "]");
            } else {
                result += currentValue;
                System.out.println("Roman [" + s.charAt(i) + "] currentValue [" + currentValue + "] > prevValue [" + prevValue + "] result [" + result + "]");
            }

            prevValue = currentValue;
        }

        return result;
    }

}
