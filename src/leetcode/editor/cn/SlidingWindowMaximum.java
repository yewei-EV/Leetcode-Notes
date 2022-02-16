/**
  * 题目Id：239
  * 题目：Sliding Window Maximum
  * 日期：2022-02-16 00:39:47
*/
//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1399 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) ->
                p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1]);
        for (int i = 0; i < k; ++i) {
            queue.offer(new int[]{nums[i], i});
        }
        int [] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; ++i) {
            queue.offer(new int[]{nums[i], i});
            // find a max element whose index is in range
            while (queue.peek()[1] + k <= i) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
