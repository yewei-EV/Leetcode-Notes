/**
  * 题目Id：417
  * 题目：Pacific Atlantic Water Flow
  * 日期：2021-12-14 22:41:12
*/
//There is an m x n rectangular island that borders both the Pacific Ocean and 
//Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and 
//the Atlantic Ocean touches the island's right and bottom edges. 
//
// The island is partitioned into a grid of square cells. You are given an m x 
//n integer matrix heights where heights[r][c] represents the height above sea 
//level of the cell at coordinate (r, c). 
//
// The island receives a lot of rain, and the rain water can flow to 
//neighboring cells directly north, south, east, and west if the neighboring cell's height 
//is less than or equal to the current cell's height. Water can flow from any cell 
//adjacent to an ocean into the ocean. 
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
//denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
//oceans. 
//
// 
// Example 1: 
//
// 
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// Example 2: 
//
// 
//Input: heights = [[2,1],[1,2]]
//Output: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 318 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }
        m = heights.length;
        n = heights[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP, heights);
            dfs(i, n-1, canReachA, heights);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP, heights);
            dfs(m-1, i, canReachA, heights);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int r, int c, boolean[][] canReach, int[][] heights) {
        if (canReach[r][c]) return;
        canReach[r][c] = true;
        for (int[] dir: direction) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) continue;
            if (heights[r][c] <= heights[nextR][nextC]) {
                dfs(nextR, nextC, canReach, heights);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
