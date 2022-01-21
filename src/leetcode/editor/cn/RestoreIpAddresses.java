/**
  * 题目Id：93
  * 题目：Restore IP Addresses
  * 日期：2021-12-15 13:13:28
*/
//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// s consists of digits only. 
// 
// Related Topics 字符串 回溯 👍 748 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder address = new StringBuilder();
        backtracking(0, address, result, s);
        return result;
    }

    public void backtracking(int count, StringBuilder address, List<String> result, String s) {
        if (count == 4 && s.length() == 0) {
            result.add(address.toString());
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; ++i) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String partition = s.substring(0, i + 1);
            if (Integer.parseInt(partition) <= 255) {
                if (count != 3) {
                    partition = partition + ".";
                }
                address.append(partition);
                backtracking(count+1, address, result, s.substring(i + 1));
                address.delete(address.length() - partition.length(), address.length());
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
