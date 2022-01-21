/**
  * 题目Id：594
  * 题目：Longest Harmonious Subsequence
  * 日期：2022-01-14 18:54:31
*/
//We define a harmonious array as an array where the difference between its 
//maximum value and its minimum value is exactly 1. 
//
// Given an integer array nums, return the length of its longest harmonious 
//subsequence among all its possible subsequences. 
//
// A subsequence of array is a sequence that can be derived from the array by 
//deleting some or no elements without changing the order of the remaining elements.
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,2,2,5,2,3,7]
//Output: 5
//Explanation: The longest harmonious subsequence is [3,2,2,2,3].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// Related Topics 数组 哈希表 排序 👍 304 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num + 1) + map.get(num));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
