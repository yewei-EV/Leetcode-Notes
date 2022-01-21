/**
  * 题目Id：886
  * 题目：Possible Bipartition
  * 日期：2021-12-29 00:12:44
*/
//We want to split a group of n people (labeled from 1 to n) into two groups of 
//any size. Each person may dislike some other people, and they should not go 
//into the same group. 
//
// Given the integer n and the array dislikes where dislikes[i] = [ai, bi] 
//indicates that the person labeled ai does not like the person labeled bi, return 
//true if it is possible to split everyone into two groups in this way. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: group1 [1,4] and group2 [2,3].
// 
//
// Example 2: 
//
// 
//Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// All the pairs of dislikes are unique. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 146 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && !dfs(graph, i, visited, 1)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int i, int[] visited, int color) {
        if (visited[i] != 0) {
            return visited[i] == color;
        }
        visited[i] = color;
        for (Integer neighbor : graph.get(i)) {
            if (!dfs(graph, neighbor, visited, -color)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
