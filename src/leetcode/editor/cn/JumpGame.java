/**
  * 题目Id：55
  * 题目：Jump Game
  * 日期：2022-03-01 19:30:39
*/
//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1673 👎 0

package leetcode.editor.cn;
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
//        int end = nums.length - 1;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] >= end - i) {
//                end = i;
//            }
//        }
//        return end == 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // cannot reach i
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
