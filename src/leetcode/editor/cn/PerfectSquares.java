/**
  * 题目Id：279
  * 题目：Perfect Squares
  * 日期：2021-12-12 09:57:27
*/
//Given an integer n, return the least number of perfect square numbers that 
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1162 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        //DP
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int j = 1; j <= n; ++j) {
//            for (int i = 1; i * i <= j; ++i) {
//                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
//            }
//        }
//        return dp[n];

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] marked = new boolean[n + 1];
        marked[n] = true;
        int length = 0;
        while (queue.size() != 0) {
            length++;
            int size = queue.size();
            while (size-- > 0) {
                Integer cur = queue.poll();
                for (int i = 1; i * i <= n; i++) {
                    int next = cur - i * i;
                    if (next == 0) {
                        return length;
                    }
                    if (next < 0) {
                        continue;
                    }
                    if (!marked[next]) {
                        queue.add(next);
                        marked[next] = true;
                    }
                }
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
