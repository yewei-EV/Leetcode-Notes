/**
  * 题目Id：1140
  * 题目：Stone Game II
  * 日期：2021-12-26 17:32:43
*/
//Alice and Bob continue their games with piles of stones. There are a number 
//of piles arranged in a row, and each pile has a positive integer number of stones 
//piles[i]. The objective of the game is to end with the most stones. 
//
// Alice and Bob take turns, with Alice starting first. Initially, M = 1. 
//
// On each player's turn, that player can take all the stones in the first X 
//remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). 
//
// The game continues until all the stones have been taken. 
//
// Assuming Alice and Bob play optimally, return the maximum number of stones 
//Alice can get. 
//
// 
// Example 1: 
//
// 
//Input: piles = [2,7,9,4,4]
//Output: 10
//Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, 
//then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If 
//Alice takes two piles at the beginning, then Bob can take all three piles left. 
//In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's 
//larger. 
// 
//
// Example 2: 
//
// 
//Input: piles = [1,2,3,4,5,100]
//Output: 104
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 100 
// 1 <= piles[i] <= 10⁴ 
// 
// Related Topics 数组 数学 动态规划 博弈 👍 115 👎 0

package leetcode.editor.cn;
public class StoneGameIi {
    public static void main(String[] args) {
        Solution solution = new StoneGameIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        //int[i][M] is the max number you could got for [i, len - 1] with M
        int[][] dp = new int[len][len + 1];
        // 1. i + 2M >= len，you can take them all
        // 2. i + 2M < len, dp[i][M] = max(dp[i][M], sum[i : len - 1] - dp[i + x][max(M, x)])
        // 1 <= x <= 2M
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
