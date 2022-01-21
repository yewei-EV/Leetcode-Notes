/**
  * 题目Id：46
  * 题目：Permutations
  * 日期：2021-12-15 17:05:57
*/
//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics 数组 回溯 👍 1686 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(result, nums, 0);
            return  result;
        }

        public void dfs(List<List<Integer>> result, int[] nums, int index) {
            //base case
            if (index >= nums.length) {
                List<Integer> answer = new ArrayList<>();
                for (int num : nums) {
                    answer.add(num);
                }
                result.add(answer);
            }

            for (int i = index; i < nums.length; i++) {
                switchNums(nums, index, i);
                dfs(result, nums, index + 1);
                switchNums(nums, i, index);
            }
        }

        public void switchNums(int[] nums, int i1, int i2) {
            int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }

        //    //solution 2
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> container = new ArrayList<>();
//        dfs(result, nums, container);
//        return result;
//    }
//
//    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> container) {
//        //base case
//        if (container.size() == nums.length) {
//            result.add(new ArrayList<>(container));
//            return;
//        }
//
//        for (int num : nums) {
//            if (!container.contains(num)) {
//                container.add(num);
//                dfs(result, nums, container);
//                container.remove(container.size() - 1);
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
