/**
  * 题目Id：847
  * 题目：Shortest Path Visiting All Nodes
  * 日期：2022-01-22 23:04:14
*/
//You have an undirected, connected graph of n nodes labeled from 0 to n - 1. 
//You are given an array graph where graph[i] is a list of all the nodes connected 
//with node i by an edge. 
//
// Return the length of the shortest path that visits every node. You may start 
//and stop at any node, you may revisit nodes multiple times, and you may reuse 
//edges. 
//
// 
// Example 1: 
//
// 
//Input: graph = [[1,2,3],[0],[0],[0]]
//Output: 4
//Explanation: One possible path is [1,0,2,0,3]
// 
//
// Example 2: 
//
// 
//Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
//Output: 4
//Explanation: One possible path is [0,1,4,2,3]
// 
//
// 
// Constraints: 
//
// 
// n == graph.length 
// 1 <= n <= 12 
// 0 <= graph[i].length < n 
// graph[i] does not contain i. 
// If graph[a] contains b, then graph[b] contains a. 
// The input graph is always connected. 
// 
// Related Topics 位运算 广度优先搜索 图 动态规划 状态压缩 👍 265 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        Solution solution = new ShortestPathVisitingAllNodes().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] vis = new boolean[n][1 << n];
        // int[index, mask, step]
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        }
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll(); // 弹出队头元素
            int index = tuple[0], state = tuple[1], step = tuple[2];
            if (state == (1 << n) - 1) return step;
            for (int x : graph[index]) {
                int nextState = state | (1 << x);
                if (vis[x][nextState]) continue;
                queue.offer(new int[]{x, nextState, step + 1});
                vis[x][nextState] = true;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
