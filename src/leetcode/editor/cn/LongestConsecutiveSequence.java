/**
  * 题目Id：128
  * 题目：Longest Consecutive Sequence
  * 日期：2022-01-14 18:56:41
*/
//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1048 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        //Method 1
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, num);
//        }
//        int ans = 0;
//        for (int num : nums) {
//            int right = map.get(num);
//            // 遍历得到最远的右边界
//            while (map.containsKey(right + 1)) {
//                right = map.get(right + 1);
//            }
//            // 更新右边界
//            map.put(num, right);
//            // 更新答案
//            ans = Math.max(ans, right - num + 1);
//        }
//        return ans;

        //Method 2 Faster
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
