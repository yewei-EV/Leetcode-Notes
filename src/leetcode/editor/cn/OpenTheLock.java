/**
  * 题目Id：752
  * 题目：Open the Lock
  * 日期：2021-12-13 17:59:55
*/
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 
//slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
//freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
//Each move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the 
//lock, return the minimum total number of turns required to open the lock, or -1 if 
//it is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
//would be invalid,
//because the wheels of the lock become stuck after the display becomes the 
//dead end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
// 
//
// Example 4: 
//
// 
//Input: deadends = ["0000"], target = "8888"
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 422 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> startQ = new HashSet<>();
        HashSet<String> endQ = new HashSet<>();
        int length = 1;
        startQ.add("0000");
        endQ.add(target);
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        //special case
        if (target.equals("0000")) return 0;
        if (deadSet.contains(target) || deadSet.contains("0000")) return -1;
        while (startQ.size() != 0) {
            deadSet.addAll(startQ);
            HashSet<String> tempSet = new HashSet<>();
            for (String s: startQ) {
                List<String> nexts = getNexts(s);
                for (String next : nexts) {
                    if (!deadSet.contains(next)) {
                        if (endQ.contains(next)) {
                            return length;
                        }
                        tempSet.add(next);
                    }
                }
            }
            if (tempSet.size() < endQ.size()) {
                startQ = tempSet;
            } else {
                startQ = endQ;
                endQ = tempSet;
            }
            length++;
        }
        return -1;
    }

    public List<String> getNexts(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringBuilder next = new StringBuilder(cur);
            next.setCharAt(i, cur.charAt(i) == '0'?'9' : (char)(cur.charAt(i) - 1));
            list.add(next.toString());
            next.setCharAt(i, cur.charAt(i) == '9'?'0' : (char)(cur.charAt(i) + 1));
            list.add(next.toString());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
