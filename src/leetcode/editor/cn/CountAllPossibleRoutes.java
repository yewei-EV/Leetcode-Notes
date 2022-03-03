/**
  * 题目Id：1575
  * 题目：Count All Possible Routes
  * 日期：2022-03-03 12:11:13
*/
//You are given an array of distinct positive integers locations where 
//locations[i] represents the position of city i. You are also given integers start, 
//finish and fuel representing the starting city, ending city, and the initial amount 
//of fuel you have, respectively. 
//
// At each step, if you are at city i, you can pick any city j such that j != i 
//and 0 <= j < locations.length and move to city j. Moving from city i to city j 
//reduces the amount of fuel you have by |locations[i] - locations[j]|. Please 
//notice that |x| denotes the absolute value of x. 
//
// Notice that fuel cannot become negative at any point in time, and that you 
//are allowed to visit any city more than once (including start and finish). 
//
// Return the count of all possible routes from start to finish. Since the 
//answer may be too large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
//Output: 4
//Explanation: The following are all possible routes, each uses 5 units of fuel:
//
//1 -> 3
//1 -> 2 -> 3
//1 -> 4 -> 3
//1 -> 4 -> 2 -> 3
// 
//
// Example 2: 
//
// 
//Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
//Output: 5
//Explanation: The following are all possible routes:
//1 -> 0, used fuel = 1
//1 -> 2 -> 0, used fuel = 5
//1 -> 2 -> 1 -> 0, used fuel = 5
//1 -> 0 -> 1 -> 0, used fuel = 3
//1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5
// 
//
// Example 3: 
//
// 
//Input: locations = [5,2,1], start = 0, finish = 2, fuel = 3
//Output: 0
//Explanation: It is impossible to get from 0 to 2 using only 3 units of fuel 
//since the shortest route needs 4 units of fuel.
// 
//
// 
// Constraints: 
//
// 
// 2 <= locations.length <= 100 
// 1 <= locations[i] <= 10⁹ 
// All integers in locations are distinct. 
// 0 <= start, finish < locations.length 
// 1 <= fuel <= 200 
// 
// Related Topics 记忆化搜索 数组 动态规划 👍 56 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class CountAllPossibleRoutes {
    public static void main(String[] args) {
        Solution solution = new CountAllPossibleRoutes().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] memo = new long[locations.length][fuel+1];
        for(int i=0; i < memo.length; i++) Arrays.fill(memo[i],-1L);
        return (int)helper(locations, start, finish, fuel, memo);
    }

    public long helper(int[] locations, int cur, int finish, int fuel, long[][] memo) {
        if (fuel < 0) {
            return 0;
        }
        if (memo[cur][fuel] != -1L) return memo[cur][fuel];
        long count = 0;
        if (cur == finish) {
            count = 1;
        }
        for (int i = 0; i < locations.length; i++) {
            if (i == cur) continue;
            // fuel is not enough for this position
            if (fuel < Math.abs(locations[cur] - locations[i])) {
                continue;
            }
            count = (count + helper(locations, i, finish,
                    (fuel - Math.abs(locations[cur] - locations[i])), memo))%1000000007;
        }
        memo[cur][fuel] = count;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
