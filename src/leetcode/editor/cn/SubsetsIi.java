/**
  * 题目Id：90
  * 题目：Subsets II
  * 日期：2021-12-15 17:10:25
*/
//Given an integer array nums that may contain duplicates, return all possible 
//subsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics 位运算 数组 回溯 👍 704 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<>());
        List<Integer> str = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length+1];
        backtracking(nums, str, 0, visited);
        return result;
    }

    public void backtracking(int[] nums, List<Integer> str, int index, boolean[] visited) {
        for (int i = index; i < nums.length; ++i) {
            if (i >= 1 && !visited[i-1] && nums[i] == nums[i-1]) continue;
            visited[i] = true;
            str.add(nums[i]);
            result.add(new ArrayList<>(str));
            backtracking(nums, str, i + 1, visited);
            str.remove(str.size() - 1);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
