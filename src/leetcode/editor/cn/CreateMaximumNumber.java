/**
  * 题目Id：321
  * 题目：Create Maximum Number
  * 日期：2022-02-28 16:15:43
*/
//You are given two integer arrays nums1 and nums2 of lengths m and n 
//respectively. nums1 and nums2 represent the digits of two numbers. You are also given an 
//integer k. 
//
// Create the maximum number of length k <= m + n from digits of the two 
//numbers. The relative order of the digits from the same array must be preserved. 
//
// Return an array of the k digits representing the answer. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
//Output: [9,8,6,5,3]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [6,7], nums2 = [6,0,4], k = 5
//Output: [6,7,6,0,4]
// 
//
// Example 3: 
//
// 
//Input: nums1 = [3,9], nums2 = [8,9], k = 3
//Output: [9,8,9]
// 
//
// 
// Constraints: 
//
// 
// m == nums1.length 
// n == nums2.length 
// 1 <= m, n <= 500 
// 0 <= nums1[i], nums2[i] <= 9 
// 1 <= k <= m + n 
// 
// Related Topics 栈 贪心 单调栈 👍 450 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CreateMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new CreateMaximumNumber().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= n; i++){
            // if k is too small
            if (k - i > m) continue;
            // if k is too big
            if (i > k) break;
            res = max(res, merge(kNum(nums1, i), kNum(nums2, k-i)));
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) { // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }
    public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }

    // find the largest subarray with size k in nums
    public int[] kNum(int[] nums, int k) {
        int[] res = new int[k];
        int r = nums.length - k;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!stack.isEmpty() && stack.peekLast() < cur && r > 0) {
                stack.pollLast();
                r--;
            }
            stack.add(cur);
        }
        while (r > 0) {
            stack.pollLast();
            r--;
        }
        for (int i = 0; i < k; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }

    public int[] max(int[] nums1, int[] nums2){
        int n = nums1.length;
        for (int i = 0; i < n; i++){
            if (nums2[i] > nums1[i]) return nums2;
            if (nums2[i] < nums1[i]) return nums1;
        }
        return nums1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
