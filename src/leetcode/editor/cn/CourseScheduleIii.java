/**
  * 题目Id：630
  * 题目：Course Schedule III
  * 日期：2022-03-02 23:38:56
*/
//There are n different online courses numbered from 1 to n. You are given an 
//array courses where courses[i] = [durationi, lastDayi] indicate that the iᵗʰ 
//course should be taken continuously for durationi days and must be finished before 
//or on lastDayi. 
//
// You will start on the 1ˢᵗ day and you cannot take two or more courses 
//simultaneously. 
//
// Return the maximum number of courses that you can take. 
//
// 
// Example 1: 
//
// 
//Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
//Output: 3
//Explanation: 
//There are totally 4 courses, but you can take 3 courses at most:
//First, take the 1ˢᵗ course, it costs 100 days so you will finish it on the 100
//ᵗʰ day, and ready to take the next course on the 101ˢᵗ day.
//Second, take the 3ʳᵈ course, it costs 1000 days so you will finish it on the 1
//100ᵗʰ day, and ready to take the next course on the 1101ˢᵗ day. 
//Third, take the 2ⁿᵈ course, it costs 200 days so you will finish it on the 130
//0ᵗʰ day. 
//The 4ᵗʰ course cannot be taken now, since you will finish it on the 3300ᵗʰ 
//day, which exceeds the closed date.
// 
//
// Example 2: 
//
// 
//Input: courses = [[1,2]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: courses = [[3,2],[4,3]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
// Related Topics 贪心 数组 堆（优先队列） 👍 322 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIii {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIii().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int time = 0;
        for (int[] course: courses) {
            // no conflict
            if (course[0] + time <= course[1]) {
                time += course[0];
                queue.offer(course);
            } else if (!queue.isEmpty() && queue.peek()[0] > course[0]) {
                time = time - (queue.poll()[0] - course[0]);
                queue.offer(course);
            }
        }
        return queue.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
