/**
  * 题目Id：403
  * 题目：Frog Jump
  * 日期：2022-03-01 18:11:43
*/
//A frog is crossing a river. The river is divided into some number of units, 
//and at each unit, there may or may not exist a stone. The frog can jump on a 
//stone, but it must not jump into the water. 
//
// Given a list of stones' positions (in units) in sorted ascending order, 
//determine if the frog can cross the river by landing on the last stone. Initially, 
//the frog is on the first stone and assumes the first jump must be 1 unit. 
//
// If the frog's last jump was k units, its next jump must be either k - 1, k, 
//or k + 1 units. The frog can only jump in the forward direction. 
//
// 
// Example 1: 
//
// 
//Input: stones = [0,1,3,5,6,8,12,17]
//Output: true
//Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd 
//stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 
//units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [0,1,2,3,4,8,9,11]
//Output: false
//Explanation: There is no way to jump to the last stone as the gap between the 
//5th and 6th stone is too large.
// 
//
// 
// Constraints: 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 2³¹ - 1 
// stones[0] == 0 
// stones is sorted in a strictly increasing order. 
// 
// Related Topics 数组 动态规划 👍 407 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        Solution solution = new FrogJump().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(stones, 0, 0, memo);
    }

    public boolean dfs(int[] stones, int position, int k, int[][] memo) {
        if (position == stones.length - 1) {
            return true;
        }
        if (memo[k][position] != -1) {
            return memo[k][position] == 1;
        }
        for (int i = position + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[position];
            if (gap > k + 1) {
                break;
            }
            if (gap >= k - 1 && gap <= k + 1) {
                if (dfs(stones, i, gap, memo)) {
                    memo[k][position] = 1;
                    return true;
                }
            }
        }
        memo[k][position] = 0;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
