/**
  * 题目Id：130
  * 题目：Surrounded Regions
  * 日期：2021-12-14 22:41:00
*/
//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
//
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Surrounded regions should not be on the border, which means that 
//any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not 
//on the border and it is not connected to an 'O' on the border will be flipped to 
//'X'. Two cells are connected if they are adjacent cells connected horizontally 
//or vertically.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 677 👎 0

package leetcode.editor.cn;
public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int m, n;
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        for (int j = 0; j < m; ++j) {
            dfs(board, j, 0);
            dfs(board, j, n-1);
        }


        for (int i = 0; i < n; ++i) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
