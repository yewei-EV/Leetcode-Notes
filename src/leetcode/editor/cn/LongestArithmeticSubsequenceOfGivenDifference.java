/**
  * 题目Id：1218
  * 题目：Longest Arithmetic Subsequence of Given Difference
  * 日期：2022-02-16 16:03:01
*/
//Given an integer array arr and an integer difference, return the length of 
//the longest subsequence in arr which is an arithmetic sequence such that the 
//difference between adjacent elements in the subsequence equals difference. 
//
// A subsequence is a sequence that can be derived from arr by deleting some or 
//no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,4], difference = 1
//Output: 4
//Explanation: The longest arithmetic subsequence is [1,2,3,4]. 
//
// Example 2: 
//
// 
//Input: arr = [1,3,5,7], difference = 1
//Output: 1
//Explanation: The longest arithmetic subsequence is any single element.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
//Output: 4
//Explanation: The longest arithmetic subsequence is [7,5,3,1].
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 205 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int temp;
            if (map.containsKey(arr[i] - difference)) {
                temp = map.get(arr[i] - difference) + 1;
            } else {
                temp = 1;
            }
            map.put(arr[i], temp);
            max = Math.max(max, temp);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
