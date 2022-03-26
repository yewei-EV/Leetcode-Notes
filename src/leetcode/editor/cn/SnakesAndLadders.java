/**
  * 题目Id：909
  * 题目：Snakes and Ladders
  * 日期：2022-03-26 15:29:23
*/
//You are given an n x n integer matrix board where the cells are labeled from 1
// to n² in a Boustrophedon style starting from the bottom left of the board (i.e.
// board[n - 1][0]) and alternating direction each row. 
//
// You start on square 1 of the board. In each move, starting from square curr, 
//do the following: 
//
// 
// Choose a destination square next with a label in the range [curr + 1, min(
//curr + 6, n²)].
//
// 
// This choice simulates the result of a standard 6-sided die roll: i.e., there 
//are always at most 6 destinations, regardless of the size of the board. 
// 
// 
// If next has a snake or ladder, you must move to the destination of that 
//snake or ladder. Otherwise, you move to next. 
// The game ends when you reach the square n². 
// 
//
// A board square on row r and column c has a snake or ladder if board[r][c] != 
//-1. The destination of that snake or ladder is board[r][c]. Squares 1 and n² do 
//not have a snake or ladder. 
//
// Note that you only take a snake or ladder at most once per move. If the 
//destination to a snake or ladder is the start of another snake or ladder, you do not 
//follow the subsequent snake or ladder. 
//
// 
// For example, suppose the board is [[-1,4],[-1,3]], and on the first move, 
//your destination square is 2. You follow the ladder to square 3, but do not follow 
//the subsequent ladder to 4. 
// 
//
// Return the least number of moves required to reach the square n². If it is 
//not possible to reach the square, return -1. 
//
// 
// Example 1: 
//
// 
//Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-
//1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
//Output: 4
//Explanation: 
//In the beginning, you start at square 1 (at row 5, column 0).
//You decide to move to square 2 and must take the ladder to square 15.
//You then decide to move to square 17 and must take the snake to square 13.
//You then decide to move to square 14 and must take the ladder to square 35.
//You then decide to move to square 36, ending the game.
//This is the lowest possible number of moves to reach the last square, so 
//return 4.
// 
//
// Example 2: 
//
// 
//Input: board = [[-1,-1],[-1,3]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == board.length == board[i].length 
// 2 <= n <= 20 
// grid[i][j] is either -1 or in the range [1, n²]. 
// The squares labeled 1 and n² do not have any ladders or snakes. 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 90 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Solution solution = new SnakesAndLadders().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int snakesAndLadders(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int r = board.length;
        int c = board[0].length;
        int[] b = transferBoardToBeOneLine(board);
        Deque<Integer> queue = new LinkedList<>();
        int[] visited = new int[r * c + 1];
        int minSteps = 0;
        queue.offer(1);
        visited[1] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.pollFirst();
                if (cur == r * c) {
                    return minSteps;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    if (next > r * c) continue;
                    if (b[next] != -1) {
                        next = b[next];
                    }
                    if (visited[next] == 1) {
                        continue;
                    }
                    queue.addLast(next);
                    visited[next] = 1;
                }
            }
            minSteps++;
        }
        return -1;
    }

    public int[] transferBoardToBeOneLine(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[] ans = new int[r * c + 1];
        boolean revert = false;
        int index = 1;
        for (int i = r - 1; i >= 0; i--) {
            for (int j = (revert ? c - 1 : 0); revert ? j >= 0 : j < c; j += revert ? -1 : 1) {
                ans[index++] = board[i][j];
            }
            revert = !revert;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
