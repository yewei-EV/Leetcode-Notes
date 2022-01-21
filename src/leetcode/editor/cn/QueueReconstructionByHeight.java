/**
  * 题目Id：406
  * 题目：Queue Reconstruction by Height
  * 日期：2021-12-06 22:00:32
*/
//You are given an array of people, people, which are the attributes of some 
//people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents 
//the iᵗʰ person of height hi with exactly ki other people in front who have a 
//height greater than or equal to hi. 
//
// Reconstruct and return the queue that is represented by the input array 
//people. The returned queue should be formatted as an array queue, where queue[j] = [
//hj, kj] is the attributes of the jᵗʰ person in the queue (queue[0] is the person 
//at the front of the queue). 
//
// 
// Example 1: 
//
// 
//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//Explanation:
//Person 0 has height 5 with no other people taller or the same height in front.
//
//Person 1 has height 7 with no other people taller or the same height in front.
//
//Person 2 has height 5 with two persons taller or the same height in front, 
//which is person 0 and 1.
//Person 3 has height 6 with one person taller or the same height in front, 
//which is person 1.
//Person 4 has height 4 with four people taller or the same height in front, 
//which are people 0, 1, 2, and 3.
//Person 5 has height 7 with one person taller or the same height in front, 
//which is person 1.
//Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
// 
//
// Example 2: 
//
// 
//Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= people.length <= 2000 
// 0 <= hi <= 10⁶ 
// 0 <= ki < people.length 
// It is guaranteed that the queue can be reconstructed. 
// 
// Related Topics 贪心 数组 排序 👍 1068 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p: people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
