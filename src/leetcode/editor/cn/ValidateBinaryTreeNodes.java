/**
  * 题目Id：1361
  * 题目：Validate Binary Tree Nodes
  * 日期：2022-02-24 17:40:36
*/
//You have n binary tree nodes numbered from 0 to n - 1 where node i has two 
//children leftChild[i] and rightChild[i], return true if and only if all the given 
//nodes form exactly one valid binary tree. 
//
// If node i has no left child then leftChild[i] will equal -1, similarly for 
//the right child. 
//
// Note that the nodes have no values and that we only use the node numbers in 
//this problem. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// n == leftChild.length == rightChild.length 
// 1 <= n <= 10⁴ 
// -1 <= leftChild[i], rightChild[i] <= n - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 并查集 图 二叉树 👍 79 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        Solution solution = new ValidateBinaryTreeNodes().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        // check if every node only has at least one parent
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
                if (inDegree[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
                if (inDegree[rightChild[i]] > 1) {
                    return false;
                }
            }
        }
        int count = 0;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) root = i;
            count += inDegree[i];
        }
        // check if there is only one root
        if (count != (n-1)) return false;

        //check if there is a loop
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        Set<Integer> visited = new HashSet<>();
        visited.add(root);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (leftChild[cur] != -1) {
                if (visited.contains(leftChild[cur])) {
                    return false;
                } else {
                    visited.add(leftChild[cur]);
                    queue.offer(leftChild[cur]);
                }
            }
            if (rightChild[cur] != -1) {
                if (visited.contains(rightChild[cur])) {
                    return false;
                } else {
                    visited.add(rightChild[cur]);
                    queue.offer(rightChild[cur]);
                }
            }
        }
        return visited.size() == n;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
