/**
  * 题目Id：542
  * 题目：01 Matrix
  * 日期：2021-12-20 15:51:23
*/
//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 561 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] ans = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir: direction) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < r && newY < c && !visited[newX][newY]) {
                    queue.offer(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    ans[newX][newY] = ans[x][y] + 1;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
