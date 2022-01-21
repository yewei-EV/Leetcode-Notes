/**
  * 题目Id：647
  * 题目：Palindromic Substrings
  * 日期：2022-01-15 14:38:01
*/
//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics 字符串 动态规划 👍 756 👎 0

package leetcode.editor.cn;
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += helper(s, i, i);
             count += helper(s, i, i+1);
        }
        return count;
    }

    public int helper(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            --l;
            ++r;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
