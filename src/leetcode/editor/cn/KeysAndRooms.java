/**
  * 题目Id：841
  * 题目：Keys and Rooms
  * 日期：2022-03-20 17:07:48
*/
//There are n rooms labeled from 0 to n - 1 and all the rooms are locked except 
//for room 0. Your goal is to visit all the rooms. However, you cannot enter a 
//locked room without having its key. 
//
// When you visit a room, you may find a set of distinct keys in it. Each key 
//has a number on it, denoting which room it unlocks, and you can take all of them 
//with you to unlock the other rooms. 
//
// Given an array rooms where rooms[i] is the set of keys that you can obtain 
//if you visited room i, return true if you can visit all the rooms, or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: rooms = [[1],[2],[3],[]]
//Output: true
//Explanation: 
//We visit room 0 and pick up key 1.
//We then visit room 1 and pick up key 2.
//We then visit room 2 and pick up key 3.
//We then visit room 3.
//Since we were able to visit every room, we return true.
// 
//
// Example 2: 
//
// 
//Input: rooms = [[1,3],[3,0,1],[2],[0]]
//Output: false
//Explanation: We can not enter room number 2 since the only key that unlocks 
//it is in that room.
// 
//
// 
// Constraints: 
//
// 
// n == rooms.length 
// 2 <= n <= 1000 
// 0 <= rooms[i].length <= 1000 
// 1 <= sum(rooms[i].length) <= 3000 
// 0 <= rooms[i][j] < n 
// All the values of rooms[i] are unique. 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 👍 243 👎 0

package leetcode.editor.cn;

import java.util.List;

public class KeysAndRooms {
    public static void main(String[] args) {
        Solution solution = new KeysAndRooms().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        return count == n;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int x) {
        if (visited[x]) return;
        visited[x] = true;
        count++;
        for (int k : rooms.get(x)) {
            dfs(rooms, visited, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
