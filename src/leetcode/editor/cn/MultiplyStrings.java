/**
  * 题目Id：43
  * 题目：Multiply Strings
  * 日期：2022-02-26 01:18:54
*/
//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
// Related Topics 数学 字符串 模拟 👍 840 👎 0

package leetcode.editor.cn;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        String res = "0";
        for (int j = n - 1; j >= 0; j--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < n - 1 - j; k++) {
                temp.append(0);
            }
            int n2 = num2.charAt(j) - '0';
            if (n2 == 0) continue;
            for (int i = m - 1; i >= 0 || carry > 0; i--) {
                int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int product = n1 * n2 + carry;
                temp.append(product % 10);
                carry = product / 10;
            }
            res = add(res, temp.reverse().toString());
        }
        return res;
    }

    public String add(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
