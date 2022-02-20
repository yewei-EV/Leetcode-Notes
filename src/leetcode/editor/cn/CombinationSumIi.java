/**
  * 题目Id：40
  * 题目：Combination Sum II
  * 日期：2021-12-15 17:09:57
*/
//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 764 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtracking(candidates, target, result, new ArrayList<>(), 0, visited);
        return result;
    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> ans, int index,
                             boolean[] visited) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]) continue;
                if (candidates[i] <= target) {
                    visited[i] = true;
                    ans.add(candidates[i]);
                    backtracking(candidates, target - candidates[i], result, ans, i+1, visited);
                    ans.remove(ans.size() - 1);
                    visited[i] = false;
                } else {
                    break;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
