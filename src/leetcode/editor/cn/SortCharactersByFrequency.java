/**
  * 题目Id：451
  * 题目：Sort Characters By Frequency
  * 日期：2021-12-06 14:33:50
*/
//Given a string s, sort it in decreasing order based on the frequency of the 
//characters. The frequency of a character is the number of times it appears in the 
//string. 
//
// Return the sorted string. If there are multiple answers, return any of them. 
//
//
// 
// Example 1: 
//
// 
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid 
//answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and 
//"aaaccc" are valid answers.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
//
// Example 3: 
//
// 
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s consists of uppercase and lowercase English letters and digits. 
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 354 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int time = entry.getValue();
            while (time > 0) {
                stringBuilder.append(entry.getKey());
                time--;
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
