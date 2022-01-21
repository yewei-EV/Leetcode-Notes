/**
  * 题目Id：958
  * 题目：Check Completeness of a Binary Tree
  * 日期：2022-01-01 20:19:26
*/
//Given the root of a binary tree, determine if it is a complete binary tree. 
//
// In a complete binary tree, every level, except possibly the last, is 
//completely filled, and all nodes in the last level are as far left as possible. It can 
//have between 1 and 2ʰ nodes inclusive at the last level h. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values 
//{1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as 
//possible.
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 165 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reachEnd = false;
        while (queue.size() != 0) {
            TreeNode cur = queue.poll();
            if (reachEnd && cur != null) {
                return false;
            }
            if (cur == null) {
                reachEnd = true;
                continue;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
