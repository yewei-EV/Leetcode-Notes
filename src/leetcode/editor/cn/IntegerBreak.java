/**
  * 题目Id：343
  * 题目：Integer Break
  * 日期：2021-12-23 14:05:56
*/
//Given an integer n, break it into the sum of k positive integers, where k >= 2
//, and maximize the product of those integers. 
//
// Return the maximum product you can get. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 654 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-j] * j, (i-j)*j));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
