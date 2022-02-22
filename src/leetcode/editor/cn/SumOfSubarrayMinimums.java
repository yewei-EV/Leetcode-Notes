/**
  * 题目Id：907
  * 题目：Sum of Subarray Minimums
  * 日期：2022-02-22 16:09:34
*/
//Given an array of integers arr, find the sum of min(b), where b ranges over 
//every (contiguous) subarray of arr. Since the answer may be large, return the 
//answer modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,1,2,4]
//Output: 17
//Explanation: 
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,
//2,4]. 
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.
// 
//
// Example 2: 
//
// 
//Input: arr = [11,81,94,43,3]
//Output: 444
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
// Related Topics 栈 数组 动态规划 单调栈 👍 314 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] rightLessIndex = new int[n];
        int[] leftLessIndex = new int[n];
        Deque<Integer> rightLessStack = new LinkedList<>();
        Deque<Integer> leftLessStack = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            int cur = arr[i];
            while (!rightLessStack.isEmpty() && cur <= arr[rightLessStack.peek()]) {
                rightLessStack.pop();
            }
            rightLessIndex[i] = rightLessStack.isEmpty() ? n : rightLessStack.peek();
            rightLessStack.push(i);
        }
        for (int i = 0; i < n; ++i) {
            int cur = arr[i];
            while (!leftLessStack.isEmpty() && cur < arr[leftLessStack.peek()]) {
                leftLessStack.pop();
            }
            leftLessIndex[i] = leftLessStack.isEmpty() ? -1 : leftLessStack.peek();
            leftLessStack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (long)(rightLessIndex[i] - i) * (i - leftLessIndex[i]) * arr[i]) % MOD;
        }
        return (int)ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
