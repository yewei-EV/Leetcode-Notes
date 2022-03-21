/**
  * 题目Id：409
  * 题目：Longest Palindrome
  * 日期：2022-01-15 14:37:43
*/
//Given a string s which consists of lowercase or uppercase letters, return the 
//length of the longest palindrome that can be built with those letters. 
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome 
//here. 
//
// 
// Example 1: 
//
// 
//Input: s = "abccccdd"
//Output: 7
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: s = "bb"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
// Related Topics 贪心 哈希表 字符串 👍 371 👎 0

package leetcode.editor.cn;
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        boolean flag = true;
        for (int c : count) {
            if (c % 2 == 0) {
                ans += c;
            } else {
                //only can happen once
                if (flag) {
                    ans += c;
                    flag = false;
                } else {
                    // transfer to even
                    ans += c / 2 * 2;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
