/**
  * 题目Id：1470
  * 题目：Shuffle the Array
  * 日期：2022-01-16 19:36:25
*/
//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2
//,...,yn]. 
//
// Return the array in the form [x1,y1,x2,y2,...,xn,yn]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,5,1,3,4,7], n = 3
//Output: [2,3,5,4,1,7] 
//Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,
//5,4,1,7].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,4,3,2,1], n = 4
//Output: [1,4,2,3,3,2,4,1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,2,2], n = 2
//Output: [1,2,1,2]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 500 
// nums.length == 2n 
// 1 <= nums[i] <= 10^3 
// Related Topics 数组 👍 71 👎 0

package leetcode.editor.cn;
public class ShuffleTheArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i ++)
            if (nums[i] > 0){
                // j 描述当前的 nums[i] 对应的索引，初始为 i
                int j = i;
                while (nums[i] > 0){
                    // 计算 j 索引的元素，也就是现在的 nums[i]，应该放置的索引
                    j = findCorrectIndex(j, n);
                    // 把 nums[i] 放置到 j 的位置，
                    // 同时，把 nums[j] 放到 i 的位置，在下一轮循环继续处理
                    swap(nums, i, j);
                    // 使用负号标记上，现在 j 位置存储的元素已经是正确的元素了
                    nums[j] = -nums[j];
                }
            }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = -nums[i];
        }
        return nums;
    }

    public int findCorrectIndex(int j, int n) {
        return j < n ? 2 * j : 2 * (j - n) + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
