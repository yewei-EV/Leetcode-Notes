/**
  * 题目Id：687
  * 题目：Longest Univalue Path
  * 日期：2022-01-12 12:29:55
*/
//Given the root of a binary tree, return the length of the longest path, where 
//each node in the path has the same value. This path may or may not pass through 
//the root. 
//
// The length of the path between two nodes is represented by the number of 
//edges between them. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,5,1,1,5]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [1,4,5,4,4,5]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// The depth of the tree will not exceed 1000. 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 525 👎 0

package leetcode.editor.cn;
public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
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
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftSub = 0;
        int rightSub = 0;
        if (root.left != null && root.val == root.left.val) {
            leftSub = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightSub = right + 1;
        }
        max = Math.max(max, leftSub + rightSub);
        return Math.max(rightSub, leftSub);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
