/**
  * 题目Id：75
  * 题目：Sort Colors
  * 日期：2021-12-06 14:59:35
*/
//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
// Related Topics 数组 双指针 排序 👍 1098 👎 0

package leetcode.editor.cn;
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == 0) {
                swap(nums, l, zero);
                ++zero;
                ++l;
            } else if (nums[l] == 2) {
                swap(nums, r, l);
                --r;
            } else {
                ++l;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
