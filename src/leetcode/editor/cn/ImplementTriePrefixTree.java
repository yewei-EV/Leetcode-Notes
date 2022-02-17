/**
  * 题目Id：208
  * 题目：Implement Trie (Prefix Tree)
  * 日期：2022-01-14 00:33:59
*/
//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 1024 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Solution solution = new ImplementTriePrefixTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.nextMap.get(word.charAt(i)) == null) {
                node.nextMap.put(word.charAt(i), new TrieNode());
            }
            node = node.nextMap.get(word.charAt(i));
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.nextMap.get(word.charAt(i)) == null) {
                return false;
            }
            node = node.nextMap.get(word.charAt(i));
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (node.nextMap.get(prefix.charAt(i)) == null) {
                return false;
            }
            node = node.nextMap.get(prefix.charAt(i));
        }
        return true;
    }

    class TrieNode {
        Map<Character, TrieNode> nextMap;
        boolean isEnd;

        public TrieNode() {
            nextMap = new HashMap<>();
            isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
