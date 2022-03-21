/**
  * 题目Id：33
  * 题目：Search in Rotated Sorted Array
  * 日期：2022-01-01 20:19:43
*/
//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1750 👎 0

package leetcode.editor.cn;
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                // nums[mid] and target is on the same side
                if (nums[mid] < target) {
                    lo = mid + 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            } else if (target < nums[0]) {
                // nums[mid] and target is on the different side
                // target is on the right side
                // shrink left boundary
                lo = mid + 1;
            } else {
                // nums[mid] and target is on the different side
                // target is on the left side
                // shrink right boundary
                hi = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
