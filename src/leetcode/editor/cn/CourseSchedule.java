/**
  * 题目Id：207
  * 题目：Course Schedule
  * 日期：2021-12-29 18:17:39
*/
//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1066 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] visited = new int[numCourses];
        for (int[] neighbor : prerequisites) {
            graph.get(neighbor[1]).add(neighbor[0]);
        }
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

//    i == 0 ： 干净的，未被 DFS 访问
//    i == -1：其他节点启动的 DFS 访问过了，路径没问题，不需要再访问了
//    i == 1  ：本节点启动的 DFS 访问过了，一旦遇到了也说明有环了
    public boolean dfs(List<List<Integer>> graph, int[] visited, int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int next : graph.get(i)) {
            if(!dfs(graph, visited, next)) {
                return false;
            }
        }
        visited[i] = -1;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
