/**
  * 题目Id：720
  * 题目：Longest Word in Dictionary
  * 日期：2022-02-28 16:16:53
*/
//Given an array of strings words representing an English Dictionary, return 
//the longest word in words that can be built one character at a time by other words 
//in words. 
//
// If there is more than one possible answer, return the longest word with the 
//smallest lexicographical order. If there is no answer, return the empty string. 
//
// 
// Example 1: 
//
// 
//Input: words = ["w","wo","wor","worl","world"]
//Output: "world"
//Explanation: The word "world" can be built one character at a time by "w", 
//"wo", "wor", and "worl".
// 
//
// Example 2: 
//
// 
//Input: words = ["a","banana","app","appl","ap","apply","apple"]
//Output: "apple"
//Explanation: Both "apply" and "apple" can be built from other words in the 
//dictionary. However, "apple" is lexicographically smaller than "apply".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// words[i] consists of lowercase English letters. 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 186 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public void helper(TrieNode node, String path) {
        if (node == null || !node.isWord) {
            return;
        }
        if (path.length() > res.length()) res = path;
        StringBuilder sb = new StringBuilder(path);
        for (TrieNode child : node.children) {
            if (child != null) {
                sb.append(child.c);
                helper(child, sb.toString());
                sb.setLength(sb.length() - 1);
            }
        }
    }

    String res = "";
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.isWord = true;
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                cur.c = c;
            }
            cur.isWord = true;
        }
        helper(root, "");
        return res;
//        String ans = "";
//        Set<String> wordset = new HashSet(Arrays.asList(words));
//        for (String word: words) {
//            boolean isValid = true;
//            if (word.length() < ans.length()) continue;
//            if (word.length() == ans.length() && word.compareTo(ans) > 0) continue;
//            for (int i = 1; i < word.length(); i++) {
//                if (!wordset.contains(word.substring(0, i))) {
//                    isValid = false;
//                    break;
//                }
//            }
//            if (isValid) ans = word;
//        }
//        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
