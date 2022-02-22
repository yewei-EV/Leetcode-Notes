/**
  * 题目Id：503
  * 题目：Next Greater Element II
  * 日期：2022-01-14 16:39:53
*/
//Given a circular integer array nums (i.e., the next element of nums[nums.
//length - 1] is nums[0]), return the next greater number for every element in nums. 
//
// The next greater number of a number x is the first greater number to its 
//traversing-order next in the array, which means you could search circularly to find 
//its next greater number. If it doesn't exist, return -1 for this number. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; 
//The number 2 can't find next greater number. 
//The second 1's next greater number needs to search circularly, which is also 2
//.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,3]
//Output: [2,3,4,-1,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 单调栈 👍 543 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; --i) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
