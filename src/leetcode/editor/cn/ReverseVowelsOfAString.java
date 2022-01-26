/**
  * 题目Id：345
  * 题目：Reverse Vowels of a String
  * 日期：2022-01-26 21:47:09
*/
//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//cases. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 👍 235 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s.length() == 0) return "";
        char[] res = s.toCharArray();
        int n = res.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (!vowels.contains(res[left])) {
                left++;
            } else if (!vowels.contains(res[right])) {
                right--;
            } else {
                char temp = res[left];
                res[left++] = res[right];
                res[right--] = temp;
            }
        }
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
