/**
  * 题目Id：887
  * 题目：Super Egg Drop
  * 日期：2021-12-20 23:48:07
*/
//You are given k identical eggs and you have access to a building with n 
//floors labeled from 1 to n. 
//
// You know that there exists a floor f where 0 <= f <= n such that any egg 
//dropped at a floor higher than f will break, and any egg dropped at or below floor 
//f will not break. 
//
// Each move, you may take an unbroken egg and drop it from any floor x (where 1
// <= x <= n). If the egg breaks, you can no longer use it. However, if the egg 
//does not break, you may reuse it in future moves. 
//
// Return the minimum number of moves that you need to determine with certainty 
//what the value of f is. 
//
// 
// Example 1: 
//
// 
//Input: k = 1, n = 2
//Output: 2
//Explanation: 
//Drop the egg from floor 1. If it breaks, we know that f = 0.
//Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
//If it does not break, then we know f = 2.
//Hence, we need at minimum 2 moves to determine with certainty what the value 
//of f is.
// 
//
// Example 2: 
//
// 
//Input: k = 2, n = 6
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: k = 3, n = 14
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 100 
// 1 <= n <= 10⁴ 
// 
// Related Topics 数学 二分查找 动态规划 👍 725 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new SuperEggDrop().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int superEggDrop(int K, int N) {

            // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少实验的次数
            // 注意：
            // 1、i 表示的是楼层的大小，不是第几层的意思，例如楼层区间 [8, 9, 10] 的大小为 3，这一点是在状态转移的过程中调整的定义
            // 2、j 表示可以使用的鸡蛋的个数，它是约束条件，我个人习惯放在后面的维度，表示消除后效性的意思

            // 0 个楼层和 0 个鸡蛋的情况都需要算上去，虽然没有实际的意义，但是作为递推的起点，被其它状态值所参考
            int[][] dp = new int[N + 1][K + 1];

            // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
            // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
            for (int j = 0; j <= K; j++) {
                dp[0][j] = 0;
            }

            // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
            dp[1][0] = 0;
            for (int j = 1; j <= K; j++) {
                dp[1][j] = 1;
            }

            // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
            // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
            for (int i = 0; i <= N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            for (int i = 2; i <= N; i++) { // 当前有 n 个楼层
                for (int j = 2; j <= K; j++) { // 当前手里有 k 个鸡蛋
                    dp[i][j] = i;
                }
            }

            // 从第 2 行，第 2 列开始填表
            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    int left = 1;
                    int right = i;
                    while (left <= right) {
                        int mid = left + (right - left)/2;
                        int leftVal = dp[mid - 1][j - 1];
                        int rightVal = dp[i - mid][j];
                        if (leftVal == rightVal) {
                            right = mid;
                            break;
                        } else if (leftVal < rightVal) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[right - 1][j - 1], dp[i - right][j]) + 1);
                }
            }
            return dp[N][K];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
