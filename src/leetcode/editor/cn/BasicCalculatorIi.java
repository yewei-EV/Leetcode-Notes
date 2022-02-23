/**
  * 题目Id：227
  * 题目：Basic Calculator II
  * 日期：2022-02-23 18:12:55
*/
//Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// You may assume that the given expression is always valid. All intermediate 
//results will be in the range of [-2³¹, 2³¹ - 1]. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of integers and operators ('+', '-', '*', '/') separated by some 
//number of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 2³¹ - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics 栈 数学 字符串 👍 531 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        char preSign = '+';
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                preSign = s.charAt(i);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
