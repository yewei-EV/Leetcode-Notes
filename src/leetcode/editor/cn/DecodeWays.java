/**
  * 题目Id：91
  * 题目：Decode Ways
  * 日期：2021-12-23 14:39:34
*/
//A message containing letters from A-Z can be encoded into numbers using the 
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics 字符串 动态规划 👍 1031 👎 0

package leetcode.editor.cn;
public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()+1];
        return helper(s, s.length(), memo);
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int n = s.length();
//        int[] dp = new int[n+1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) == '0' ? 0 : 1;
//        for (int i = 2; i <= n; i++) {
//            if (s.charAt(i-1) != '0') {
//                dp[i] += dp[i - 1];
//            }
//            if (s.charAt(i-2) - '0' <= 2 && s.charAt(i-2) != '0') {
//                if (s.charAt(i-2) == '2' && s.charAt(i-1) - '0' > 6) {
//                    continue;
//                }
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[n];
    }

    public int helper(String s, int len, int[] memo) {
        int n = s.length();
        if (len <= 0) {
            return 1;
        }
        int k = n - len;
        if (s.charAt(k) == '0') {
            return 0;
        }
        if (memo[len] != 0) {
            return memo[len];
        }
        int result = helper(s, len - 1, memo);
        if (len >= 2 && Integer.parseInt(s.substring(k, k + 2)) <= 26) {
            result += helper(s, len - 2, memo);
        }
        memo[len] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
