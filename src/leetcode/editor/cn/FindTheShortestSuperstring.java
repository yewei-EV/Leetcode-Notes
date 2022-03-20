/**
  * 题目Id：943
  * 题目：Find the Shortest Superstring
  * 日期：2022-01-22 13:00:31
*/
//Given an array of strings words, return the smallest string that contains 
//each string in words as a substring. If there are multiple valid strings of the 
//smallest length, return any of them. 
//
// You may assume that no string in words is a substring of another string in 
//words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["alex","loves","leetcode"]
//Output: "alexlovesleetcode"
//Explanation: All permutations of "alex","loves","leetcode" would also be 
//accepted.
// 
//
// Example 2: 
//
// 
//Input: words = ["catg","ctaagt","gcta","ttca","atgcatc"]
//Output: "gctaagttcatgcatc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 12 
// 1 <= words[i].length <= 20 
// words[i] consists of lowercase English letters. 
// All the strings of words are unique. 
// 
// Related Topics 位运算 数组 字符串 动态规划 状态压缩 👍 97 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheShortestSuperstring {
    public static void main(String[] args) {
        Solution solution = new FindTheShortestSuperstring().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mn = Integer.MAX_VALUE;
    int[][] overlaps;
    List<Integer> bestOrder;
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        //count the overlaps between word i followed by word j
        overlaps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = Math.min(words[i].length(), words[j].length()); k > 0; k--) {
                    if (words[i].substring(words[i].length() - k).equals(words[j].substring(0, k))) {
                        overlaps[i][j] = k;
                        break;
                    }
                }
            }
        }
        int[] path = new int[n];
        dfs(words, 0, 0, 0, path);
//        System.out.println(bestOrder);
        StringBuilder ans = new StringBuilder(words[bestOrder.get(0)]);
        for (int k = 1; k < bestOrder.size(); k++) {
            int i = bestOrder.get(k - 1);
            int j = bestOrder.get(k);
            ans.append(words[j].substring(overlaps[i][j]));
        }
        return ans.toString();
    }

    public void dfs(String[] words, int depth, int used, int curLen, int[] path) {
        // pruning
        if (curLen >= mn) return;
        // reach the end
        if (depth >= words.length) {
            mn = curLen;
            bestOrder = Arrays.stream(path).boxed().collect(Collectors.toList());
            return;
        }
        for (int i = 0; i < words.length; i++) {
            //Note: != 0 instead of == 1
            if ((used & (1 << i)) != 0) {
                continue;
            }
            path[depth] = i;
            int nextLen = (depth == 0) ? words[i].length() : curLen + words[i].length() - overlaps[path[depth - 1]][i];
            dfs(words, depth + 1, (used | (1 << i)), nextLen, path);
        }
    }

//        public String shortestSuperstring(String[] A) {
//            int n = A.length;
//            int[][] overlaps = new int[n][n];
//            for (int i = 0 ; i < n ; i++) {
//                for (int j = 0 ; j  < n ; j++) {
//                    if (i == j) continue;
//                    int m = Math.min(A[i].length(), A[j].length());
//                    for (int k = m ; k >= 0 ; k--) {
//                        if (A[i].endsWith(A[j].substring(0, k))) {
//                            overlaps[i][j] = k;
//                            break;
//                        }
//                    }
//                }
//            }
//            String[][] dp = new String[1 << n][n];
//            String res = null;
//            for (int i = 0 ; i < n ; i++){
//                int status = 1 << i;
//                String s = A[i] + dfs(A, dp, overlaps, status, i);
//                if (res == null || res.length() > s.length()){
//                    res = s;
//                }
//            }
//            return res;
//        }
//
//        private String dfs(String[] A, String[][] dp, int[][] overlaps, int status, int pre) {
//            int n = A.length;
//            if (status == (1 << n) - 1) {
//                return "";
//            }
//            if (dp[status][pre] != null) {
//                return dp[status][pre];
//            }
//            String res = null;
//            for (int i = 0 ; i < n ; i++) {
//                if ((status & (1 << i)) == 0) {
//                    int newStatus = status | (1 << i);
//                    String s = A[i].substring(overlaps[pre][i]) + dfs(A, dp, overlaps, newStatus, i);
//                    if (res == null || res.length() > s.length()) {
//                        res = s;
//                    }
//                }
//            }
//            dp[status][pre] = res;
//            return res;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
