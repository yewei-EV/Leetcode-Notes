/**
  * 题目Id：438
  * 题目：Find All Anagrams in a String
  * 日期：2022-02-15 22:41:56
*/
//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 771 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        int[] sHash = new int[26];
        int[] pHash = new int[26];
        for (char c : p.toCharArray()) {
            pHash[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int l = 0, r = 0; r < m; ++r) {
            sHash[s.charAt(r) - 'a']++;
            if (r - l + 1 > n) sHash[s.charAt(l++) - 'a']--;
            if (r - l + 1 == n && check(sHash, pHash)) result.add(l);
        }
        return result;
    }

    boolean check(int[] sHash, int[] pHash) {
        for (int i = 0; i < sHash.length; ++i) {
            if (sHash[i] != pHash[i]) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
