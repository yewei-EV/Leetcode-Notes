/**
  * 题目Id：524
  * 题目：Longest Word in Dictionary through Deleting
  * 日期：2022-02-28 16:16:41
*/
//Given a string s and a string array dictionary, return the longest string in 
//the dictionary that can be formed by deleting some of the given string 
//characters. If there is more than one possible result, return the longest word with the 
//smallest lexicographical order. If there is no possible result, return the empty 
//string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//Output: "apple"
// 
//
// Example 2: 
//
// 
//Input: s = "abpcplea", dictionary = ["a","b","c"]
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s and dictionary[i] consist of lowercase English letters. 
// 
// Related Topics 数组 双指针 字符串 排序 👍 290 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        if (dictionary.size() == 0 || Objects.equals(s, "")) return "";
        String ans = "";
        for (String d : dictionary) {
            if (d.length() > ans.length()
                    || (d.length() == ans.length() && d.compareTo(ans) < 0)) {
                if (isMatch(s, d)) {
                    ans = d;
                }
            }
        }
        return ans;
    }

    public boolean isMatch(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == word.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
