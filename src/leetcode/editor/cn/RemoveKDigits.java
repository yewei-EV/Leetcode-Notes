/**
  * 题目Id：402
  * 题目：Remove K Digits
  * 日期：2022-02-24 20:14:10
*/
//Given string num representing a non-negative integer num, and an integer k, 
//return the smallest possible integer after removing k digits from num. 
//
// 
// Example 1: 
//
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
//which is the smallest.
// 
//
// Example 2: 
//
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
//
// Example 3: 
//
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with 
//nothing which is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num consists of only digits. 
// num does not have any leading zeros except for the zero itself. 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 733 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < num.length(); ++i) {
            char cur = num.charAt(i);
            while (k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > cur) {
                // pop the previous element
                stack.setLength(stack.length() - 1);
                k--;
            }
            if (cur == '0' && stack.length() == 0) continue;
            stack.append(cur);
        }
        String result = stack.substring(0, stack.length() - k < 1 ? 0 : stack.length() - k);
        return result.length() == 0 ? "0" : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
