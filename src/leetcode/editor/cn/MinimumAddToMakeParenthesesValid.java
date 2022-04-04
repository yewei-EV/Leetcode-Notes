/**
  * 题目Id：921
  * 题目：Minimum Add to Make Parentheses Valid
  * 日期：2022-04-03 23:51:46
*/
//A parentheses string is valid if and only if: 
//
// 
// It is the empty string, 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// You are given a parentheses string s. In one move, you can insert a 
//parenthesis at any position of the string. 
//
// 
// For example, if s = "()))", you can insert an opening parenthesis to be "(())
//)" or a closing parenthesis to be "())))". 
// 
//
// Return the minimum number of moves required to make s valid. 
//
// 
// Example 1: 
//
// 
//Input: s = "())"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "((("
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] is either '(' or ')'. 
// 
// Related Topics 栈 贪心 字符串 👍 128 👎 0

package leetcode.editor.cn;
public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Solution solution = new MinimumAddToMakeParenthesesValid().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (bal == -1) {
               ans++;
               bal = 0;
            }
        }
        return bal + ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
