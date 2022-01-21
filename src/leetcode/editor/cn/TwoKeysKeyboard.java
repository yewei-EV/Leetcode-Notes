/**
  * 题目Id：650
  * 题目：2 Keys Keyboard
  * 日期：2021-12-25 22:14:25
*/
//There is only one character 'A' on the screen of a notepad. You can perform 
//two operations on this notepad for each step: 
//
// 
// Copy All: You can copy all the characters present on the screen (a partial 
//copy is not allowed). 
// Paste: You can paste the characters which are copied last time. 
// 
//
// Given an integer n, return the minimum number of operations to get the 
//character 'A' exactly n times on the screen. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 👍 432 👎 0

package leetcode.editor.cn;
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new TwoKeysKeyboard().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int result = Integer.MAX_VALUE;

    public int minSteps(int n) {
        if(n <= 1) {
            return 0;
        }
        // must copy one time first!
        dfs(n, 1, 1, 1);
        return result;
    }

    public void dfs(int n, int cur, int clipboard, int count) {
        if(cur > n) {
            return;
        }
        if(cur == n) {
            result = Math.min(count, result);
            return;
        }
        // paste
        if (clipboard <= (n - cur)) {
            dfs(n, cur + clipboard, clipboard, count + 1);
        }
        // copy and paste
        dfs(n, cur * 2, cur, count + 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
