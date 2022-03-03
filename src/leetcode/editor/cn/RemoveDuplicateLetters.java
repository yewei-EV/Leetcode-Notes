/**
  * 题目Id：316
  * 题目：Remove Duplicate Letters
  * 日期：2022-02-28 16:15:32
*/
//Given a string s, remove duplicate letters so that every letter appears once 
//and only once. You must make sure your result is the smallest in lexicographical 
//order among all possible results. 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// 
// Note: This question is the same as 1081: https://leetcode.com/problems/
//smallest-subsequence-of-distinct-characters/ 
// Related Topics 栈 贪心 字符串 单调栈 👍 662 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c-'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : arr) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c
                    && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
