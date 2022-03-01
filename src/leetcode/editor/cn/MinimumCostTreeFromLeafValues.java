/**
  * 题目Id：1130
  * 题目：Minimum Cost Tree From Leaf Values
  * 日期：2022-03-01 13:23:52
*/
//Given an array arr of positive integers, consider all binary trees such that: 
//
//
// 
// Each node has either 0 or 2 children; 
// The values of arr correspond to the values of each leaf in an in-order 
//traversal of the tree. 
// The value of each non-leaf node is equal to the product of the largest leaf 
//value in its left and right subtree, respectively. 
// 
//
// Among all possible binary trees considered, return the smallest possible sum 
//of the values of each non-leaf node. It is guaranteed this sum fits into a 32-
//bit integer. 
//
// A node is a leaf if and only if it has zero children. 
//
// 
// Example 1: 
//
// 
//Input: arr = [6,2,4]
//Output: 32
//Explanation: There are two possible trees shown.
//The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
//
// 
//
// Example 2: 
//
// 
//Input: arr = [4,11]
//Output: 44
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 40 
// 1 <= arr[i] <= 15 
// It is guaranteed that the answer fits into a 32-bit signed integer (i.e., it 
//is less than 2³¹). 
// 
// Related Topics 栈 贪心 动态规划 单调栈 👍 219 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        Solution solution = new MinimumCostTreeFromLeafValues().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while (stack.size() > 1 && stack.peek() < cur) {
                mct += stack.pop() * Math.min(stack.peek(), cur);
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 2) {
            mct += stack.pop() * stack.peek();
        }
        return mct;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
