/**
  * 题目Id：52
  * 题目：N-Queens II
  * 日期：2022-02-24 17:18:12
*/
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens 
//puzzle. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics 回溯 👍 334 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        if (n == 0) return count;
        char[][] chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }
        dfs(chess, 0, n);
        return count;
    }

    public void dfs(char[][] chess, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (isValidPoint(chess, row, j)) {
                chess[row][j] = 'Q';
                dfs(chess, row + 1, n);
                chess[row][j] = '.';
            }
        }
    }

    public boolean isValidPoint(char[][] chess, int x, int y) {
        //check col
        for (int i = 0; i < x; i++) {
            if (chess[i][y] == 'Q') {
                return false;
            }
        }
        //check 135 degree diagonal
        for (int i = x-1, j = y+1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //check 45 degree diagonal
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
