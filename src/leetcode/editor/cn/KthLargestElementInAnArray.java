/**
  * 题目Id：215
  * 题目：Kth Largest Element in an Array
  * 日期：2021-12-06 11:33:43
*/
//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1404 👎 0

package leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        quickSort(0, nums.length - 1, nums);
        return nums[nums.length - k];
    }

    public void quickSort(int l, int r, int[] nums) {
        if (l > r) {
            return;
        }
        int p = partition(l, r, nums);
        quickSort(l, p-1, nums);
        quickSort(p+1, r, nums);
    }

    public int partition(int l, int r, int[] nums) {
        if (l < r) {
            int index = random.nextInt(r - l) + l;
            swap(nums, l, index);
        }

        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) {
                --r;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] < temp) {
                ++l;
            }
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
