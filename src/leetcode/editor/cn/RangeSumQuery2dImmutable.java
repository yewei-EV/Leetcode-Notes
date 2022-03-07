/**
  * 题目Id：304
  * 题目：Range Sum Query 2D - Immutable
  * 日期：2022-03-01 19:30:26
*/
//Given a 2D matrix matrix, handle multiple queries of the following type: 
//
// 
// Calculate the sum of the elements of matrix inside the rectangle defined by 
//its upper left corner (row1, col1) and lower right corner (row2, col2). 
// 
//
// Implement the NumMatrix class: 
//
// 
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix 
//matrix. 
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
//elements of matrix inside the rectangle defined by its upper left corner (row1, 
//col1) and lower right corner (row2, col2). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 
//3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
//Output
//[null, 8, 11, 12]
//
//Explanation
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 
//0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// At most 10⁴ calls will be made to sumRegion. 
// 
// Related Topics 设计 数组 矩阵 前缀和 👍 349 👎 0

package leetcode.editor.cn;
public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        Solution solution = new RangeSumQuery2dImmutable().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = n == 0 ? 0 : matrix[0].length;
        sum = new int[n + 1][m + 1];
        // pre-compute the prefix for matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return sum[row2][col2] + sum[row1-1][col1-1] - sum[row1-1][col2] - sum[row2][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
