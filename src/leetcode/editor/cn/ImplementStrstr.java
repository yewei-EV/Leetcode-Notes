/**
  * 题目Id：28
  * 题目：Implement strStr()
  * 日期：2022-02-04 16:35:37
*/
//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if 
//needle is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great 
//question to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty 
//string. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1235 👎 0

package leetcode.editor.cn;
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // KMP
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;

//        int m = haystack.length(), n = needle.length();
//        for (int i = 0; i <= m - n; ++i) {
//            int a = i, b = 0;
//            while (b < n && haystack.charAt(a) == needle.charAt(b)) {
//                a++;
//                b++;
//            }
//            if (b == n) {
//                return i;
//            }
//        }
//        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
