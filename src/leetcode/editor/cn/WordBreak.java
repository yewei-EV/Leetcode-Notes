/**
  * 题目Id：139
  * 题目：Word Break
  * 日期：2021-12-23 21:19:05
*/
//Given a string s and a dictionary of strings wordDict, return true if s can 
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1300 👎 0

package leetcode.editor.cn;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//        Map<Integer, Boolean> memo = new HashMap<>();
//        return helper(set, s, 0, memo);
        //DP
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 1; i <= m; i++) {
            for (String word: wordDict) {
                if (i >= word.length()
                        && word.equals(s.substring(i - word.length(), i))
                        && dp[i - word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[m];
    }

//    public boolean helper(Set<String> set, String s, int index, Map<Integer, Boolean> memo) {
//        if (index >= s.length()) return true;
//        if (memo.containsKey(index)) return memo.get(index);
//        for (int i = index + 1; i <= s.length(); i++) {
//            String word = s.substring(index, i);
//            if (set.contains(word) && helper(set, s, i, memo)) {
//                memo.put(index, true);
//                return true;
//            }
//        }
//        memo.put(index, false);
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
