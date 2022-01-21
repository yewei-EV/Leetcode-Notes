/**
  * 题目Id：766
  * 题目：Toeplitz Matrix
  * 日期：2022-01-16 14:55:03
*/
//Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, 
//return false. 
//
// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the 
//same elements. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//Output: true
//Explanation:
//In the above grid, the diagonals are:
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
//In each diagonal all elements are the same, so the answer is True.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2],[2,2]]
//Output: false
//Explanation:
//The diagonal "[1, 2]" has different elements.
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
// Follow up: 
//
// 
// What if the matrix is stored on disk, and the memory is limited such that 
//you can only load at most one row of the matrix into the memory at once? 
// What if the matrix is so large that you can only load up a partial row into 
//the memory at once? 
// 
// Related Topics 数组 矩阵 👍 253 👎 0

package leetcode.editor.cn;
public class ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new ToeplitzMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
