/**
  * 题目Id：394
  * 题目：Decode String
  * 日期：2022-03-02 23:41:00
*/
//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; there are no extra 
//white spaces, square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any 
//digits and that digits are only for those repeat numbers, k. For example, there will 
//not be input like 3a or 2[4]. 
//
// 
// Example 1: 
//
// 
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// 
//
// Example 2: 
//
// 
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
// 
//
// Example 3: 
//
// 
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
// Related Topics 栈 递归 字符串 👍 1054 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                // remove [
                stack.pop();

                // find k
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());
                int count = Integer.parseInt(sb.toString());
                // repeat sub and push back into stack
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder revertedRes = new StringBuilder();
        while (!stack.isEmpty()) {
            revertedRes.append(stack.pop());
        }
        return revertedRes.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
