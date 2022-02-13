/**
  * 题目Id：856
  * 题目：Score of Parentheses
  * 日期：2022-02-13 01:07:01
*/
//Given a balanced parentheses string s, return the score of the string. 
//
// The score of a balanced parentheses string is based on the following rule: 
//
// 
// "()" has score 1. 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "(())"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: s = "()()"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 50 
// s consists of only '(' and ')'. 
// s is a balanced parentheses string. 
// 
// Related Topics 栈 字符串 👍 265 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                if (stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int temp = 0;
                    while (stack.peek() != -1) {
                        temp += stack.pop();
                    }
                    stack.pop();
                    stack.push(2 * temp);
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
