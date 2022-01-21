/**
  * 题目Id：69
  * 题目：Sqrt(x)
  * 日期：2021-12-07 17:42:28
*/
//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and 
//only the integer part of the result is returned. 
//
// Note: You are not allowed to use any built-in exponent function or operator, 
//such as pow(x, 0.5) or x ** 0.5. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part 
//is truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 832 👎 0

package leetcode.editor.cn;
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int h = x;
        while (l <= h) {
            int m = l + (h - l)/2;
            if (x/m == m) {
                return m;
            } else if (x/m > m) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
