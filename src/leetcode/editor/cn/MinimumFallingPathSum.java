/**
  * 题目Id：931
  * 题目：Minimum Falling Path Sum
  * 日期：2021-12-21 22:08:52
*/
//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 137 👎 0

package leetcode.editor.cn;
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        memo = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, findMinPath(matrix, 0, i));
        }
        return min;
    }

    private int findMinPath(int[][] matrix, int row, int col) {
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        int min = Integer.MAX_VALUE;
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        if (col - 1 >= 0) {
            min = Math.min(min, findMinPath(matrix, row + 1, col - 1) + matrix[row][col]);
        }
        if (col + 1 < matrix.length) {
            min = Math.min(min, findMinPath(matrix, row + 1, col + 1) + matrix[row][col]);
        }
        min = Math.min(min, findMinPath(matrix, row + 1, col) + matrix[row][col]);
        memo[row][col] = min;
        return min;
    }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < n; i++){
//            dp[0][i] = matrix[0][i];
//        }
//        for (int i = 1; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (j + 1 >= n) {
//                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
//                } else if (j - 1 < 0) {
//                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
//                } else {
//                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i-1][j+1]));
//                }
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            res = Math.min(dp[m-1][i], res);
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
