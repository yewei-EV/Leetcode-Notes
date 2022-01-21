/**
  * 题目Id：742
  * 题目：Closest Leaf in a Binary Tree
  * 日期：2022-01-02 21:49:53
*/
//Given the root of a binary tree where every node has a unique value and a 
//target integer k, return the value of the nearest leaf node to the target k in the 
//tree. 
//
// Nearest to a leaf means the least number of edges traveled on the binary 
//tree to reach any leaf of the tree. Also, a node is called a leaf if it has no 
//children. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,2], k = 1
//Output: 2
//Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], k = 1
//Output: 1
//Explanation: The nearest leaf node is the root node itself.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2,3,4,null,null,null,5,null,6], k = 2
//Output: 3
//Explanation: The leaf node with value 3 (and not the leaf node with value 6) 
//is nearest to the node with value 2.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// 1 <= Node.val <= 1000 
// All the values of the tree are unique. 
// There exist some node in the tree where Node.val == k. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 79 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ClosestLeafInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new ClosestLeafInABinaryTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution {
    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    TreeNode start = null;
    public int findClosestLeaf(TreeNode root, int k) {
        buildGraph(root, null, k);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet();
        queue.offer(start);
         while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                seen.add(node);
                if (node.right == null && node.left == null) {
                    return node.val;
                }
                for (TreeNode treeNode : map.get(node)) {
                    if (!seen.contains(treeNode)) {
                        queue.offer(treeNode);
                    }
                }
            }
        }
        return -1;
    }

    public void buildGraph(TreeNode root, TreeNode parent, int k) {
        if (root == null) return;
        if (root.val == k) start = root;
        if (!map.containsKey(root)) map.put(root, new ArrayList<>());
        if (parent != null && !map.containsKey(parent)) map.put(parent, new ArrayList<>());
        if (parent != null) {
            map.get(parent).add(root);
            map.get(root).add(parent);
        }
        buildGraph(root.left, root, k);
        buildGraph(root.right, root, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
