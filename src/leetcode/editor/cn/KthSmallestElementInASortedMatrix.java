/**
  * 题目Id：378
  * 题目：Kth Smallest Element in a Sorted Matrix
  * 日期：2022-01-15 22:10:17
*/
//Given an n x n matrix where each of the rows and columns is sorted in 
//ascending order, return the kᵗʰ smallest element in the matrix. 
//
// Note that it is the kᵗʰ smallest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must find a solution with a memory complexity better than O(n²). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and 
//the 8ᵗʰ smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the rows and columns of matrix are guaranteed to be sorted in non-
//decreasing order. 
// 1 <= k <= n² 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory 
//complexity)? 
// Could you solve the problem in O(n) time complexity? The solution may be too 
//advanced for an interview but you may find reading this paper fun. 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 👍 740 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // binary search
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right - left)/2;
            int count = countBiggerThanMid(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int countBiggerThanMid(int[][] matrix, int target) {
        int n = matrix.length;
        //starting from the left bottom point
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    // Min-Heap
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return a[0] - b[0];
//            }
//        });
//        int n = matrix.length;
//        for (int i = 0; i < n; ++i) {
//            pq.offer(new int[]{matrix[i][0], i, 0});
//        }
//        for (int i = 0; i < k - 1; ++i) {
//            int[] cur = pq.poll();
//            if (cur[2] != n - 1) {
//                pq.offer(new int[]{matrix[cur[1]][cur[2]+1], cur[1], cur[2]+1});
//            }
//        }
//        return pq.poll()[0];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
