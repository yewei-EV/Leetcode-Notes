/**
  * 题目Id：面试题 16.20
  * 题目：T9 LCCI
  * 日期：2022-01-18 15:00:21
*/
//On old cell phones, users typed on a numeric keypad and the phone would 
//provide a list of words that matched these numbers. Each digit mapped to a set of 0 - 
//4 letters. Implement an algorithm to return a list of matching words, given a 
//sequence of digits. You are provided a list of valid words. The mapping is shown 
//in the diagram below: 
//
// 
//
// Example 1: 
//
// 
//Input: num = "8733", words = ["tree", "used"]
//Output: ["tree", "used"]
// 
//
// Example 2: 
//
// 
//Input: num = "2", words = ["a", "b", "c", "d"]
//Output: ["a", "b", "c"] 
//
// Note: 
//
// 
// num.length <= 1000 
// words.length <= 500 
// words[i].length == num.length 
// There are no number 0 and 1 in num. 
// 
// Related Topics 数组 哈希表 字符串 👍 28 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T9Lcci {
    public static void main(String[] args) {
        Solution solution = new T9Lcci().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, String> map = new HashMap<>();

    public List<String> getValidT9Words(String num, String[] words) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        Trie trie = new Trie();
        trie.insert(num);
        List<String> list = new ArrayList<>();
        for (String w : words){
            if(w.length() == num.length() && trie.startsWith(w)) {
                list.add(w);
            }
        }
        return list;
    }

    class Trie {

        Trie[] children;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char num = word.charAt(i);
                // here, num is an ASCII number, need to transfer to int
                int index = num - '0';
                String chars = map.get(index);
                Trie t = new Trie();
                for (char c : chars.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = t;
                    }
                }
                node = t;
            }
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); ++i) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
