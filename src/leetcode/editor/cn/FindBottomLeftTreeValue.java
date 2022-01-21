/**
  * 题目Id：513
  * 题目：Find Bottom Left Tree Value
  * 日期：2022-01-13 11:59:02
*/
//Given the root of a binary tree, return the leftmost value in the last row of 
//the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 231 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
    int maxLength = Integer.MIN_VALUE;
    int maxLeftValue;
    public int findBottomLeftValue(TreeNode root) {
        //bfs
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        TreeNode cur = null;
//        while (queue.size() != 0) {
//            cur = queue.poll();
//            if (cur.right != null) queue.add(cur.right);
//            if (cur.left != null) queue.add(cur.left);
//        }
//        return cur.val;

        //dfs
        dfs(root, 0);
        return maxLeftValue;
    }

    //dfs
    public void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxLength) {
                maxLeftValue = root.val;
                maxLength = depth;
                return;
            }
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
