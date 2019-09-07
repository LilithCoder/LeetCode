/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Medium
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

/**
 * [1]. definition of the status
 * hold[i]: the max profit earned when there is a stock hold at the end of this day
 * unhold[i]: the max profit earned when there is no stock hold at the end of this day
 *
 * [2]. Target: unhold[n - 1]
 *
 * [3]. Base Case
 *
 * [4]. Relationship between the current problem and neighbour sub-problems
 *
 */
public class sol_309_dp {
    public int maxProfit(int[] prices) {
        // including the circumstance where prices array has only one day
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // the value of ith element in the hold[]
        // indicates the max profit earned when there is a stock hold at the end of this day
        int[] hold = new int[prices.length];
        // the value of ith element in the unhold[]
        // indicates the max profit earned when there is no stock hold at the end of this day
        int[] unhold = new int[prices.length];
        // base case
        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[1], -prices[0]);
        unhold[0] = 0;
        unhold[1] = Math.max(unhold[0], -prices[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            unhold[i] = Math.max(hold[i - 1] + prices[i], unhold[i - 1]);
            hold[i] = Math.max(unhold[i - 2] - prices[i], hold[i - 1]);
        }
        return unhold[prices.length - 1];
    }
}
