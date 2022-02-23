/**
  * 题目Id：628
  * 题目：Maximum Product of Three Numbers
  * 日期：2022-02-23 21:58:08
*/
//Given an integer array nums, find three numbers whose product is maximum and 
//return the maximum product. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: 6
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: 24
// Example 3: 
// Input: nums = [-1,-2,-3]
//Output: -6
// 
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 排序 👍 355 👎 0

package leetcode.editor.cn;
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
