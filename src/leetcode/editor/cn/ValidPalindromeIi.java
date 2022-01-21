/**
  * 题目Id：680
  * 题目：Valid Palindrome II
  * 日期：2022-01-10 14:54:57
*/
//Given a string s, return true if the s can be palindrome after deleting at 
//most one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
// Related Topics 贪心 双指针 字符串 👍 439 👎 0

package leetcode.editor.cn;
public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i+1, j) || isValid(s, i, j-1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isValid(String s, int l, int r) {
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
