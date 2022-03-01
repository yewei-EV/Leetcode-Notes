/**
  * 题目Id：472
  * 题目：Concatenated Words
  * 日期：2022-02-28 16:16:21
*/
//Given an array of strings words (without duplicates), return all the 
//concatenated words in the given list of words. 
//
// A concatenated word is defined as a string that is comprised entirely of at 
//least two shorter words in the given array. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog",
//"hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
//
// Example 2: 
//
// 
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁴ 
// 0 <= words[i].length <= 30 
// words[i] consists of only lowercase English letters. 
// 0 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics 深度优先搜索 字典树 数组 字符串 动态规划 👍 244 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new ConcatenatedWords().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (isConcatenated(dict, word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean isConcatenated(Set<String> dict, String word, int startIdx, int cnt) {
        if (startIdx == word.length() && cnt >= 2) return true;
        for (int i = startIdx + 1; i <= word.length(); i++) {
            String next = word.substring(startIdx, i);
            if (dict.contains(next) && isConcatenated(dict, word, i, cnt + 1)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
