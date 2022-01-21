/**
  * 题目Id：1631
  * 题目：Path With Minimum Effort
  * 日期：2021-12-14 15:46:50
*/
//You are a hiker preparing for an upcoming hike. You are given heights, a 2D 
//array of size rows x columns, where heights[row][col] represents the height of 
//cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to 
//travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can 
//move up, down, left, or right, and you wish to find a route that requires the 
//minimum effort. 
//
// A route's effort is the maximum absolute difference in heights between two 
//consecutive cells of the route. 
//
// Return the minimum effort required to travel from the top-left cell to the 
//bottom-right cell. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//Output: 2
//Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 
//in consecutive cells.
//This is better than the route of [1,2,2,2,5], where the maximum absolute 
//difference is 3.
// 
//
// Example 2: 
//
// 
//
// 
//Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//Output: 1
//Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 
//in consecutive cells, which is better than route [1,3,5,3,5].
// 
//
// Example 3: 
//
// 
//Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
//Output: 0
//Explanation: This route does not require any effort.
// 
//
// 
// Constraints: 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 260 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new PathWithMinimumEffort().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        if (r == 1 && c == 0) return 0;
        boolean[][] visited = new boolean[r][c];
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        queue.offer(new Point(0, 0, 0));
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
                queue.offer(new Point(nextX, nextY, Math.max(
                        Math.abs(heights[cur.x][cur.y] - heights[nextX][nextY]), cur.value)
                        )
                );
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
