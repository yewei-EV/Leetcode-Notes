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

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        rightBoundary[n - 1] = n;
        leftBoundary[0] = -1;
        for (int i = 1; i < n; ++i) {
            int cur = i - 1;
            while (cur >= 0 && heights[i] <= heights[cur]) {
                cur = leftBoundary[cur];
            }
            leftBoundary[i] = cur;
        }
        for (int i = n - 2; i >= 0; --i) {
            int cur = i + 1;
            while (cur < n && heights[i] <= heights[cur]) {
                cur = rightBoundary[cur];
            }
            rightBoundary[i] = cur;
        }

        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max,
                    (rightBoundary[i] - leftBoundary[i] - 1) * heights[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
