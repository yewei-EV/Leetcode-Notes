/**
  * 题目Id：74
  * 题目：Search a 2D Matrix
  * 日期：2022-03-17 18:17:51
*/
//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 602 👎 0

package leetcode.editor.cn;
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length < 1) return false;
            int row = getRow(matrix, target);
            return find(matrix[row], target);
        }

        public int getRow(int[][] matrix, int target) {
            int top = 0, bottom = matrix.length - 1;
            int col = matrix[0].length - 1;
            while (top < bottom) {
                int mid = (top + bottom) / 2;
                if (matrix[mid][col] < target)
                    top = mid + 1;
                else
                    bottom = mid;
            }
            return top;
        }

        public boolean find(int[] data, int target) {
            int l = 0, r = data.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (data[mid] == target)
                    return true;
                else if (data[mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            return false;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
