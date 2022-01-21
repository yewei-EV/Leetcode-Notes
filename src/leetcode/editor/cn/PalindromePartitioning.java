/**
  * 题目Id：131
  * 题目：Palindrome Partitioning
  * 日期：2021-12-15 17:10:35
*/
//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics 字符串 动态规划 回溯 👍 925 👎 0

package leetcode.editor.cn;

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] valid = new boolean[n][n];
        for (int m = 0; m < n; ++m) {
            for (int k = 0; k < n; ++k) {
                valid[m][k] = true;
            }
        }
        // initialize valid array O(n^2)
        for (int len = 2; len <= n; ++len)  {
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                valid[i][j] = valid[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        backtracking(s, 0, valid, new ArrayList<>());
        return result;
    }

    public void backtracking(String s, int startIndex, boolean[][] valid, List<String> ans) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (valid[startIndex][i]) {
                String sub = s.substring(startIndex, i+1);
                ans.add(sub);
            } else {
                continue;
            }
            backtracking(s, i+1, valid, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
