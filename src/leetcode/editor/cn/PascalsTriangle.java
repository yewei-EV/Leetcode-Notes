/**
  * 题目Id：118
  * 题目：Pascal's Triangle
  * 日期：2022-02-02 18:22:27
*/
//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 678 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j > 0 && j < i) {
                    List<Integer> prevLine = result.get(i - 1);
                    line.add(prevLine.get(j-1) + prevLine.get(j));
                } else {
                    line.add(1);
                }
            }
            result.add(line);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
