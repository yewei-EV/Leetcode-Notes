/**
  * 题目Id：863
  * 题目：All Nodes Distance K in Binary Tree
  * 日期：2022-01-03 00:58:48
*/
//Given the root of a binary tree, the value of a target node target, and an 
//integer k, return an array of the values of all nodes that have a distance k from 
//the target node. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 
//5) have values 7, 4, and 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], target = 1, k = 3
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 500]. 
// 0 <= Node.val <= 500 
// All the values Node.val are unique. 
// target is the value of one of the nodes in the tree. 
// 0 <= k <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 469 👎 0

package leetcode.editor.cn;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    HashMap<TreeNode, Boolean> visited = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        buildGraph(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(target);
        while (queue.size() != 0) {
            int size = queue.size();
            if (depth > k) {
                break;
            }
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                visited.put(cur, true);
                if (cur != null && depth == k) {
                    res.add(cur.val);
                }
                if (cur.left != null && !visited.get(cur.left)) {
                    queue.add(cur.left);
                }
                if (cur.right != null && !visited.get(cur.right)) {
                    queue.add(cur.right);
                }
                TreeNode parent = map.get(cur);
                if (parent != null && !visited.get(parent)) {
                    queue.add(parent);
                }
            }
            depth++;
        }
        return res;
    }

    public void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;
        visited.put(root, false);
        map.put(root, parent);
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
