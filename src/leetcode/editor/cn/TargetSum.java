/**
  * 题目Id：494
  * 题目：Target Sum
  * 日期：2021-12-20 23:38:09
*/
//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which 
//evaluates to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be 
//target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 975 👎 0

package leetcode.editor.cn;
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int n : nums) {
                sum += n;
            }
            return sum < target || (target + sum) % 2 > 0 ? 0 : subsetSum(nums, (target + sum)/2);
        }

        public int subsetSum(int[] nums, int target) {
            if (target < 0) return 0;
            int n = nums.length;
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= target; j++) {
                    if (nums[i-1] <= j) {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][target];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
