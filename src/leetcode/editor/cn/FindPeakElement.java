/**
  * 题目Id：162
  * 题目：Find Peak Element
  * 日期：2022-02-16 23:56:08
*/
//A peak element is an element that is strictly greater than its neighbors. 
//
// Given an integer array nums, find a peak element, and return its index. If 
//the array contains multiple peaks, return the index to any of the peaks. 
//
// You may imagine that nums[-1] = nums[n] = -∞. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index 
//number 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak 
//element is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
// Related Topics 数组 二分查找 👍 714 👎 0

package leetcode.editor.cn;
public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > nums[i+1]) {
                    return i;
                }
            } else if (i == n - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i - 1] < nums[i] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
