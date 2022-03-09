/**
  * 题目Id：1161
  * 题目：Maximum Level Sum of a Binary Tree
  * 日期：2022-03-08 10:19:53
*/
//Given the root of a binary tree, the level of its root is 1, the level of its 
//children is 2, and so on. 
//
// Return the smallest level x such that the sum of all the values of nodes at 
//level x is maximal. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,7,0,7,-8,null,null]
//Output: 2
//Explanation: 
//Level 1 sum = 1.
//Level 2 sum = 7 + 0 = 7.
//Level 3 sum = 7 + -8 = -1.
//So we return the level with the maximum sum which is level 2.
// 
//
// Example 2: 
//
// 
//Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 51 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumLevelSumOfABinaryTree().new Solution();
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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while (size > 0) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            level++;
            if (sum > max) {
                maxIndex = level;
                max = sum;
            }
        }
        return maxIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
