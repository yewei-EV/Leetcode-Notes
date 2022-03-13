/**
  * 题目Id：84
  * 题目：Largest Rectangle in Histogram
  * 日期：2022-01-31 16:17:07
*/
//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1725 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (heights.length == 0) {
            return 0;
        }
        // monotonic stack in ascending order
        Deque<Integer> stack = new LinkedList<>();
        int[] leftLess = new int[n];
        Arrays.fill(leftLess, -1);
        int[] rightLess = new int[n];
        Arrays.fill(rightLess, n);
        for (int i = 0; i < n; i++) {
            int cur = heights[i];
            // pop out if new element is less and EQUAL to peek element
            // since we are going to find the first SMALLER element
            // NOTICE we are using index in stack
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                rightLess[stack.peek()] = i;
                stack.pop();
            }
            // do not forget to consider null stack
            leftLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, (rightLess[j] - leftLess[j] - 1) * heights[j]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
