package johnderinger.leetcode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

    public static void main (String[] args) {
        int[] prices = new int[]{7,6,4,1,3}; // Output: 2
//        int[] prices = new int[]{7,6,4,3,1}; // Output: 0
//        int[] prices = new int[]{7,1,5,3,6,4}; // Output: 5
        BestTimeToBuyAndSellStock r = new BestTimeToBuyAndSellStock();
        System.out.println("Output: " + r.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int lowestIndex = -1;
        // Pick a random value for lowest
        int lowestPrice = prices[prices.length / 2];
        int highestIndex;
        int highestPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestIndex = i;
                lowestPrice = prices[lowestIndex];
            } else if ((prices[i] > highestPrice) && (i > lowestIndex && lowestIndex >= 0)) {
                highestIndex = i;
                highestPrice = prices[highestIndex];
            }
        }
//        System.out.println("lowestPrice [" + lowestPrice + "] highestPrice [" + highestPrice + "]");
        return highestPrice - lowestPrice > -1 ? highestPrice - lowestPrice : 0;
    }

}
