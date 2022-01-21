/**
  * 题目Id：1162
  * 题目：As Far from Land as Possible
  * 日期：2021-12-20 15:49:49
*/
//Given an n x n grid containing only values 0 and 1, where 0 represents water 
//and 1 represents land, find a water cell such that its distance to the nearest 
//land cell is maximized, and return the distance. If no land or water exists in 
//the grid, return -1. 
//
// The distance used in this problem is the Manhattan distance: the distance 
//between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
//Output: 2
//Explanation: The cell (1, 1) is as far as possible from all the land with 
//distance 2.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
//Output: 4
//Explanation: The cell (2, 2) is as far as possible from all the land with 
//distance 4.
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 233 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int length = 0;
        boolean[][] visited = new boolean[r][c];
        int[][] ans = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        boolean hasOcean = false;
        int[] cur = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : direction) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newY >= 0 && newX < r && newY < c && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        ans[newX][newY] = ans[x][y] + 1;
                        hasOcean = true;
                    }
                }
            }
        }
        if (cur == null || !hasOcean) {
            return -1;
        }
        return ans[cur[0]][cur[1]];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
