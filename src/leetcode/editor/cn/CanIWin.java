/**
  * 题目Id：464
  * 题目：Can I Win
  * 日期：2021-12-26 15:56:15
*/
//In the "100 game" two players take turns adding, to a running total, any 
//integer from 1 to 10. The player who first causes the running total to reach or 
//exceed 100 wins. 
//
// What if we change the game so that players cannot re-use integers? 
//
// For example, two players might take turns drawing from a common pool of 
//numbers from 1 to 15 without replacement until they reach a total >= 100. 
//
// Given two integers maxChoosableInteger and desiredTotal, return true if the 
//first player to move can force a win, otherwise, return false. Assume both 
//players play optimally. 
//
// 
// Example 1: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 11
//Output: false
//Explanation:
//No matter which integer the first player choose, the first player will lose.
//The first player can choose an integer from 1 up to 10.
//If the first player choose 1, the second player can only choose integers from 
//2 up to 10.
//The second player will win by choosing 10 and get a total = 11, which is >= 
//desiredTotal.
//Same with other integers chosen by the first player, the second player will 
//always win.
// 
//
// Example 2: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 0
//Output: true
// 
//
// Example 3: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= maxChoosableInteger <= 20 
// 0 <= desiredTotal <= 300 
// 
// Related Topics 位运算 记忆化搜索 数学 动态规划 状态压缩 博弈 👍 287 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class CanIWin {
    public static void main(String[] args) {
        Solution solution = new CanIWin().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return dfs(maxChoosableInteger, desiredTotal, 0, map);
    }

    public boolean dfs(int length, int nowTarget, int used, HashMap<Integer, Boolean> map) {
        if(map.containsKey(used)) {
            return map.get(used);
        }
        for(int i = 0; i < length; ++i) {
            int cur = 1 << i;
            if((cur & used) == 0) {
                if(nowTarget <= i + 1 || !dfs(length, nowTarget - i - 1, (used | cur), map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
