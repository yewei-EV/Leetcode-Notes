/**
  * 题目Id：653
  * 题目：Two Sum IV - Input is a BST
  * 日期：2022-01-14 00:04:00
*/
//Given the root of a Binary Search Tree and a target number k, return true if 
//there exist two elements in the BST such that their sum is equal to the given 
//target. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 28
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root is guaranteed to be a valid binary search tree. 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 304 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int small = 0, large = nums.size() - 1;
        while (small < large) {
            int sum = nums.get(small) + nums.get(large);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                small++;
            } else {
                large--;
            }
        }
        return false;
    }

    public void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
