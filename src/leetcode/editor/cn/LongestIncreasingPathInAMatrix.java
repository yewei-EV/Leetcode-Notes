/**
  * 题目Id：329
  * 题目：Longest Increasing Path in a Matrix
  * 日期：2022-02-26 23:55:21
*/
//Given an m x n integers matrix, return the length of the longest increasing 
//path in matrix. 
//
// From each cell, you can either move in four directions: left, right, up, or 
//down. You may not move diagonally or move outside the boundary (i.e., wrap-
//around is not allowed). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
//
// 
//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally 
//is not allowed.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 601 👎 0

package leetcode.editor.cn;
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int x, int y, int[][] memo) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 1;
        for (int[] dir : dirs) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && matrix[newX][newY] > matrix[x][y]) {
                ans = Math.max(ans, 1 + dfs(matrix, newX, newY, memo));
                memo[x][y] = ans;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
