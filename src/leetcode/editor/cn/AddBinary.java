/**
  * 题目Id：67
  * 题目：Add Binary
  * 日期：2022-03-11 01:57:40
*/
//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 761 👎 0

package leetcode.editor.cn;
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sum += carry;
            System.out.println(sum);
            res.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
