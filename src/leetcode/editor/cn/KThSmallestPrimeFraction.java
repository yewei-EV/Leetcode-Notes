/**
  * 题目Id：786
  * 题目：K-th Smallest Prime Fraction
  * 日期：2022-01-02 19:18:57
*/
//You are given a sorted integer array arr containing 1 and prime numbers, 
//where all the integers of arr are unique. You are also given an integer k. 
//
// For every i and j where 0 <= i < j < arr.length, we consider the fraction 
//arr[i] / arr[j]. 
//
// Return the kᵗʰ smallest fraction considered. Return your answer as an array 
//of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j]. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,5], k = 3
//Output: [2,5]
//Explanation: The fractions to be considered in sorted order are:
//1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
//The third fraction is 2/5.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,7], k = 1
//Output: [1,7]
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] is a prime number for i > 0. 
// All the numbers of arr are unique and sorted in strictly increasing order. 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// Related Topics 数组 二分查找 堆（优先队列） 👍 197 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->Double.compare(b[0]*1.0/b[1], a[0]*1.0/a[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (q.size() < k || q.peek()[0] * 1.0 / q.peek()[1] > t) {
                    if (q.size() == k) q.poll();
                    q.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return q.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
