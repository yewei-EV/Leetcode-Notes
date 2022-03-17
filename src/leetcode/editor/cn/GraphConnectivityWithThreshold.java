/**
  * 题目Id：1627
  * 题目：Graph Connectivity With Threshold
  * 日期：2022-03-15 21:59:49
*/
//We have n cities labeled from 1 to n. Two different cities with labels x and 
//y are directly connected by a bidirectional road if and only if x and y share a 
//common divisor strictly greater than some threshold. More formally, cities with 
//labels x and y have a road between them if there exists an integer z such that 
//all of the following are true: 
//
// 
// x % z == 0, 
// y % z == 0, and 
// z > threshold. 
// 
//
// Given the two integers, n and threshold, and an array of queries, you must 
//determine for each queries[i] = [ai, bi] if cities ai and bi are connected 
//directly or indirectly. (i.e. there is some path between them). 
//
// Return an array answer, where answer.length == queries.length and answer[i] 
//is true if for the iᵗʰ query, there is a path between ai and bi, or answer[i] is 
//false if there is no path. 
//
// 
// Example 1: 
//
// 
//Input: n = 6, threshold = 2, queries = [[1,4],[2,5],[3,6]]
//Output: [false,false,true]
//Explanation: The divisors for each number:
//1:   1
//2:   1, 2
//3:   1, 3
//4:   1, 2, 4
//5:   1, 5
//6:   1, 2, 3, 6
//Using the underlined divisors above the threshold, only cities 3 and 6 share 
//a common divisor, so they are the
//only ones directly connected. The result of each query:
//[1,4]   1 is not connected to 4
//[2,5]   2 is not connected to 5
//[3,6]   3 is connected to 6 through path 3--6
// 
//
// Example 2: 
//
// 
//Input: n = 6, threshold = 0, queries = [[4,5],[3,4],[3,2],[2,6],[1,3]]
//Output: [true,true,true,true,true]
//Explanation: The divisors for each number are the same as the previous 
//example. However, since the threshold is 0,
//all divisors can be used. Since all numbers share 1 as a divisor, all cities 
//are connected.
// 
//
// Example 3: 
//
// 
//Input: n = 5, threshold = 1, queries = [[4,5],[4,5],[3,2],[2,3],[3,4]]
//Output: [false,false,false,false,false]
//Explanation: Only cities 2 and 4 share a common divisor 2 which is strictly 
//greater than the threshold 1, so they are the only ones directly connected.
//Please notice that there can be multiple queries for the same pair of nodes [
//x, y], and that the query [x, y] is equivalent to the query [y, x].
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁴ 
// 0 <= threshold <= n 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 1 <= ai, bi <= cities 
// ai != bi 
// 
// Related Topics 并查集 数组 数学 👍 35 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GraphConnectivityWithThreshold {
    public static void main(String[] args) {
        Solution solution = new GraphConnectivityWithThreshold().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class UnionFind {

        private int[] rank;
        private int[] parent;
        // count how many sets we have
        private int count;

        public UnionFind(int size) {
            count = size;
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            // recursive
            int pt = parent[p];
            // found the root
            if (pt == p) {
                return pt;
            }
            parent[p] = find(parent[p]);
            return parent[p];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                if (rank[rootA] == rank[rootB]) {
                    rank[rootB]++;
                }
                parent[rootA] = rootB;
            }
            count--;
        }

        public int getCount() {
            return count;
        }

    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        // since n is starting from 1
        UnionFind uf = new UnionFind(n + 1);
        int max = n/2;
        for (int i = threshold + 1; i <= max; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                uf.union(i, j);
            }
        }
        List<Boolean> ans = new ArrayList<>(n);
        for (int[] query : queries) {
            if (uf.find(query[0]) == uf.find(query[1])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
