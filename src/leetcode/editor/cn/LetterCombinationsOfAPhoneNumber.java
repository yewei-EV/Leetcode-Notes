/**
  * 题目Id：17
  * 题目：Letter Combinations of a Phone Number
  * 日期：2021-12-15 00:43:56
*/
//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics 哈希表 字符串 回溯 👍 1644 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(new StringBuilder(), digits, result);
        return result;
    }

    public void backtracking(StringBuilder s, String digits, List<String> result) {
        if (s.length() == digits.length()) {
            result.add(String.valueOf(s));
            return;
        }
        int index = digits.charAt(s.length()) - '0';
        for (int i = 0; i < KEYS[index].length(); ++i) {
            s.append(KEYS[index].toCharArray()[i]);
            backtracking(s, digits, result);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
