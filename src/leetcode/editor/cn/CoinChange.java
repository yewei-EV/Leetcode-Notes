/**
  * 题目Id：322
  * 题目：Coin Change
  * 日期：2021-12-23 20:33:00
*/
//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If 
//that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1618 👎 0

package leetcode.editor.cn;
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] == amount + 1? -1 : dp[n][amount];

//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount ; j++) {
//                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
