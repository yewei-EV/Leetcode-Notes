/**
  * 题目Id：852
  * 题目：Peak Index in a Mountain Array
  * 日期：2022-03-02 18:57:08
*/
//Let's call an array arr a mountain if the following properties hold: 
//
// 
// arr.length >= 3 
// There exists some i with 0 < i < arr.length - 1 such that:
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// Given an integer array arr that is guaranteed to be a mountain, return any i 
//such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[
//arr.length - 1]. 
//
// 
// Example 1: 
//
// 
//Input: arr = [0,1,0]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: arr = [0,2,1,0]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: arr = [0,10,5,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁶ 
// arr is guaranteed to be a mountain array. 
// 
//
// 
//Follow up: Finding the O(n) is straightforward, could you find an O(log(n)) 
//solution? Related Topics 数组 二分查找 👍 232 👎 0

package leetcode.editor.cn;
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
