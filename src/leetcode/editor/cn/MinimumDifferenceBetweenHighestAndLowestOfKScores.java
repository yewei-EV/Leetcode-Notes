/**
  * 题目Id：1984
  * 题目：Minimum Difference Between Highest and Lowest of K Scores
  * 日期：2022-02-11 23:48:32
*/
//You are given a 0-indexed integer array nums, where nums[i] represents the 
//score of the iᵗʰ student. You are also given an integer k. 
//
// Pick the scores of any k students from the array so that the difference 
//between the highest and the lowest of the k scores is minimized. 
//
// Return the minimum possible difference. 
//
// 
// Example 1: 
//
// 
//Input: nums = [90], k = 1
//Output: 0
//Explanation: There is one way to pick score(s) of one student:
//- [90]. The difference between the highest and lowest score is 90 - 90 = 0.
//The minimum possible difference is 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,4,1,7], k = 2
//Output: 2
//Explanation: There are six ways to pick score(s) of two students:
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
//
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
//
//- [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
//
//- [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
//
//- [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
//
//- [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
//
//The minimum possible difference is 2. 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 排序 滑动窗口 👍 75 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {
        Solution solution = new MinimumDifferenceBetweenHighestAndLowestOfKScores().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k -1] - nums[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
