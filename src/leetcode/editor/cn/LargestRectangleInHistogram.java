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

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> monoStack = new LinkedList<>();
        int[] leftLess = new int[n];
        int[] rightLess = new int[n];
        Arrays.fill(rightLess, n);
        for (int i = 0; i < n; ++i) {
            int cur = heights[i];
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= cur) {
                rightLess[monoStack.peek()] = i;
                monoStack.pop();
            }
            leftLess[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (rightLess[i] - leftLess[i] - 1) * heights[i]);
        }
        return ans;

//        int n = heights.length;
//        Deque<Integer> leftLessStack = new LinkedList<>();
//        Deque<Integer> rightLessStack = new LinkedList<>();
//        int[] leftLess = new int[n];
//        int[] rightLess = new int[n];
//        for (int i = 0; i < n; ++i) {
//            int cur = heights[i];
//            while (!leftLessStack.isEmpty() && heights[leftLessStack.peek()] >= cur) {
//                leftLessStack.pop();
//            }
//            leftLess[i] = leftLessStack.isEmpty() ? -1 : leftLessStack.peek();
//            leftLessStack.push(i);
//        }
//
//        for (int i = n - 1; i >= 0; --i) {
//            int cur = heights[i];
//            while (!rightLessStack.isEmpty() && heights[rightLessStack.peek()] >= cur) {
//                rightLessStack.pop();
//            }
//            rightLess[i] = rightLessStack.isEmpty() ? n : rightLessStack.peek();
//            rightLessStack.push(i);
//        }
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            ans = Math.max(ans, (rightLess[i] - leftLess[i] - 1) * heights[i]);
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
