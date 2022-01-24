/**
  * 题目Id：662
  * 题目：Maximum Width of Binary Tree
  * 日期：2022-01-24 22:04:38
*/
//Given the root of a binary tree, return the maximum width of the given tree. 
//
// The maximum width of a tree is the maximum width among all levels. 
//
// The width of one level is defined as the length between the end-nodes (the 
//leftmost and rightmost non-null nodes), where the null nodes between the end-
//nodes are also counted into the length calculation. 
//
// It is guaranteed that the answer will in the range of 32-bit signed integer. 
//
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (
//5,3,null,9).
// 
//
// Example 2: 
//
// 
//Input: root = [1,3,null,5,3]
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (
//5,3).
// 
//
// Example 3: 
//
// 
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 
//(3,2).
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3000]. 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 295 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
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
    public class MyTreeNode {
        TreeNode treeNode;
        int depth;
        int pos;
        MyTreeNode(TreeNode treeNode, int depth, int pos) {
            this.treeNode = treeNode;
            this.depth = depth;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(new MyTreeNode(root, 0, 0));
        int curDepth = 0;
        int firstPos = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            MyTreeNode cur = queue.poll();
            if (cur.treeNode != null) {
                queue.offer(new MyTreeNode(cur.treeNode.left, cur.depth + 1, 2 * cur.pos));
                queue.offer(new MyTreeNode(cur.treeNode.right, cur.depth + 1, 2 * cur.pos + 1));
                if (curDepth != cur.depth) {
                    curDepth = cur.depth;
                    firstPos = cur.pos;
                }
                max = Math.max(max, cur.pos - firstPos + 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
