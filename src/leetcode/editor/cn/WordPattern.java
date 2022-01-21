/**
  * 题目Id：290
  * 题目：Word Pattern
  * 日期：2022-01-15 16:09:09
*/
//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
// Related Topics 哈希表 字符串 👍 421 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) {
            return false;
        }
        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            Character c = pattern.charAt(i);
            String string = ss[i];
            if (cMap.containsKey(c) && !cMap.get(c).equals(string)) {
                return false;
            } else {
                cMap.put(c, string);
            }
            if (sMap.containsKey(string) && !sMap.get(string).equals(c)) {
                return false;
            } else {
                sMap.put(string, c);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
