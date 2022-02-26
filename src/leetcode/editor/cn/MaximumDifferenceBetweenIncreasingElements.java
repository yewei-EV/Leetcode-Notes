/**
  * 题目Id：2016
  * 题目：Maximum Difference Between Increasing Elements
  * 日期：2022-02-26 01:14:07
*/
//Given a 0-indexed integer array nums of size n, find the maximum difference 
//between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n 
//and nums[i] < nums[j]. 
//
// Return the maximum difference. If no such i and j exists, return -1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,1,5,4]
//Output: 4
//Explanation:
//The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 
//= 4.
//Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, 
//but i > j, so it is not valid.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,4,3,2]
//Output: -1
//Explanation:
//There is no i and j such that i < j and nums[i] < nums[j].
// 
//
// Example 3: 
//
// 
//Input: nums = [1,5,2,10]
//Output: 9
//Explanation:
//The maximum difference occurs with i = 0 and j = 3, nums[j] - nums[i] = 10 - 1
// = 9.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 👍 18 👎 0

package leetcode.editor.cn;
public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenIncreasingElements().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDifference(int[] nums) {
        if (nums.length == 0) return -1;
        int min = nums[0];
        int ans = -1;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                ans = Math.max(ans, num - min);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
