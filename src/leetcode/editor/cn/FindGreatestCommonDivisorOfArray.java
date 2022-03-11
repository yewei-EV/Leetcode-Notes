/**
  * 题目Id：1979
  * 题目：Find Greatest Common Divisor of Array
  * 日期：2022-03-10 09:34:01
*/
//Given an integer array nums, return the greatest common divisor of the 
//smallest number and largest number in nums. 
//
// The greatest common divisor of two numbers is the largest positive integer 
//that evenly divides both numbers. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,5,6,9,10]
//Output: 2
//Explanation:
//The smallest number in nums is 2.
//The largest number in nums is 10.
//The greatest common divisor of 2 and 10 is 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [7,5,6,8,3]
//Output: 1
//Explanation:
//The smallest number in nums is 3.
//The largest number in nums is 8.
//The greatest common divisor of 3 and 8 is 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3]
//Output: 3
//Explanation:
//The smallest number in nums is 3.
//The largest number in nums is 3.
//The greatest common divisor of 3 and 3 is 3.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 数论 👍 16 👎 0

package leetcode.editor.cn;
public class FindGreatestCommonDivisorOfArray {
    public static void main(String[] args) {
        Solution solution = new FindGreatestCommonDivisorOfArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        return gcd(min, max);
    }

    public int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
