/**
  * 题目Id：767
  * 题目：Reorganize String
  * 日期：2022-03-02 16:34:38
*/
//Given a string s, rearrange the characters of s so that any two adjacent 
//characters are not the same. 
//
// Return any possible rearrangement of s or return "" if not possible. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: "aba"
// Example 2: 
// Input: s = "aaab"
//Output: ""
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 👍 388 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                queue.offer(new int[]{i, freq[i]});
            }
        }
        int prev = -1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (prev != -1 && prev == cur[0]) {
                int[] next = queue.poll();
                if (next == null) {
                    break;
                }
                sb.append((char) (next[0] + 'a'));
                if (next[1] > 1) {
                    queue.offer(new int[]{next[0], next[1] - 1});
                }
            }
            sb.append((char) (cur[0] + 'a'));
            if (cur[1] > 1) {
                queue.offer(new int[]{cur[0], cur[1] - 1});
            }
            prev = cur[0];
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
