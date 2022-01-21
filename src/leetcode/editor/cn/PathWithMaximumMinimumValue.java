/**
  * 题目Id：1102
  * 题目：Path With Maximum Minimum Value
  * 日期：2021-12-14 13:55:25
*/
//Given an m x n integer matrix grid, return the maximum score of a path 
//starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions. 
//
// The score of a path is the minimum value in that path. 
//
// 
// For example, the score of the path 8 → 4 → 5 → 9 is 4. 
// 
//
// 
// Example 1: 
//
// 
//Input: grid = [[5,4,5],[1,2,6],[7,4,6]]
//Output: 4
//Explanation: The path with the maximum score is highlighted in yellow. 
// 
//
// Example 2: 
//
// 
//Input: grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,
//6,5,4,3]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// 0 <= grid[i][j] <= 10⁹ 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 堆（优先队列） 👍 79 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumMinimumValue().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumMinimumPath(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> b.value - a.value);
        queue.offer(new Point(0, 0, grid[0][0]));
        while (queue.size() != 0) {
            Point cur = queue.poll();
            if (visited[cur.x][cur.y]) continue;
            if (cur.x == r-1 && cur.y == c-1) {
                return cur.value;
            }
            visited[cur.x][cur.y] = true;
            for (int[] dir : direction) {
                int nextX = cur.x + dir[0];
                int nextY = cur.y + dir[1];
                if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c || visited[nextX][nextY]) {
                    continue;
                }
                queue.offer(new Point(nextX, nextY, Math.min(grid[nextX][nextY], cur.value)));
            }

        }
        return -1;
    }

    public class Point {
        public int x;
        public int y;
        public int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
