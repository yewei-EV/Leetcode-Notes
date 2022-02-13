/**
  * 题目Id：1020
  * 题目：Number of Enclaves
  * 日期：2022-02-12 12:24:52
*/
//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
//directionally) land cell or walking off the boundary of the grid. 
//
// Return the number of land cells in grid for which we cannot walk off the 
//boundary of the grid in any number of moves. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is 
//not enclosed because its on the boundary.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 108 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] directions = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
        };
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                queue.add(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                visited[i][n - 1] = true;
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 1) {
                visited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (grid[m - 1][j] == 1) {
                visited[m - 1][j] = true;
                queue.offer(new int[]{m - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0], curCol = cell[1];
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = curCol + dir[1];
                if (nextCol >= 0 && nextCol < n && nextRow >= 0 && nextRow < m
                        &&!visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
