/**
  * 题目Id：540
  * 题目：Single Element in a Sorted Array
  * 日期：2021-12-08 00:23:00
*/
//You are given a sorted array consisting of only integers where every element 
//appears exactly twice, except for one element which appears exactly once. 
//
// Return the single element that appears only once. 
//
// Your solution must run in O(log n) time and O(1) space. 
//
// 
// Example 1: 
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// Example 2: 
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 296 👎 0

package leetcode.editor.cn;
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int m = left + (right - left)/2;
            if (nums[m] == nums[m-1]) {
                if ((m - left) % 2 == 0) {//若为偶数，则说明左边的存在答案值，改变right的值
                    right = m - 2;
                } else { //若为奇数，则说明右边的存在答案值，改变left的值
                    left = m + 1;
                }
            } else if (nums[m] == nums[m+1]) {
                if ((m - left) % 2 == 0) {
                    left = m + 2;
                } else {
                    right = m - 1;
                }
            } else {
                return nums[m];
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
