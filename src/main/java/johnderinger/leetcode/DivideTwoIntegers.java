package johnderinger.leetcode;

/**
 * Given two integers dividend and divisor, divide the two integers without using multiplication, division, or mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit
 * signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1,
 * then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 *
 * Constraints:
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class DivideTwoIntegers {

    public static void main (String[] args) {

        System.out.println("divide [" + divide(101, 5) + "]");
    }

    public static int divide(int dividend, int divisor) {
        // If the dividend is Integer.MIN_VALUE and the divisor is -1, the result would be Integer.MAX_VALUE + 1,
        //   which is out of the 32-bit signed integer range. Therefore, return Integer.MAX_VALUE in this case.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert both dividend and divisor to their absolute long values to prevent overflow issues.
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        System.out.println("longDividend(0) [" + longDividend + "]");
        System.out.println("longDivisor(0) [" + longDivisor + "]");
        System.out.println("=====================");

        //  Use the XOR operator to determine the sign of the quotient.
        //    If either dividend or divisor is negative, but not both, the result is negative.
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Result obtained by dividing one quantity by another
        int quotient = 0;
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor;
            long multiple = 1;
            int shiftCount = 0;
            // The core idea is to use bit manipulation to efficiently find the largest
            //   multiple of the divisor that is still less than or equal to the dividend.
            // In each iteration, we shift the divisor left (multiply by 2) until it becomes greater than the dividend.
            //  Then, we subtract the last valid multiple from the dividend and add the corresponding multiple to the quotient.

            // (temp << 1) : double temp (5 << 1) = 10
            // 5 << 1): 5 + 5 = 10
            // 5 << 2): 10 + 10 = 20
            // 5 << 3): 20 + 20 = 40
            // 5 << 4): 40 + 40 = 80
            // 5 << 5): 80 + 80 = 160
            while (longDividend >= (tempDivisor << 1)) {
                System.out.println("longDividend(0.1) [" + longDividend + "]");
                System.out.println("tempDivisor(0.1) [" + tempDivisor + "]");
                System.out.println("multiple(0.1) [" + multiple + "]");
                System.out.println("=====================");

                // In each iteration, we shift the divisor left (multiply by 2) until it becomes greater than the dividend.
                tempDivisor <<= 1;
                // Find the largest multiple of the divisor that is still less than or equal to the dividend.
                multiple <<= 1;

                shiftCount++;
                System.out.println("longDividend(0.2) [" + longDividend + "]");
                System.out.println("tempDivisor(0.2) [" + tempDivisor + "]");
                System.out.println("multiple(0.2) [" + multiple + "]");
                System.out.println("shiftCount(0.2) [" + shiftCount + "]");
                System.out.println("=====================");
            }

            System.out.println("(longDividend >= (tempDivisor << 1)) [" + (longDividend >= (tempDivisor << 1)) + "]");
            System.out.println("longDividend [" + longDividend + "]");
            System.out.println("(tempDivisor << 1) [" + (tempDivisor << 1) + "]");
            System.out.println("multiple(1) [" + multiple + "]");
            System.out.println("shiftCount(1) [" + shiftCount + "]");
            System.out.println("=====================");

            System.out.println("longDividend(1) [" + longDividend + "]");
            System.out.println("tempDivisor(1) [" + tempDivisor + "]");
            System.out.println("multiple(1) [" + multiple + "]");
            System.out.println("quotient(1) [" + quotient + "]");
            System.out.println("=====================");

            // We subtract the last valid temp divisor from the dividend
            longDividend -= tempDivisor;
            // Add the corresponding multiple to the quotient.
            System.out.println("quotient += multiple [" + (quotient += multiple) + "]");

            System.out.println("longDividend(2) [" + longDividend + "]");
            System.out.println("tempDivisor(2) [" + tempDivisor + "]");
            System.out.println("multiple(2) [" + multiple + "]");
            System.out.println("quotient(2) [" + quotient + "]");
//            System.out.println("quotient += multiple [" + (quotient + multiple) + "]");
            System.out.println("=====================");
        }


        // Return the calculated quotient with the appropriate sign.
        return sign * quotient;
    }

//    private static int divide (int dividend, int divisor, boolean x) {
//        int count = 0;
//        boolean isNeg = dividend != divisor;
//        while (dividend >= divisor) {
//            int temp = divisor;
//            int multiple = 1;
//            while (temp + temp <= dividend) {
//                temp = temp + temp;
//                multiple = multiple + multiple;
//            }
//            dividend = dividend - temp;
//            count = count + multiple;
//        }
//        return count;
//
//    }

    public String toString() {
        return null;
    }


}
