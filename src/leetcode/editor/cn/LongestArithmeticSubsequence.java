/**
  * 题目Id：1027
  * 题目：Longest Arithmetic Subsequence
  * 日期：2022-02-15 23:56:14
*/
//Given an array nums of integers, return the length of the longest arithmetic 
//subsequence in nums. 
//
// Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ...,
// nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence 
//seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.
//length - 1). 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,6,9,12]
//Output: 4
//Explanation: 
//The whole array is an arithmetic sequence with steps of length = 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,4,7,2,10]
//Output: 3
//Explanation: 
//The longest arithmetic subsequence is [4,7,10].
// 
//
// Example 3: 
//
// 
//Input: nums = [20,1,15,3,10,5,8]
//Output: 4
//Explanation: 
//The longest arithmetic subsequence is [20,15,10,5].
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 👍 171 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequence().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Set<Integer> diffs = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                diffs.add(nums[j] - nums[i]);
            }
        }
        int max = 2;
        for (int diff :  diffs) {
            max = Math.max(max, leetcode1218(nums, diff));
        }
        return max;
    }

    public int leetcode1218(int [] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < arr.length; ++i) {
            int temp;
            if (map.containsKey(arr[i] - diff)) {
                temp = 1 + map.get(arr[i] - diff);
            } else {
                temp = 1;
            }
            map.put(arr[i], temp);
            count = Math.max(count, temp);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
