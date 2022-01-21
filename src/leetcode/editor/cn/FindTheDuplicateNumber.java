/**
  * 题目Id：287
  * 题目：Find the Duplicate Number
  * 日期：2022-01-15 23:04:21
*/
//Given an array of integers nums containing n + 1 integers where each integer 
//is in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only 
//constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,2]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer 
//which appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1534 👎 0

package leetcode.editor.cn;
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

//        int slow = 0;
//        int fast = 0;
//        slow = nums[slow];
//        fast = nums[nums[fast]];
//        while(true) {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//            if (slow == fast) break;
//        }
//        int temp = 0;
//        while (temp != slow) {
//            temp = nums[temp];
//            slow = nums[slow];
//        }
//        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
