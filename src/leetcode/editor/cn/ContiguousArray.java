/**
  * 题目Id：525
  * 题目：Contiguous Array
  * 日期：2022-03-20 09:58:43
*/
//Given a binary array nums, return the maximum length of a contiguous subarray 
//with an equal number of 0 and 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number 
//of 0 and 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal 
//number of 0 and 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
// Related Topics 数组 哈希表 前缀和 👍 537 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // build the map <prefixSum, first index>
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }
        }
        // iterate prefixSum and find the largest distance
        for (int j = 2; j <= n; j++) {
            ans = Math.max(ans, j - map.get(prefixSum[j]));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
