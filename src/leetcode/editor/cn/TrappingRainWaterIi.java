/**
  * 题目Id：407
  * 题目：Trapping Rain Water II
  * 日期：2021-12-14 17:14:08
*/
//Given an m x n integer matrix heightMap representing the height of each unit 
//cell in a 2D elevation map, return the volume of water it can trap after raining.
// 
//
// 
// Example 1: 
//
// 
//Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//Output: 4
//Explanation: After the rain, water is trapped between the blocks.
//We have two small ponds 1 and 3 units trapped.
//The total volume of water trapped is 4.
// 
//
// Example 2: 
//
// 
//Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3
//]]
//Output: 10
// 
//
// 
// Constraints: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 544 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class TrappingRainWaterIi {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWaterIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b)->a.value - b.value);
        boolean[][] visisted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.add(new Point(i, 0, heightMap[i][0]));
            queue.add(new Point(i, n - 1, heightMap[i][n - 1]));
            visisted[i][0] = visisted[i][n - 1] = true;
        }
        for (int i = 1; i < n-1; i++) {
            queue.add(new Point(0, i, heightMap[0][i]));
            queue.add(new Point(m - 1, i, heightMap[m - 1][i]));
            visisted[0][i] = visisted[m - 1][i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x, y = poll.y, h = poll.value;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visisted[nx][ny]) continue;
                if (h > heightMap[nx][ny]) {
                    ans += h - heightMap[nx][ny];
                }
                queue.add(new Point(nx, ny, Math.max(heightMap[nx][ny], h)));
                visisted[nx][ny] = true;
            }
        }
        return ans;
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
