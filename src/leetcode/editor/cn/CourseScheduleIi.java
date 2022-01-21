/**
  * 题目Id：210
  * 题目：Course Schedule II
  * 日期：2021-12-29 22:35:39
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
// Return the ordering of courses you should take to finish all courses. If 
//there are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you 
//should have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you 
//should have finished both courses 1 and 2. Both courses 1 and 2 should be taken 
//after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 533 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] visited = new int[numCourses];
        for (int[] neighbor : prerequisites) {
            graph.get(neighbor[1]).add(neighbor[0]);
        }
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(graph, visited, i, res)) {
                return new int[0];
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[res.size()-1-i] = res.get(i);
        }
        return ans;
    }

//    i == 0 ： 干净的，未被 DFS 访问
//    i == -1：其他节点启动的 DFS 访问过了，路径没问题，不需要再访问了
//    i == 1  ：本节点启动的 DFS 访问过了，一旦遇到了也说明有环了
    public boolean dfs(List<List<Integer>> graph, int[] visited, int i, ArrayList<Integer> result) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int next : graph.get(i)) {
            if (!dfs(graph, visited, next, result)) {
                return false;
            }
        }
        visited[i] = -1;
        result.add(i);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
