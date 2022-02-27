/**
  * 题目Id：1405
  * 题目：Longest Happy String
  * 日期：2022-02-27 18:11:14
*/
//A string s is called happy if it satisfies the following conditions: 
//
// 
// s only contains the letters 'a', 'b', and 'c'. 
// s does not contain any of "aaa", "bbb", or "ccc" as a substring. 
// s contains at most a occurrences of the letter 'a'. 
// s contains at most b occurrences of the letter 'b'. 
// s contains at most c occurrences of the letter 'c'. 
// 
//
// Given three integers a, b, and c, return the longest possible happy string. 
//If there are multiple longest happy strings, return any of them. If there is no 
//such string, return the empty string "". 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 1, c = 7
//Output: "ccaccbcc"
//Explanation: "ccbccacc" would also be a correct answer.
// 
//
// Example 2: 
//
// 
//Input: a = 7, b = 1, c = 0
//Output: "aabaa"
//Explanation: It is the only correct answer in this case.
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 189 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->y[1]-x[1]);
        if (a > 0) q.add(new int[]{0, a});
        if (b > 0) q.add(new int[]{1, b});
        if (c > 0) q.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // if prev two is the same element
            int n = sb.length();
            if (n >= 2 && sb.charAt(n-1) == cur[0] + 'a' && sb.charAt(n-2) == cur[0] + 'a') {
                if (q.isEmpty()) {
                    break;
                }
                int[] second = q.poll();
                sb.append(second[0] + 'a');
                if (--second[1] != 0) q.add(second);
                q.add(cur);
            } else {
                sb.append(cur[0] + 'a');
                if (--cur[1] != 0) {
                    q.add(cur);
                }
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
