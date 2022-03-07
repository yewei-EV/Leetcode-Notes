/**
  * 题目Id：987
  * 题目：Vertical Order Traversal of a Binary Tree
  * 日期：2022-03-01 20:41:35
*/
//Given the root of a binary tree, calculate the vertical order traversal of 
//the binary tree. 
//
// For each node at position (row, col), its left and right children will be at 
//positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of 
//the tree is at (0, 0). 
//
// The vertical order traversal of a binary tree is a list of top-to-bottom 
//orderings for each column index starting from the leftmost column and ending on the 
//rightmost column. There may be multiple nodes in the same row and same column. 
//In such a case, sort these nodes by their values. 
//
// Return the vertical order traversal of the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Explanation:
//Column -1: Only node 9 is in this column.
//Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
//Column 1: Only node 20 is in this column.
//Column 2: Only node 7 is in this column. 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//Column -2: Only node 4 is in this column.
//Column -1: Only node 2 is in this column.
//Column 0: Nodes 1, 5, and 6 are in this column.
//          1 is at the top, so it comes first.
//          5 and 6 are at the same position (2, 0), so we order them by their 
//value, 5 before 6.
//Column 1: Only node 3 is in this column.
//Column 2: Only node 7 is in this column.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2,3,4,6,5,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//This case is the exact same as example 2, but with nodes 5 and 6 swapped.
//Note that the solution remains the same since 5 and 6 are in the same 
//location and should be ordered by their values.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// 0 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 177 👎 0

package leetcode.editor.cn;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0,0, nodes);
        // sort the nodes
        Collections.sort(nodes, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[2] - o2[2];
            }
        });
        int lastCol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[1], row = tuple[0], value = tuple[2];
            if (col != lastCol) {
                lastCol = col;
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(value);
        }
        return ans;
    }

    public void dfs(TreeNode root, int row, int index, List<int[]> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(new int[] {row, index, root.val});
        dfs(root.left, row + 1, index - 1, nodes);
        dfs(root.right, row + 1, index + 1, nodes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
