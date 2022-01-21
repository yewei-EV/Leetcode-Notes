/**
  * 题目Id：47
  * 题目：Permutations II
  * 日期：2021-12-15 17:09:37
*/
//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 887 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, 0);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, int index) {
        // base case
        if (index >= nums.length) {
            List<Integer> ans = new ArrayList<>();
            for(int num: nums) {
                ans.add(num);
            }
            result.add(ans);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; ++i) {
            if (!visited.add(nums[i])) continue;
            switchNums(nums, i, index);
            backtracking(nums, result, index + 1);
            switchNums(nums, index, i);
        }
    }

    public void switchNums(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
