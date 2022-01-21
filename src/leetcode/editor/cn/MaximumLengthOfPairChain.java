/**
  * 题目Id：646
  * 题目：Maximum Length of Pair Chain
  * 日期：2021-12-23 15:54:42
*/
//You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and 
//lefti < righti. 
//
// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can 
//be formed in this fashion. 
//
// Return the length longest chain which can be formed. 
//
// You do not need to use up all the given intervals. You can select pairs in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: pairs = [[1,2],[2,3],[3,4]]
//Output: 2
//Explanation: The longest chain is [1,2] -> [3,4].
// 
//
// Example 2: 
//
// 
//Input: pairs = [[1,2],[7,8],[4,5]]
//Output: 3
//Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
// 
//
// 
// Constraints: 
//
// 
// n == pairs.length 
// 1 <= n <= 1000 
// -1000 <= lefti < righti <= 1000 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 201 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
               if (pairs[j][1] < pairs[i][0]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                   max = Math.max(dp[i], max);
               }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
