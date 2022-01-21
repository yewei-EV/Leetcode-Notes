/**
  * 题目Id：42
  * 题目：Trapping Rain Water
  * 日期：2021-12-14 17:18:10
*/
//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2934 👎 0

package leetcode.editor.cn;
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                l[i] = height[0];
            } else {
                l[i] = Math.max(l[i - 1], height[i]);
            }
        }
        for (int i = n-1; i >= 0; --i) {
            if (i == n-1) {
                r[i] = height[n-1];
            } else {
                r[i] = Math.max(r[i+1], height[i]);
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            ans += Math.min(r[j], l[j]) - height[j];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
