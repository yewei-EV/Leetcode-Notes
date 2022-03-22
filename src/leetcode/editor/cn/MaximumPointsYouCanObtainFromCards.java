/**
  * 题目Id：1423
  * 题目：Maximum Points You Can Obtain from Cards
  * 日期：2022-03-19 16:53:24
*/
//There are several cards arranged in a row, and each card has an associated 
//number of points. The points are given in the integer array cardPoints. 
//
// In one step, you can take one card from the beginning or from the end of the 
//row. You have to take exactly k cards. 
//
// Your score is the sum of the points of the cards you have taken. 
//
// Given the integer array cardPoints and the integer k, return the maximum 
//score you can obtain. 
//
// 
// Example 1: 
//
// 
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Explanation: After the first step, your score will always be 1. However, 
//choosing the rightmost card first will maximize your total score. The optimal 
//strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
//2.
// 
//
// Example 2: 
//
// 
//Input: cardPoints = [2,2,2], k = 2
//Output: 4
//Explanation: Regardless of which two cards you take, your score will always 
//be 4.
// 
//
// Example 3: 
//
// 
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55
//Explanation: You have to take all the cards. Your score is the sum of points 
//of all cards.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cardPoints.length <= 10⁵ 
// 1 <= cardPoints[i] <= 10⁴ 
// 1 <= k <= cardPoints.length 
// 
// Related Topics 数组 前缀和 滑动窗口 👍 215 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = cardPoints.length - k;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + cardPoints[i - 1];
        }
        for (int start = 0; start <= k; start++) {
            // use prefixSum to find sum between start and (start + windowSize)
            sum = prefix[start + windowSize] - prefix[start];
            min = Math.min(min, sum);
        }
        return prefix[n] - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
