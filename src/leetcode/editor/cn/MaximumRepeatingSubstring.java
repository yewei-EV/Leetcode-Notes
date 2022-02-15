/**
  * 题目Id：1668
  * 题目：Maximum Repeating Substring
  * 日期：2022-02-15 16:45:29
*/
//For a string sequence, a string word is k-repeating if word concatenated k 
//times is a substring of sequence. The word's maximum k-repeating value is the 
//highest value k where word is k-repeating in sequence. If word is not a substring of 
//sequence, word's maximum k-repeating value is 0. 
//
// Given strings sequence and word, return the maximum k-repeating value of 
//word in sequence. 
//
// 
// Example 1: 
//
// 
//Input: sequence = "ababc", word = "ab"
//Output: 2
//Explanation: "abab" is a substring in "ababc".
// 
//
// Example 2: 
//
// 
//Input: sequence = "ababc", word = "ba"
//Output: 1
//Explanation: "ba" is a substring in "ababc". "baba" is not a substring in 
//"ababc".
// 
//
// Example 3: 
//
// 
//Input: sequence = "ababc", word = "ac"
//Output: 0
//Explanation: "ac" is not a substring in "ababc". 
// 
//
// 
// Constraints: 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence and word contains only lowercase English letters. 
// 
// Related Topics 字符串 字符串匹配 👍 20 👎 0

package leetcode.editor.cn;
public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new MaximumRepeatingSubstring().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRepeating(String sequence, String word) {
        char[] chars = sequence.toCharArray();
        int max = 0;
        for (int i = 0; i <= chars.length - word.length(); ++i) {
            int j = 0;
            while (i + j < chars.length) {
                if (chars[i + j] == word.charAt(j % word.length())) {
                    j++;
                } else {
                    break;
                }
            }
            max = Math.max(j / word.length(), max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
