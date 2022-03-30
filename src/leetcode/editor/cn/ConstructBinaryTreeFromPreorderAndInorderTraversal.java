/**
  * 题目Id：105
  * 题目：Construct Binary Tree from Preorder and Inorder Traversal
  * 日期：2022-03-29 23:50:42
*/
//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1506 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: root left right
        // inorder: left root right
        // for first element in preorder, it is the root
        //  find the root in inorder, so left part in inorder is the left subtree
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int rootIdx = inorderMap.get(preorder[preL]);
        int leftSize = rootIdx - inL;
        root.left = helper(preorder, inorder, preL + 1, preL + leftSize, inL, rootIdx - 1);
        root.right = helper(preorder, inorder, preL + leftSize + 1, preR, rootIdx + 1, inR);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
