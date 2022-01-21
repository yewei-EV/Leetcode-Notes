/**
  * 题目Id：99
  * 题目：Recover Binary Search Tree
  * 日期：2021-12-31 12:24:09
*/
//You are given the root of a binary search tree (BST), where the values of 
//exactly two nodes of the tree were swapped by mistake. Recover the tree without 
//changing its structure. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 
//makes the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 
//and 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//Follow up: A solution using O(n) space is pretty straight-forward. Could you 
//devise a constant O(1) space solution? Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 623 ?
//? 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
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
    // For DFS
//    TreeNode first = null;
//    TreeNode second = null;
//    TreeNode pre = null;
//    public void recoverTree(TreeNode root) {
        // DFS
//        dfs(root);
//        if (first != null && second != null) {
//            int temp = first.val;
//            first.val = second.val;
//            second.val = temp;
//        }
        // Iteration
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre = null;
//        TreeNode first = null;
//        TreeNode second = null;
//
//        while(!stack.isEmpty() || root != null) {
//            while(root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            if (!stack.isEmpty()) {
//                root = stack.pop();
//                if (pre != null && root.val < pre.val && first == null) {
//                    first = pre;
//                }
//                if (first != null && pre.val > root.val) {
//                    second = root;
//                }
//                pre = root;
//                root = root.right;
//            }
//        }
//        int tmp = first.val;
//        first.val = second.val;
//        second.val = tmp;

    // Morris
    // https://www.youtube.com/watch?v=wGXB9OWhPTg
    public void recoverTree(TreeNode root) {
        //记录错误的两个值
        TreeNode x = null, y = null;
        //记录中序遍历当前节点的前驱
        TreeNode pre = null;
        //用来完成Morris连接的寻找前驱的指针
        TreeNode predecessor = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // compare cur.val
                if (pre != null && cur.val < pre.val && x == null) {
                    x = pre;
                }
                if (pre != null && x != null && pre.val > cur.val) {
                    y = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                predecessor = findPredecessor(cur);
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    predecessor.right = null;
                    // compare cur.val
                    if (pre != null && cur.val < pre.val && x == null) {
                        x = pre;
                    }
                    if (pre != null && x != null && pre.val > cur.val) {
                        y = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        swap(x, y);
    }

    public TreeNode findPredecessor(TreeNode cur) {
       TreeNode predecessor = cur.left;
        while (predecessor.right != null && predecessor.right != cur) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    }

//    public void dfs(TreeNode root) {
//        if (root == null) return;
//        dfs(root.left);
//        //check root.val
//        if (pre != null && root.val < pre.val && first == null) {
//            first = pre;
//        }
//        if (pre != null && first != null && root.val < pre.val) {
//            second = root;
//        }
//        pre = root;
//        dfs(root.right);
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

} 
