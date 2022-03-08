/**
  * 题目Id：1448
  * 题目：Count Good Nodes in Binary Tree
  * 日期：2022-03-08 08:31:32
*/
//Given a binary tree root, a node X in the tree is named good if in the path 
//from root to X there are no nodes with a value greater than X. 
//
// Return the number of good nodes in the binary tree. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path. 
//
// Example 2: 
//
// 
//
// 
//Input: root = [3,3,null,4,2]
//Output: 3
//Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it. 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
//Explanation: Root is considered as good. 
//
// 
// Constraints: 
//
// 
// The number of nodes in the binary tree is in the range [1, 10^5]. 
// Each node's value is between [-10^4, 10^4]. 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 48 👎 0

package leetcode.editor.cn;
public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new CountGoodNodesInBinaryTree().new Solution();
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
    int ans;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            ans++;
        }
        dfs(root.left, Math.max(root.val, max));
        dfs(root.right, Math.max(root.val, max));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
