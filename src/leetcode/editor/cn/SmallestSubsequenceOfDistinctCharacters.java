/**
  * 题目Id：1081
  * 题目：Smallest Subsequence of Distinct Characters
  * 日期：2022-02-28 16:16:09
*/
//Given a string s, return the lexicographically smallest subsequence of s that 
//contains all the distinct characters of s exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
//
// 
//Note: This question is the same as 316: https://leetcode.com/problems/remove-
//duplicate-letters/ Related Topics 栈 贪心 字符串 单调栈 👍 135 👎 0

package leetcode.editor.cn;
public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!visited[cur - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > cur) {
                    // check if there is more cur
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                sb.append(cur);
                visited[cur - 'a'] = true;
            }
            num[cur - 'a'] -= 1;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
