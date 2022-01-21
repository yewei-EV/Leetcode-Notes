/**
  * 题目Id：5
  * 题目：Longest Palindromic Substring
  * 日期：2021-12-21 22:43:21
*/
//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics 字符串 动态规划 👍 4485 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //DP思想
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String max = "";
        for (int i = 0; i < chars.length; ++i) {
            String temp = getLongest(s, i, i+1);
            if (temp.length() > max.length()) {
                max = temp;
            }
            temp = getLongest(s, i, i);
            if (temp.length() > max.length()) {
                max = temp;
            } else if (temp.equals("")) {
                max = s.substring(i, i+1);
            }
        }
        return max;
    }

    public String getLongest(String s, int l, int r) {
        boolean isPalindrome = false;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            isPalindrome = true;
            --l;
            ++r;
        }
        return isPalindrome?s.substring(l+1, r):"";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
