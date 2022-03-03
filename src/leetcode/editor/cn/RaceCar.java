/**
  * 题目Id：818
  * 题目：Race Car
  * 日期：2021-12-13 21:54:01
*/
//Your car starts at position 0 and speed +1 on an infinite number line. Your 
//car can go into negative positions. Your car drives automatically according to a 
//sequence of instructions 'A' (accelerate) and 'R' (reverse): 
//
// 
// When you get an instruction 'A', your car does the following:
//
// 
// position += speed 
// speed *= 2 
// 
// 
// When you get an instruction 'R', your car does the following:
// 
// If your speed is positive then speed = -1 
// otherwise speed = 1 
// 
// Your position stays the same. 
// 
//
// For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 -
//-> 3, and your speed goes to 1 --> 2 --> 4 --> -1. 
//
// Given a target position target, return the length of the shortest sequence 
//of instructions to get there. 
//
// 
// Example 1: 
//
// 
//Input: target = 3
//Output: 2
//Explanation: 
//The shortest instruction sequence is "AA".
//Your position goes from 0 --> 1 --> 3.
// 
//
// Example 2: 
//
// 
//Input: target = 6
//Output: 5
//Explanation: 
//The shortest instruction sequence is "AAARA".
//Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁴ 
// 
// Related Topics 动态规划 👍 113 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RaceCar {
    public static void main(String[] args) {
        Solution solution = new RaceCar().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int racecar(int target) {
        //DP
//        if (target <= 0) {
//            return 0;
//        }
//        int[] dp = new int[target + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int i = 1; i <= target; ++i) {
//            // distance can not be as far as 2*target
//            for (int forward = 1; (1 << forward) - 1 < 2 * i; ++forward) {
//                int forwardDistance = (1 << forward) - 1;
//                if (forwardDistance == i) {
//                    //direct reach
//                    dp[i] = forward;
//                } else if (forwardDistance > i) {
//                    //pass and go back
//                    dp[i] = Math.min(forward + dp[forwardDistance - i] + 1, dp[i]);
//                } else {
//                    //forward, go back and forward again
//                    for (int backward = 0; backward < forward; ++backward) {
//                        int backwardDistance = (1 << backward) - 1;
//                        dp[i] = Math.min(forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance], dp[i]);
//                    }
//                }
//            }
//        }
//        return dp[target];
        //BFS
        if (target == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] start = new int[]{0, 1};
        queue.offer(start);
        visited.add(Arrays.toString(start));
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == target) return ans;
                // 加速
                int[] next1 = new int[]{cur[0] + cur[1], cur[1] * 2};
                String state1 = Arrays.toString(next1);
                if (!visited.contains(state1)) {
                    queue.offer(next1);
                    visited.add(state1);
                }
                // 倒车
                int[] next2 = new int[]{cur[0], cur[1] > 0 ? -1 : 1};
                String state2 = Arrays.toString(next2);
                if (next2[0] >= 0 && !visited.contains(state2)) {
                    queue.offer(next2);
                    visited.add(state2);
                }
            }
            ans++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
