/**
  * 题目Id：241
  * 题目：Different Ways to Add Parentheses
  * 日期：2021-12-08 13:32:50
*/
//Given a string expression of numbers and operators, return all possible 
//results from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// All the integer values in the input expression are in the range [0, 99]. 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 482 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r: right) {
                        if (c == '+') {
                            ways.add(l + r);
                        } else if (c == '-') {
                            ways.add(l - r);
                        } else if (c == '*') {
                            ways.add(l * r);
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(expression));
        }
        return ways;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
