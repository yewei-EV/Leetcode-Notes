/**
  * 题目Id：1160
  * 题目：Find Words That Can Be Formed by Characters
  * 日期：2022-03-08 10:19:55
*/
//You are given an array of strings words and a string chars. 
//
// A string is good if it can be formed by characters from chars (each 
//character can only be used once). 
//
// Return the sum of lengths of all good strings in words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","bt","hat","tree"], chars = "atach"
//Output: 6
//Explanation: The strings that can be formed are "cat" and "hat" so the answer 
//is 3 + 3 = 6.
// 
//
// Example 2: 
//
// 
//Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//Output: 10
//Explanation: The strings that can be formed are "hello" and "world" so the 
//answer is 5 + 5 = 10.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// words[i] and chars consist of lowercase English letters. 
// 
// Related Topics 数组 哈希表 字符串 👍 153 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        Solution solution = new FindWordsThatCanBeFormedByCharacters().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        // build map for chars
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // iterate all words
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            // iterate all char
            boolean good = true;
            for (char c : word.toCharArray()) {
                // count the char in tempMap
                int count = tempMap.getOrDefault(c, 0) + 1;
                tempMap.put(c, count);
                // compare the count with the freq in map
                if (count > map.getOrDefault(c, 0)) {
                    good = false;
                    break;
                }
            }
            if (good) {
                ans += word.length();
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
