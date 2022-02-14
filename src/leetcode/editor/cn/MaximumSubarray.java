/**
  * 题目Id：53
  * 题目：Maximum Subarray
  * 日期：2021-12-07 01:16:58
*/
//Given an integer array nums, find the contiguous subarray (containing at 
//least one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
// Related Topics 数组 分治 动态规划 👍 4065 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
//        int temp = nums[0];
//        int max = temp;
//        for (int i = 1; i < nums.length; i++) {
//            if (temp <= 0) {
//                temp = nums[i];
//            } else {
//                temp = temp + nums[i];
//            }
//            max = Math.max(max, temp);
//        }
//        return max;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i-1];
            } else {
                dp[i] = dp[i-1] + nums[i-1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
