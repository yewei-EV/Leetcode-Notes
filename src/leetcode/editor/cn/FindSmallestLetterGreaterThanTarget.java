/**
  * 题目Id：744
  * 题目：Find Smallest Letter Greater Than Target
  * 日期：2021-12-07 17:42:44
*/
//Given a characters array letters that is sorted in non-decreasing order and a 
//character target, return the smallest character in the array that is larger 
//than target. 
//
// Note that the letters wrap around. 
//
// 
// For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'. 
// 
//
// 
// Example 1: 
//
// 
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
// 
//
// Example 2: 
//
// 
//Input: letters = ["c","f","j"], target = "c"
//Output: "f"
// 
//
// Example 3: 
//
// 
//Input: letters = ["c","f","j"], target = "d"
//Output: "f"
// 
//
// Example 4: 
//
// 
//Input: letters = ["c","f","j"], target = "g"
//Output: "j"
// 
//
// Example 5: 
//
// 
//Input: letters = ["c","f","j"], target = "j"
//Output: "c"
// 
//
// 
// Constraints: 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] is a lowercase English letter. 
// letters is sorted in non-decreasing order. 
// letters contains at least two different characters. 
// target is a lowercase English letter. 
// 
// Related Topics 数组 二分查找 👍 133 👎 0

package leetcode.editor.cn;
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;
        while (l <= h) {
            int m = l + (h-l)/2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
