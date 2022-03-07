/**
  * 题目Id：828
  * 题目：Count Unique Characters of All Substrings of a Given String
  * 日期：2022-03-01 21:07:40
*/
//Let's define a function countUniqueChars(s) that returns the number of unique 
//characters on s. 
//
// 
// For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", 
//"C", "O", "D" are the unique characters since they appear only once in s, 
//therefore countUniqueChars(s) = 5. 
// 
//
// Given a string s, return the sum of countUniqueChars(t) where t is a 
//substring of s. 
//
// Notice that some substrings can be repeated so in this case you have to 
//count the repeated ones too. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABC"
//Output: 10
//Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
//Evey substring is composed with only unique letters.
//Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
// 
//
// Example 2: 
//
// 
//Input: s = "ABA"
//Output: 8
//Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
// 
//
// Example 3: 
//
// 
//Input: s = "LEETCODE"
//Output: 92
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of uppercase English letters only. 
// 
// Related Topics 字符串 动态规划 👍 102 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static void main(String[] args) {
        Solution solution = new CountUniqueCharactersOfAllSubstringsOfAGivenString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                indexMap.get(c).add(i);
            } else {
                indexMap.put(c, new ArrayList<>());
                indexMap.get(c).add(i);
            }
        }
        long ans = 0;
        for (List<Integer> arr : indexMap.values()) {
            for (int i = 0; i < arr.size(); ++i) {
                long prev = i > 0 ? arr.get(i - 1) : -1;
                long next = i < arr.size() - 1 ? arr.get(i + 1) : s.length();
                ans += (arr.get(i) - prev) * (next - arr.get(i));
            }
        }
        return (int) ans % 1_000_000_007;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
