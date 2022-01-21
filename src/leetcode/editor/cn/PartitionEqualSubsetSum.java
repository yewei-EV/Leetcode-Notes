/**
  * 题目Id：416
  * 题目：Partition Equal Subset Sum
  * 日期：2021-12-20 19:28:59
*/
//Given a non-empty array nums containing only positive integers, find if the 
//array can be partitioned into two subsets such that the sum of elements in both 
//subsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1051 👎 0

package leetcode.editor.cn;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[len + 1][sum + 1];

        dp[0][0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
