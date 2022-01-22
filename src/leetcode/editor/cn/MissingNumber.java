/**
  * 题目Id：268
  * 题目：Missing Number
  * 日期：2022-01-22 23:52:24
*/
//Given an array nums containing n distinct numbers in the range [0, n], return 
//the only number in the range that is missing from the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range 
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range 
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range 
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// 0 <= nums[i] <= n 
// All the numbers of nums are unique. 
// 
//
// 
// Follow up: Could you implement a solution using only O(1) extra space 
//complexity and O(n) runtime complexity? 
// Related Topics 位运算 数组 哈希表 数学 排序 👍 556 👎 0

package leetcode.editor.cn;
public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
