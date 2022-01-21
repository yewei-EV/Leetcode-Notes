/**
  * 题目Id：547
  * 题目：Number of Provinces
  * 日期：2021-12-14 22:09:47
*/
//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no 
//other cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
//otherwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 674 👎 0

package leetcode.editor.cn;
public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int m = isConnected.length;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; ++i) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < isConnected.length; ++j) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
