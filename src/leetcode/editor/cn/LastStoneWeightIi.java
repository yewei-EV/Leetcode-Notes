/**
  * 题目Id：1049
  * 题目：Last Stone Weight II
  * 日期：2021-12-20 23:40:25
*/
//You are given an array of integers stones where stones[i] is the weight of 
//the iᵗʰ stone. 
//
// We are playing a game with the stones. On each turn, we choose any two 
//stones and smash them together. Suppose the stones have weights x and y with x <= y. 
//The result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the smallest possible weight of the left stone. If there are no 
//stones left, return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation:
//We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
//we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
//we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
//we can combine 1 and 1 to get 0, so the array converts to [1], then that's 
//the optimal value.
// 
//
// Example 2: 
//
// 
//Input: stones = [31,26,33,21,40]
//Output: 5
// 
//
// Example 3: 
//
// 
//Input: stones = [1,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 361 👎 0

package leetcode.editor.cn;
public class LastStoneWeightIi {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeightIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int stone: stones) {
                sum += stone;
            }
            int target = sum/2;
            int[] dp = new int[target+1];
            for (int i = 0; i < stones.length; i++) {
                for (int j = target; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
                }
            }
            return sum - 2*dp[target];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
