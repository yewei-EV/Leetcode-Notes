/**
  * 题目Id：684
  * 题目：Redundant Connection
  * 日期：2021-12-30 00:07:15
*/
//In this problem, a tree is an undirected graph that is connected and has no 
//cycles. 
//
// You are given a graph that started as a tree with n nodes labeled from 1 to 
//n, with one additional edge added. The added edge has two different vertices 
//chosen from 1 to n, and was not an edge that already existed. The graph is 
//represented as an array edges of length n where edges[i] = [ai, bi] indicates that there 
//is an edge between nodes ai and bi in the graph. 
//
// Return an edge that can be removed so that the resulting graph is a tree of 
//n nodes. If there are multiple answers, return the answer that occurs last in 
//the input. 
//
// 
// Example 1: 
//
// 
//Input: edges = [[1,2],[1,3],[2,3]]
//Output: [2,3]
// 
//
// Example 2: 
//
// 
//Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
//Output: [1,4]
// 
//
// 
// Constraints: 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ai < bi <= edges.length 
// ai != bi 
// There are no repeated edges. 
// The given graph is connected. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 419 👎 0

package leetcode.editor.cn;
public class RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new RedundantConnection().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] res = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length+1);
        for (int[] edge : edges){
            unionFind.union(edge[0], edge[1]);
        }
        return res;
    }

    class UnionFind {
        private int[] roots;

        public UnionFind(int size){
            this.roots = new int[size];
            for (int i = 0; i < size; i++){
                roots[i] = i;
            }
        }
        public int find(int x){
            if(roots[x] != x){
                roots[x] = find(roots[x]);
            }
            return roots[x];
        }
        public void union(int x, int y){
            int root1 = find(x);
            int root2 = find(y);
            if (root1 != root2){
                roots[root1] = root2;
            } else {
                res[0] = x;
                res[1] = y;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
