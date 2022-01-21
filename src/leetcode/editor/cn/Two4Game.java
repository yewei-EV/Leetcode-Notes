/**
  * 题目Id：679
  * 题目：24 Game
  * 日期：2021-12-09 16:28:56
*/
//You are given an integer array cards of length 4. You have four cards, each 
//containing a number in the range [1, 9]. You should arrange the numbers on these 
//cards in a mathematical expression using the operators ['+', '-', '*', '/'] and 
//the parentheses '(' and ')' to get the value 24. 
//
// You are restricted with the following rules: 
//
// 
// The division operator '/' represents real division, not integer division.
//
// 
// For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12. 
// 
// 
// Every operation done is between two numbers. In particular, we cannot use '-
//' as a unary operator.
// 
// For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not 
//allowed. 
// 
// 
// You cannot concatenate numbers together
// 
// For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid. 
//
// 
// 
// 
//
// Return true if you can get such expression that evaluates to 24, and false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: cards = [4,1,8,7]
//Output: true
//Explanation: (8-4) * (7-1) = 24
// 
//
// Example 2: 
//
// 
//Input: cards = [1,2,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// cards.length == 4 
// 1 <= cards[i] <= 9 
// 
// Related Topics 数组 数学 回溯 👍 342 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Two4Game {
    public static void main(String[] args) {
        Solution solution = new Two4Game().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean judgePoint24 (int[] cards) {
        double eps = 0.001;
        List<Double> list = new ArrayList<>();
        for (int n : cards) {
            list.add(n * 1.0);
        }
        return helper(list, eps);
    }

    public boolean helper(List<Double> nums, double eps) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < eps;
        }
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.size(); ++j) {
                if (i == j) continue;
                List<Double> temp = new ArrayList<>(nums);
                double num_i = temp.get(i);
                double num_j = temp.get(j);
                temp.remove(num_i);
                temp.remove(num_j);
                for (int opt = 0; opt < 4; ++opt) {
                    // */0 is not allowed
                    if (opt == 3 && num_j < eps) continue;
                    temp.add(cal(num_i, num_j, opt));
                    if (helper(temp, eps)) {
                        return true;
                    }
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }

    public double cal(double a, double b, int opt) {
        switch (opt) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
            default:
                return 0;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
