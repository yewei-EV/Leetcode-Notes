/**
  * 题目Id：696
  * 题目：Count Binary Substrings
  * 日期：2022-01-15 14:38:11
*/
//Give a binary string s, return the number of non-empty substrings that have 
//the same number of 0's and 1's, and all the 0's and all the 1's in these 
//substrings are grouped consecutively. 
//
// Substrings that occur multiple times are counted the number of times they 
//occur. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110011"
//Output: 6
//Explanation: There are 6 substrings that have equal number of consecutive 1's 
//and 0's: "0011", "01", "1100", "10", "0011", and "01".
//Notice that some of these substrings repeat and are counted the number of 
//times they occur.
//Also, "00110011" is not a valid substring because all the 0's (and 1's) are 
//not grouped together.
// 
//
// Example 2: 
//
// 
//Input: s = "10101"
//Output: 4
//Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal 
//number of consecutive 1's and 0's.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either '0' or '1'. 
// 
// Related Topics 双指针 字符串 👍 430 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new CountBinarySubstrings().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            char temp = s.charAt(index);
            int count = 0;
            while (index < s.length() && s.charAt(index) == temp) {
                index++;
                count++;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 0; i < counts.size() - 1; ++i) {
            ans += Math.min(counts.get(i), counts.get(i+1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
