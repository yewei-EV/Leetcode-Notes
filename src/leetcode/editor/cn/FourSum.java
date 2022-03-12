/**
  * 题目Id：18
  * 题目：4Sum
  * 日期：2022-03-11 04:16:32
*/
//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1153 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(nums, target, 0, 0, temp);
        return res;
    }

    public void helper(int[] nums, int target, int index, int depth, List<Integer> temp) {
        if (depth == 4 && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (depth >= 4) {
            return;
        } else {
            int n = nums.length;
            while (index < n - 3 + depth) {
                // pruning
                if (depth == 0 && ((long)nums[index] + (long)nums[index + 1] + (long)nums[index + 2] + (long)nums[index + 3]) > target) {
                    return;
                }
                // nums[index] is too small
                if (depth == 0 && ((long)nums[index] + (long)nums[n - 3] + (long)nums[n - 2] + (long)nums[n - 1]) < target) {
                    index++;
                    continue;
                }
                temp.add(nums[index]);
                helper(nums, target - nums[index], index + 1, depth + 1, temp);
                temp.remove(temp.size() - 1);
                // remove duplicate elements
                int cur = nums[index];
                while (index < n - 3 + depth && cur == nums[index]) {
                    index++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
