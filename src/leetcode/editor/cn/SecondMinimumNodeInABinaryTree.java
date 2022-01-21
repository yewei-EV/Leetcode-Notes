/**
  * 题目Id：671
  * 题目：Second Minimum Node In a Binary Tree
  * 日期：2022-01-12 12:32:44
*/
//Given a non-empty special binary tree consisting of nodes with the non-
//negative value, where each node in this tree has exactly two or zero sub-node. If the 
//node has two sub-nodes, then this node's value is the smaller value among its 
//two sub-nodes. More formally, the property root.val = min(root.left.val, root.
//right.val) always holds. 
//
// Given such a binary tree, you need to output the second minimum value in the 
//set made of all the nodes' value in the whole tree. 
//
// If no such second minimum value exists, output -1 instead. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,2,5,null,null,5,7]
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.
// 
//
// Example 2: 
//
// 
//Input: root = [2,2,2]
//Output: -1
//Explanation: The smallest value is 2, but there isn't any second smallest 
//value.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 25]. 
// 1 <= Node.val <= 2³¹ - 1 
// root.val == min(root.left.val, root.right.val) for each internal node of the 
//tree. 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 243 👎 0

package leetcode.editor.cn;
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int leftMin = dfs(root.left, min);
        int rightMin = dfs(root.right, min);
        if (leftMin != -1 && rightMin != -1) {
            return Math.min(leftMin, rightMin);
        } else {
            return Math.max(leftMin, rightMin);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
