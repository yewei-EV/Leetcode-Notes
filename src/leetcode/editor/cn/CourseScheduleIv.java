/**
  * 题目Id：1462
  * 题目：Course Schedule IV
  * 日期：2022-03-02 23:39:26
*/
//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course ai first if you want to take course bi.
// 
//
// 
// For example, the pair [0, 1] indicates that you have to take course 0 before 
//you can take course 1. 
// 
//
// Prerequisites can also be indirect. If course a is a prerequisite of course 
//b, and course b is a prerequisite of course c, then course a is a prerequisite 
//of course c. 
//
// You are also given an array queries where queries[j] = [uj, vj]. For the jᵗʰ 
//query, you should answer whether course uj is a prerequisite of course vj or 
//not. 
//
// Return a boolean array answer, where answer[j] is the answer to the jᵗʰ 
//query. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
//Output: [false,true]
//Explanation: The pair [1, 0] indicates that you have to take course 1 before 
//you can take course 0.
//Course 0 is not a prerequisite of course 1, but the opposite is true.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
//Output: [false,false]
//Explanation: There are no prerequisites, and each course is independent.
// 
//
// Example 3: 
//
// 
//Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[
//1,2]]
//Output: [true,true]
// 
//
// 
// Constraints: 
//
// 
// 2 <= numCourses <= 100 
// 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2) 
// prerequisites[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// All the pairs [ai, bi] are unique. 
// The prerequisites graph has no cycles. 
// 1 <= queries.length <= 10⁴ 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 78 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CourseScheduleIv {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIv().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // build gragh
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // set inDegrees
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            inDegrees[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        // bfs to traverse all courses
        Map<Integer, Set<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer neighbor : graph.get(cur)) {
                Set<Integer> set = map.getOrDefault(neighbor, new HashSet<>());
                set.add(cur);
                set.addAll(map.getOrDefault(cur, new HashSet<>()));
                map.put(neighbor, set);
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // iterate queries
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (map.getOrDefault(query[1], new HashSet<>()).contains(query[0])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
