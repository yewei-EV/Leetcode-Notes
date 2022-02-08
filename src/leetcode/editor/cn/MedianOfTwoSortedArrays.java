/**
  * 题目Id：4
  * 题目：Median of Two Sorted Arrays
  * 日期：2022-02-08 17:25:19
*/
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4957 👎 0

package leetcode.editor.cn;
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int a = 0, b = 0;
        int left = -1, right = -1;
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (a == m) {
                right = nums2[b++];
                continue;
            }
            if (b == n) {
                right = nums1[a++];
                continue;
            }
            if (nums1[a] >= nums2[b]) {
                right = nums2[b++];
            } else {
                right = nums1[a++];
            }
        }
        if (len % 2 == 0) {
            return (right + left) / 2.0;
        } else {
            return right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
