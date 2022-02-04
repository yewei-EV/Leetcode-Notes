/**
  * 题目Id：81
  * 题目：Search in Rotated Sorted Array II
  * 日期：2022-02-04 16:04:22
*/
//There is an integer array nums sorted in non-decreasing order (not 
//necessarily with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot 
//index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true 
//if target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is guaranteed to be rotated at some pivot. 
// -10⁴ <= target <= 10⁴ 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but 
//nums may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics 数组 二分查找 👍 541 👎 0

package leetcode.editor.cn;
public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return target == nums[0];
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[right] && nums[mid] == nums[left]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
