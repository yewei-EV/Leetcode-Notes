/**
  * 题目Id：16
  * 题目：3Sum Closest
  * 日期：2022-02-12 12:28:37
*/
//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1039 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; ++i) {
            int first = nums[i];
            int l = i + 1 , r = len - 1;
            while (l < r) {
                int sum = first + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
