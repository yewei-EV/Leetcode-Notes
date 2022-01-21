/**
  * 题目Id：77
  * 题目：Combinations
  * 日期：2021-12-15 17:09:44
*/
//Given two integers n and k, return all possible combinations of k numbers out 
//of the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 793 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    public void backtracking(int n, int k, List<Integer> ans, List<List<Integer>> result, int start) {
        if (ans.size() == k) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i <= n - (k - ans.size()) + 1; ++i) {
            ans.add(i);
            backtracking(n, k, ans, result, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
