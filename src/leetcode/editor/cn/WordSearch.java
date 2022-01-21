/**
  * 题目Id：79
  * 题目：Word Search
  * 日期：2021-12-15 15:25:46
*/
//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
// Related Topics 数组 回溯 矩阵 👍 1116 👎 0

package leetcode.editor.cn;
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n;++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtracking(board, i, j, word, visit, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, int i, int j, String word, boolean[][] visit, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        for (int[] d : direction) {
            if (backtracking(board, i + d[0], j + d[1], word, visit, index+1)) {
                return true;
            }
        }
        visit[i][j] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
