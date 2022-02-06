/**
  * 题目Id：1748
  * 题目：Sum of Unique Elements
  * 日期：2022-02-06 21:48:55
*/
//You are given an integer array nums. The unique elements of an array are the 
//elements that appear exactly once in the array. 
//
// Return the sum of all the unique elements of nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,2]
//Output: 4
//Explanation: The unique elements are [1,3], and the sum is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1,1,1]
//Output: 0
//Explanation: There are no unique elements, and the sum is 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,4,5]
//Output: 15
//Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 计数 👍 56 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        Solution solution = new SumOfUniqueElements().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: cnt.entrySet()) {
            int num = entry.getKey(), c = entry.getValue();
            if (c == 1) {
                sum += num;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
