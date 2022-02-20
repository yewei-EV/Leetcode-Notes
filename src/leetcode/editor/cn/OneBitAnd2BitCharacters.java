/**
  * 题目Id：717
  * 题目：1-bit and 2-bit Characters
  * 日期：2022-02-20 22:26:14
*/
//We have two special characters: 
//
// 
// The first character can be represented by one bit 0. 
// The second character can be represented by two bits (10 or 11). 
// 
//
// Given a binary array bits that ends with 0, return true if the last 
//character must be a one-bit character. 
//
// 
// Example 1: 
//
// 
//Input: bits = [1,0,0]
//Output: true
//Explanation: The only way to decode it is two-bit character and one-bit 
//character.
//So the last character is one-bit character.
// 
//
// Example 2: 
//
// 
//Input: bits = [1,1,1,0]
//Output: false
//Explanation: The only way to decode it is two-bit character and two-bit 
//character.
//So the last character is not one-bit character.
// 
//
// 
// Constraints: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] is either 0 or 1. 
// 
// Related Topics 数组 👍 260 👎 0

package leetcode.editor.cn;
public class OneBitAnd2BitCharacters {
    public static void main(String[] args) {
        Solution solution = new OneBitAnd2BitCharacters().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i = i + 2;
            } else {
                i = i + 1;
            }
        }
        if (i == bits.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
