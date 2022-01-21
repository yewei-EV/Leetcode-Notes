/**
  * 题目Id：645
  * 题目：Set Mismatch
  * 日期：2022-01-15 23:04:09
*/
//You have a set of integers s, which originally contains all the numbers from 1
// to n. Unfortunately, due to some error, one of the numbers in s got duplicated 
//to another number in the set, which results in repetition of one number and 
//loss of another number. 
//
// You are given an integer array nums representing the data status of this set 
//after the error. 
//
// Find the number that occurs twice and the number that is missing and return 
//them in the form of an array. 
//
// 
// Example 1: 
// Input: nums = [1,2,2,4]
//Output: [2,3]
// Example 2: 
// Input: nums = [1,1]
//Output: [1,2]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 位运算 数组 哈希表 排序 👍 247 👎 0

package leetcode.editor.cn;
public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(i, nums[i] - 1, nums);
            }
        }
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }
        return res;

//        int n = nums.length;
//        int[] cnts = new int[n + 1];
//        for (int num : nums) cnts[num]++;
//        int[] ans = new int[2];
//        for (int i = 1; i <= n; ++i) {
//            if (cnts[i] == 0) {
//                ans[1] = i;
//            }
//            if (cnts[i] == 2) {
//                ans[0] = i;
//            }
//        }
//        return ans;
    }
        private void swap(int i, int j, int[] nums) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
