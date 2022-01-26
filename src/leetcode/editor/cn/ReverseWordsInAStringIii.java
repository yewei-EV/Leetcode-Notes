/**
  * 题目Id：557
  * 题目：Reverse Words in a String III
  * 日期：2022-01-15 13:38:36
*/
//Given a string s, reverse the order of characters in each word within a 
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
// Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2: 
// Input: s = "God Ding"
//Output: "doG gniD"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
// Related Topics 双指针 字符串 👍 390 👎 0

package leetcode.editor.cn;


public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int right = 0;
        while (right <= n) {
            if (right == n || arr[right] == ' ') {
                swap(arr, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(arr);
    }

    public void swap(char[] sb, int start, int end) {
        while (start < end) {
            char temp = sb[start];
            sb[start] = sb[end];
            sb[end] = temp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
