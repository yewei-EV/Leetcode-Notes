/**
  * 题目Id：51
  * 题目：N-Queens
  * 日期：2021-12-15 17:10:53
*/
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics 数组 回溯 👍 1123 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard, n, 0);
        return res;
    }

    public void backtracking(char[][] cheers, int n, int row) {
        if (row == n) {
            res.add(printCheers(cheers));
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (isValid(cheers, row, j, n)) {
                cheers[row][j] = 'Q';
                backtracking(cheers, n, row + 1);
                cheers[row][j] = '.';
            }
        }
    }

    public List<String> printCheers(char[][] cheers) {
        List<String> cheerBoard = new ArrayList<>();
        for (char[] cheer : cheers) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < cheers[0].length; ++j) {
                row.append(cheer[j]);
            }
            cheerBoard.add(String.valueOf(row));
        }
        return cheerBoard;
    }

    public boolean isValid(char[][] cheers, int row, int col, int n) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (cheers[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (cheers[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (cheers[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
