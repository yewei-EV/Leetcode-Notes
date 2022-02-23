/**
  * 题目Id：1710
  * 题目：Maximum Units on a Truck
  * 日期：2022-02-22 16:29:40
*/
//You are assigned to put some amount of boxes onto one truck. You are given a 2
//D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]: 
//
// 
// numberOfBoxesi is the number of boxes of type i. 
// numberOfUnitsPerBoxi is the number of units in each box of the type i. 
// 
//
// You are also given an integer truckSize, which is the maximum number of 
//boxes that can be put on the truck. You can choose any boxes to put on the truck as 
//long as the number of boxes does not exceed truckSize. 
//
// Return the maximum total number of units that can be put on the truck. 
//
// 
// Example 1: 
//
// 
//Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//Output: 8
//Explanation: There are:
//- 1 box of the first type that contains 3 units.
//- 2 boxes of the second type that contain 2 units each.
//- 3 boxes of the third type that contain 1 unit each.
//You can take all the boxes of the first and second types, and one box of the 
//third type.
//The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
// 
//
// Example 2: 
//
// 
//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
// 
//
// 
// Constraints: 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 10⁶ 
// 
// Related Topics 贪心 数组 排序 👍 28 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        Solution solution = new MaximumUnitsOnATruck().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int count = 0;
        for (int[] box : boxTypes) {
            if (box[0] <= truckSize) {
                count += box[0] * box[1];
                truckSize -= box[0];
            } else {
                count += box[1] * truckSize;
                return count;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
