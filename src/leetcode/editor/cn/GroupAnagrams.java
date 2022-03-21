/**
  * 题目Id：49
  * 题目：Group Anagrams
  * 日期：2022-03-16 10:34:56
*/
//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
// Related Topics 哈希表 字符串 排序 👍 1054 👎 0

package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Node {
        String str;
        int[] count;

        public Node(String str) {
            this.count = new int[26];
            this.str = str;
            char[] chars = this.str.toCharArray();
            for (char c : chars) {
                this.count[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            if (this.str.length() != other.str.length()) return false;
            for (int i = 0; i < 26; i++) {
                if (this.count[i] != other.count[i]) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            for (int cnt : count) {
                hash = hash * 31 + cnt;
            }
            return hash;
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Node, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Node node = new Node(str);
            List<String> list = map.getOrDefault(node, new LinkedList<>());
            list.add(str);
            map.put(node, list);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
