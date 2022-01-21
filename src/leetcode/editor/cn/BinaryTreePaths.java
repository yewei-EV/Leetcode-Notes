/**
  * 题目Id：257
  * 题目：Binary Tree Paths
  * 日期：2021-12-15 15:25:54
*/
//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 617 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        backtracking(root, new StringBuilder(), result);
        return result;
    }

    public void backtracking(TreeNode root, StringBuilder s, List<String> result) {
        if (root == null) return;
        if (s.length() == 0) {
            s.append(root.val);
        } else {
            s.append("->").append(root.val);
        }
        if (root.left == null & root.right == null) {
            result.add(String.valueOf(s));
        }
        backtracking(root.left, new StringBuilder(s), result);
        backtracking(root.right, new StringBuilder(s), result);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
