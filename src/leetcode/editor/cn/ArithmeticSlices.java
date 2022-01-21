/**
  * 题目Id：413
  * 题目：Arithmetic Slices
  * 日期：2021-12-23 00:51:26
*/
//An integer array is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic 
//sequences. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of 
//nums. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 392 👎 0

package leetcode.editor.cn;
public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int sum = 0;
        for (int i = 2; i < n; i++) {
           sum += dp[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
