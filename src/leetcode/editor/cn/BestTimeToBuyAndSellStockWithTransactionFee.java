/**
  * 题目Id：714
  * 题目：Best Time to Buy and Sell Stock with Transaction Fee
  * 日期：2021-12-24 20:58:07
*/
//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day, and an integer fee representing a transaction fee. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like, but you need to pay the transaction fee for each transaction. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
// Related Topics 贪心 数组 动态规划 👍 598 👎 0

package leetcode.editor.cn;
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
//        dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
//        dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i] - fee)
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[len - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
