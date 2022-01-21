/**
  * 题目Id：665
  * 题目：Non-decreasing Array
  * 日期：2021-12-07 01:16:47
*/
//Given an array nums with n integers, your task is to check if it could become 
//non-decreasing by modifying at most one element. 
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for 
//every i (0-based) such that (0 <= i <= n - 2). 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,1]
//Output: false
//Explanation: You can't get a non-decreasing array by modify at most one 
//element.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 👍 634 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
                if (i >= 2 && nums[i-2] > nums[i]) {
                    nums[i] = nums[i-1];
                } else {
                    nums[i-1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
