/**
  * 题目Id：37
  * 题目：Sudoku Solver
  * 日期：2021-12-15 17:10:46
*/
//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
//boxes of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
//
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
//",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is 
//shown below:
//
//
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
// Related Topics 数组 回溯 矩阵 👍 1048 👎 0

package leetcode.editor.cn;
public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] != '.') {
                    continue;
                }
                for (char v = '1'; v <= '9'; ++v) {
                    if (isValid(r, c, board, v)) {
                        board[r][c] = v;
                        if (backtracking(board)) return true;
                        board[r][c] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int r, int c, char[][] board, char v) {
        for (int i = 0; i < 9; ++i) {
            if (board[r][i] == v) return false;
            if (board[i][c] == v) return false;
        }
        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;
        for (int i = startR; i <= startR + 2; ++i) {
            for (int j = startC; j <= startC + 2; ++j) {
                if (board[i][j] == v) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
