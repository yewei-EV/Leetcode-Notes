/**
  * 题目Id：634
  * 题目：Find the Derangement of An Array
  * 日期：2021-12-22 18:50:56
*/
//In combinatorial mathematics, a derangement is a permutation of the elements 
//of a set, such that no element appears in its original position. 
//
// You are given an integer n. There is originally an array consisting of n 
//integers from 1 to n in ascending order, return the number of derangements it can 
//generate. Since the answer may be huge, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] 
//and [3,1,2].
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁶ 
// 
// Related Topics 数学 动态规划 👍 34 👎 0

package leetcode.editor.cn;
public class FindTheDerangementOfAnArray {
    public static void main(String[] args) {
        Solution solution = new FindTheDerangementOfAnArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDerangement(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        long[] dp = new long[n + 1];
        double modVal = Math.pow(10,9) + 7;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (int)(((long)(i - 1) * (dp[i - 1] + dp[i - 2])) % modVal);
        }
        return (int) dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
