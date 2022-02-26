/**
  * 题目Id：179
  * 题目：Largest Number
  * 日期：2022-02-26 18:22:56
*/
//Given a list of non-negative integers nums, arrange them such that they form 
//the largest number and return it. 
//
// Since the result may be very large, so you need to return a string instead 
//of an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 877 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });

        StringBuffer ans = new StringBuffer();
        for (int num : n) {
            if (num == 0 && ans.length() == 0) {
                continue;
            }
            ans.append(num);
        }
        return ans.toString() == "" ? "0" :  ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
