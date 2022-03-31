/**
  * 题目Id：332
  * 题目：Reconstruct Itinerary
  * 日期：2022-03-30 23:59:36
*/
//You are given a list of airline tickets where tickets[i] = [fromi, toi] 
//represent the departure and the arrival airports of one flight. Reconstruct the 
//itinerary in order and return it. 
//
// All of the tickets belong to a man who departs from "JFK", thus, the 
//itinerary must begin with "JFK". If there are multiple valid itineraries, you should 
//return the itinerary that has the smallest lexical order when read as a single 
//string. 
//
// 
// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than [
//"JFK", "LGB"]. 
// 
//
// You may assume all tickets form at least one valid itinerary. You must use 
//all the tickets once and only once. 
//
// 
// Example 1: 
//
// 
//Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//Output: ["JFK","MUC","LHR","SFO","SJC"]
// 
//
// Example 2: 
//
// 
//Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],[
//"ATL","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK",
//"ATL","SFO"] but it is larger in lexical order.
// 
//
// 
// Constraints: 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi and toi consist of uppercase English letters. 
// fromi != toi 
// 
// Related Topics 深度优先搜索 图 欧拉回路 👍 537 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    //used数组用于标记同一树枝不能重复使用！即不能重复使用一张票
    boolean[] used = new boolean[301];
    boolean find;

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));
        path.add("JFK");
        backTracking(tickets, "JFK");
        return res;
    }

    void backTracking(List<List<String>> tickets, String curLocation) {
        // no need to check more routes
        if (find) {
            return;
        }
        // found a path
        if (path.size() == tickets.size() + 1) {
            find = true;
            // assign a list (important)
            res = new ArrayList<>(path);
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(curLocation) && !used[i]) {
                used[i] = true;
                path.add(tickets.get(i).get(1));
                backTracking(tickets, tickets.get(i).get(1));
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
