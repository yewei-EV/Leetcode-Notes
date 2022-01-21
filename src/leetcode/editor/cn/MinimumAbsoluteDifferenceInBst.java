/**
  * 题目Id：530
  * 题目：Minimum Absolute Difference in BST
  * 日期：2022-01-14 00:26:38
*/
//Given the root of a Binary Search Tree (BST), return the minimum absolute 
//difference between the values of any two different nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,6,1,3]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁴]. 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
// Note: This question is the same as 783: https://leetcode.com/problems/
//minimum-distance-between-bst-nodes/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 296 👎 0

package leetcode.editor.cn;
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
    int minDiff = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, root.val - preNode.val);
        }
        preNode = root;
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
