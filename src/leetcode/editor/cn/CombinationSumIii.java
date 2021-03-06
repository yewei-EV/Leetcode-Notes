/**
  * 题目Id：216
  * 题目：Combination Sum III
  * 日期：2021-12-15 17:10:14
*/
//Find all valid combinations of k numbers that sum up to n such that the 
//following conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain 
//the same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// Example 4: 
//
// 
//Input: k = 3, n = 2
//Output: []
//Explanation: There are no valid combinations.
// 
//
// Example 5: 
//
// 
//Input: k = 9, n = 45
//Output: [[1,2,3,4,5,6,7,8,9]]
//Explanation:
//1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
//There are no other valid combinations.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics 数组 回溯 👍 397 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, k, n, result, new ArrayList<>());
        return result;
    }

    public void backtracking(int index, int k, int target, List<List<Integer>> result, List<Integer> ans) {
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (i <= target) {
                ans.add(i);
                backtracking(i + 1, k - 1, target - i, result, ans);
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
