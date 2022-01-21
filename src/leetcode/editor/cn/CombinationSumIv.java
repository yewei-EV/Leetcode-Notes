/**
  * 题目Id：377
  * 题目：Combination Sum IV
  * 日期：2021-12-23 21:25:33
*/
//Given an array of distinct integers nums and a target integer target, return 
//the number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow 
//negative numbers? 
// Related Topics 数组 动态规划 👍 540 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        if (target < 0) return 0;
//        int n = nums.length;
//        int[][] dp = new int[target + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i <= target; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (nums[j - 1] <= i) {
//                    for (int k = 1; k <= j; k++) {
//                        dp[i][j] += dp[i - nums[k-1]][j];
//                    }
//                } else {
//                    dp[i][j] = dp[i][j-1];
//                }
//            }
//        }
//        return dp[target][n];

//        //定义f[i][j]为组合长度为i，凑成总和为j 的方案数是多少
//        if (target < 0) return 0;
//        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
//        int len = target;
//        int[][] dp = new int[len + 1][target + 1];
//        dp[0][0] = 1;
//        int ans = 0;
//        for (int i = 1; i <= len; i++) {
//            for (int j = 0; j <= target; j++) {
//                for (int num : nums) {
//                    if (j >= num) dp[i][j] += dp[i - 1][j - num];
//                }
//            }
//            ans += dp[i][target];
//        }
//        return ans;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
