/**
  * 题目Id：415
  * 题目：Add Strings
  * 日期：2022-02-15 23:59:04
*/
//Given two non-negative integers, num1 and num2 represented as string, return 
//the sum of num1 and num2 as a string. 
//
// You must solve the problem without using any built-in library for handling 
//large integers (such as BigInteger). You must also not convert the inputs to 
//integers directly. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "11", num2 = "123"
//Output: "134"
// 
//
// Example 2: 
//
// 
//Input: num1 = "456", num2 = "77"
//Output: "533"
// 
//
// Example 3: 
//
// 
//Input: num1 = "0", num2 = "0"
//Output: "0"
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 and num2 consist of only digits. 
// num1 and num2 don't have any leading zeros except for the zero itself. 
// 
// Related Topics 数学 字符串 模拟 👍 505 👎 0

package leetcode.editor.cn;
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int sum = (m >= 0 ? (num1.charAt(m--) - '0') : 0)
                    + (n >= 0 ? (num2.charAt(n--) - '0') : 0)
                    + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
