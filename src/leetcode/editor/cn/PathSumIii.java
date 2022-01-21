/**
  * 题目Id：437
  * 题目：Path Sum III
  * 日期：2022-01-12 12:31:24
*/
//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1190 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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
    // <prefixSum, count>
    Map<Integer, Integer> map = new HashMap<>();
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0, 1);
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prefixSum) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        prefixSum += root.val;
        cnt += map.getOrDefault(prefixSum - target, 0);
        int temp = map.getOrDefault(prefixSum, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        cnt = cnt + dfs(root.left, prefixSum) + dfs(root.right, prefixSum);
        map.put(prefixSum, temp);
        return cnt;
    }


    // double-recursion
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//        return (count(root, targetSum) + pathSum(root.left, targetSum)  + pathSum(root.right, targetSum));
//    }

//    public int count(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//        int cnt = 0;
//        if (root.val == targetSum) cnt++;
//        cnt += (count(root.left, targetSum - root.val)
//                + count(root.right, targetSum - root.val));
//        return cnt;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
