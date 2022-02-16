/**
  * 题目Id：1818
  * 题目：Minimum Absolute Sum Difference
  * 日期：2022-02-16 00:42:24
*/
//You are given two positive integer arrays nums1 and nums2, both of length n. 
//
// The absolute sum difference of arrays nums1 and nums2 is defined as the sum 
//of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed). 
//
// You can replace at most one element of nums1 with any other element in nums1 
//to minimize the absolute sum difference. 
//
// Return the minimum absolute sum difference after replacing at most one 
//element in the array nums1. Since the answer may be large, return it modulo 10⁹ + 7. 
//
// |x| is defined as: 
//
// 
// x if x >= 0, or 
// -x if x < 0. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,7,5], nums2 = [2,3,5]
//Output: 3
//Explanation: There are two possible optimal solutions:
//- Replace the second element with the first: [1,7,5] => [1,1,5], or
//- Replace the second element with the third: [1,7,5] => [1,5,5].
//Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5|
// = 3.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//Output: 0
//Explanation: nums1 is equal to nums2 so no replacement is needed. This will 
//result in an 
//absolute sum difference of 0.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//Output: 20
//Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,
//10,4,4,2,7].
//This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2
//-7| + |7-4| = 20
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 有序集合 排序 👍 116 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int)1e9+7;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0;
        long diff = 0;
        for (int i = 0; i < n; ++i) {
            int a = nums1[i], b = nums2[i];
            if (a == b) continue;
            int x = Math.abs(a-b);
            sum += x;
            //binary search in sorted, to find the min abs
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sorted[mid] <= b) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int newDiff = Math.abs(sorted[r] - b);
            if (r + 1 < n) {
                newDiff = Math.min(newDiff, Math.abs(sorted[r+1] - b));
            }
            if (newDiff < x) {
                diff = Math.max(diff, x - newDiff);
            }
        }
        return (int)((sum - diff) % mod);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
