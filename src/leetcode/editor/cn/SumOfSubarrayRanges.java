/**
  * 题目Id：2104
  * 题目：Sum of Subarray Ranges
  * 日期：2022-02-22 18:37:41
*/
//You are given an integer array nums. The range of a subarray of nums is the 
//difference between the largest and smallest element in the subarray. 
//
// Return the sum of all subarray ranges of nums. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0 
//[2], range = 2 - 2 = 0
//[3], range = 3 - 3 = 0
//[1,2], range = 2 - 1 = 1
//[2,3], range = 3 - 2 = 1
//[1,2,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4. 
//
// Example 2: 
//
// 
//Input: nums = [1,3,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0
//[3], range = 3 - 3 = 0
//[3], range = 3 - 3 = 0
//[1,3], range = 3 - 1 = 2
//[3,3], range = 3 - 3 = 0
//[1,3,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [4,-2,-3,4,1]
//Output: 59
//Explanation: The sum of all subarray ranges of nums is 59.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
// Follow-up: Could you find a solution with O(n) time complexity? 
// Related Topics 栈 数组 单调栈 👍 18 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayRanges().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] leftGreaterIndex = new int[n];
        int[] rightGreaterIndex = new int[n];
        int[] leftLessIndex = new int[n];
        int[] rightLessIndex = new int[n];
        Deque<Integer> leftMaxStack = new LinkedList<>();
        Deque<Integer> rightMaxStack = new LinkedList<>();
        Deque<Integer> leftMinStack = new LinkedList<>();
        Deque<Integer> rightMinStack = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            // find the greater num on the right-hand side
            int cur = nums[i];
            while (!rightMaxStack.isEmpty() && cur >= nums[rightMaxStack.peek()]) {
                rightMaxStack.pop();
            }
            rightGreaterIndex[i] = rightMaxStack.isEmpty() ? n : rightMaxStack.peek();
            rightMaxStack.push(i);

            // find the less num on the right-hand side
            while (!rightMinStack.isEmpty() && cur <= nums[rightMinStack.peek()]) {
                rightMinStack.pop();
            }
            rightLessIndex[i] = rightMinStack.isEmpty() ? n : rightMinStack.peek();
            rightMinStack.push(i);
        }

        for (int i = 0; i < n; ++i) {
            int cur = nums[i];
            // find the greater num on the left-hand side
            while (!leftMaxStack.isEmpty() && cur > nums[leftMaxStack.peek()]) {
                leftMaxStack.pop();
            }
            leftGreaterIndex[i] = leftMaxStack.isEmpty() ? -1 : leftMaxStack.peek();
            leftMaxStack.push(i);

            // find the less num on the left-hand side
            while (!leftMinStack.isEmpty() && cur < nums[leftMinStack.peek()]) {
                leftMinStack.pop();
            }
            leftLessIndex[i] = leftMinStack.isEmpty() ? -1 : leftMinStack.peek();
            leftMinStack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - leftGreaterIndex[i]) * (rightGreaterIndex[i] - i) * nums[i]
                    - (long) (i - leftLessIndex[i]) * (rightLessIndex[i] - i) * nums[i];
        }
        return ans;


//        int n = nums.length;
//        long ans = 0;
//        int max, min;
//        for (int i = 0; i < n - 1; ++i) {
//            max = nums[i];
//            min = nums[i];
//            for (int j = i + 1; j < n; j++) {
//                max = Math.max(max, nums[j]);
//                min = Math.min(min, nums[j]);
//                ans += (max - min);
//            }
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
