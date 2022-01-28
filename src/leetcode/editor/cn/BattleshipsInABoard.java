/**
  * 题目Id：419
  * 题目：Battleships in a Board
  * 日期：2022-01-28 14:31:07
*/
//Given an m x n matrix board where each cell is a battleship 'X' or empty '.', 
//return the number of the battleships on board. 
//
// Battleships can only be placed horizontally or vertically on board. In other 
//words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k 
//rows, 1 column), where k can be of any size. At least one horizontal or vertical 
//cell separates between two battleships (i.e., there are no adjacent battleships)
//. 
//
// 
// Example 1: 
//
// 
//Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: board = [["."]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is either '.' or 'X'. 
// 
//
// 
// Follow up: Could you do it in one-pass, using only O(1) extra memory and 
//without modifying the values board? 
// Related Topics 深度优先搜索 数组 矩阵 👍 196 👎 0

package leetcode.editor.cn;
public class BattleshipsInABoard {
    public static void main(String[] args) {
        Solution solution = new BattleshipsInABoard().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                } else if (j > 0 && board[i][j - 1] == 'X') {
                  continue;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
