/**
  * 题目Id：667
  * 题目：Beautiful Arrangement II
  * 日期：2022-01-16 14:54:51
*/
//Given two integers n and k, construct a list answer that contains n different 
//positive integers ranging from 1 to n and obeys the following requirement: 
//
// 
// Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2
//|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers. 
// 
//
// Return the list answer. If there multiple valid answers, return any of them. 
//
//
// 
// Example 1: 
//
// 
//Input: n = 3, k = 1
//Output: [1,2,3]
//Explanation: The [1,2,3] has three different positive integers ranging from 1 
//to 3, and the [1,1] has exactly 1 distinct integer: 1
// 
//
// Example 2: 
//
// 
//Input: n = 3, k = 2
//Output: [1,3,2]
//Explanation: The [1,3,2] has three different positive integers ranging from 1 
//to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k < n <= 10⁴ 
// 
// Related Topics 数组 数学 👍 102 👎 0

package leetcode.editor.cn;
public class BeautifulArrangementIi {
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangementIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        // 第 1 步：构造等差数列，把 1 到 n - k - 1 赋值结果数组的前面
        for (int i = 0; i < n - k - 1; i++) {
            res[i] = i + 1;
        }

        // 第 2 步：构造交错数列，下标从 n - k - 1 开始，数值从 n - k 开始
        // 控制交错的变量
        int j = 0;

        int left = n - k;
        int right = n;
        for (int i = n - k - 1; i < n; i++) {
            if (j % 2 == 0) {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
