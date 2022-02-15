/**
  * 题目Id：801
  * 题目：Minimum Swaps To Make Sequences Increasing
  * 日期：2022-02-15 15:52:38
*/
//You are given two integer arrays of the same length nums1 and nums2. In one 
//operation, you are allowed to swap nums1[i] with nums2[i]. 
//
// 
// For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the 
//element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8]. 
// 
//
// Return the minimum number of needed operations to make nums1 and nums2 
//strictly increasing. The test cases are generated so that the given input always 
//makes it possible. 
//
// An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] <
// ... < arr[arr.length - 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//Output: 1
//Explanation: 
//Swap nums1[3] and nums2[3]. Then the sequences are:
//nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
//which are both strictly increasing.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 2 * 10⁵ 
// 
// Related Topics 数组 动态规划 👍 224 👎 0

package leetcode.editor.cn;
public class MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToMakeSequencesIncreasing().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; ++i) {
            // can not swap, if the last element swap, need one step to swap back
            if ((nums1[i-1] < nums1[i] && nums2[i-1] < nums2[i])
                    && !(nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i])) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            // must swap
            } else if (!(nums1[i-1] < nums1[i] && nums2[i-1] < nums2[i])
                    && (nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i])) {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            } else {
                // can swap or not swap, both correct
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = dp[i][0] + 1;
            }
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
