/**
  * 题目Id：1249
  * 题目：Minimum Remove to Make Valid Parentheses
  * 日期：2022-01-10 14:54:32
*/
//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics 栈 字符串 👍 157 👎 0

package leetcode.editor.cn;
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Solution solution = new MinimumRemoveToMakeValidParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    continue;
                }
                count--;
            }
            ans.append(c);
        }
        if (count != 0) {
            StringBuilder newAns = new StringBuilder();
            for (int i = ans.length()-1; i >= 0; i--) {
                if (ans.charAt(i) == '(' && count-- > 0) continue;
                newAns.append(ans.charAt(i));
            }
            return newAns.reverse().toString();
        } else {
            return ans.toString();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
