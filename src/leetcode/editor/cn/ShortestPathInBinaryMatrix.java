/**
  * 题目Id：1091
  * 题目：Shortest Path in Binary Matrix
  * 日期：2021-12-12 00:05:08
*/
//Given an n x n binary matrix grid, return the length of the shortest clear 
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
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
// Related Topics 广度优先搜索 数组 矩阵 👍 147 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] sx = {1, 0, 0, -1, 1, 1, -1, -1};
    int[] sy = {0, 1, -1, 0, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.add(0);
        int path = 1;
        grid[0][0] = 1;
        while(queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Integer next = queue.poll();
                int x = next / n;
                int y = next % n;
                if(x == m - 1 && y == n - 1) {
                    return path;
                }
                for (int i = 0; i < 8; ++i) {
                    int x1 = x + sx[i], y1 = y + sy[i];
                    if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 0){
                        queue.add(x1 * n + y1);//在尾部加入符合条件的二维数组项的一维索引
                        grid[x1][y1] = 1;
                    }
                }
            }
            path++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
