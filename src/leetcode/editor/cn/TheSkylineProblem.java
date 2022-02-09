/**
  * 题目Id：218
  * 题目：The Skyline Problem
  * 日期：2022-02-09 01:55:27
*/
//A city's skyline is the outer contour of the silhouette formed by all the 
//buildings in that city when viewed from a distance. Given the locations and heights 
//of all the buildings, return the skyline formed by these buildings collectively.
// 
//
// The geometric information of each building is given in the array buildings 
//where buildings[i] = [lefti, righti, heighti]: 
//
// 
// lefti is the x coordinate of the left edge of the iᵗʰ building. 
// righti is the x coordinate of the right edge of the iᵗʰ building. 
// heighti is the height of the iᵗʰ building. 
// 
//
// You may assume all buildings are perfect rectangles grounded on an 
//absolutely flat surface at height 0. 
//
// The skyline should be represented as a list of "key points" sorted by their 
//x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left 
//endpoint of some horizontal segment in the skyline except the last point in the list, 
//which always has a y-coordinate 0 and is used to mark the skyline's termination 
//where the rightmost building ends. Any ground between the leftmost and 
//rightmost buildings should be part of the skyline's contour. 
//
// Note: There must be no consecutive horizontal lines of equal height in the 
//output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not 
//acceptable; the three lines of height 5 should be merged into one in the final 
//output as such: [...,[2 3],[4 5],[12 7],...] 
//
// 
// Example 1: 
//
// 
//Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//Explanation:
//Figure A shows the buildings of the input.
//Figure B shows the skyline formed by those buildings. The red points in 
//figure B represent the key points in the output list.
// 
//
// Example 2: 
//
// 
//Input: buildings = [[0,2,3],[2,5,3]]
//Output: [[0,3],[5,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= buildings.length <= 10⁴ 
// 0 <= lefti < righti <= 2³¹ - 1 
// 1 <= heighti <= 2³¹ - 1 
// buildings is sorted by lefti in non-decreasing order. 
// 
// Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列） 👍 616 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public static void main(String[] args) {
        Solution solution = new TheSkylineProblem().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int height;
        boolean isLeft;

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isLeft ? -this.height : this.height) - (o.isLeft ? -o.height : o.height);
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].height = building[2];
            buildingPoints[index].isLeft = true;

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].height = building[2];
            buildingPoints[index+1].isLeft = false;
            index += 2;
        }
        Arrays.sort(buildingPoints);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (BuildingPoint buildingPoint: buildingPoints) {
            if (buildingPoint.isLeft) {
                if (queue.containsKey(buildingPoint.height)) {
                    queue.put(buildingPoint.height, queue.get(buildingPoint.height) + 1);
                } else {
                    queue.put(buildingPoint.height, 1);
                }
            } else {
                if (queue.get(buildingPoint.height) == 1) {
                    queue.remove(buildingPoint.height);
                } else {
                    queue.put(buildingPoint.height, queue.get(buildingPoint.height) - 1);
                }
            }
            //The Biggest Height
            int currentMaxHeight = queue.lastKey();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(buildingPoint.x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
