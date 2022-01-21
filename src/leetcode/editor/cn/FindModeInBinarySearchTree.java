/**
  * 题目Id：501
  * 题目：Find Mode in Binary Search Tree
  * 日期：2022-01-14 00:32:20
*/
//Given the root of a binary search tree (BST) with duplicates, return all the 
//mode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal 
//to the node's key. 
// The right subtree of a node contains only nodes with keys greater than or 
//equal to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count). Related Topics 树 
//深度优先搜索 二叉搜索树 二叉树 👍 396 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
    List<Integer> answer = new ArrayList<Integer>();
    int prev = Integer.MIN_VALUE;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (root.val == prev) {
            count++;
        } else {
            prev = root.val;
            count = 1;
        }
        if (count == max) {
            answer.add(root.val);
        } else if (count > max) {
            max = count;
            answer.clear();
            answer.add(root.val);
        }
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
