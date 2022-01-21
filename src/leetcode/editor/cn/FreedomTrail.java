/**
  * 题目Id：514
  * 题目：Freedom Trail
  * 日期：2021-12-13 22:09:42
*/
//In the video game Fallout 4, the quest "Road to Freedom" requires players to 
//reach a metal dial called the "Freedom Trail Ring" and use the dial to spell a 
//specific keyword to open the door. 
//
// Given a string ring that represents the code engraved on the outer ring and 
//another string key that represents the keyword that needs to be spelled, return 
//the minimum number of steps to spell all the characters in the keyword. 
//
// Initially, the first character of the ring is aligned at the "12:00" 
//direction. You should spell all the characters in key one by one by rotating ring 
//clockwise or anticlockwise to make each character of the string key aligned at the "12
//:00" direction and then by pressing the center button. 
//
// At the stage of rotating the ring to spell the key character key[i]: 
//
// 
// You can rotate the ring clockwise or anticlockwise by one place, which 
//counts as one step. The final purpose of the rotation is to align one of ring's 
//characters at the "12:00" direction, where this character must equal key[i]. 
// If the character key[i] has been aligned at the "12:00" direction, press the 
//center button to spell, which also counts as one step. After the pressing, you 
//could begin to spell the next character in the key (next stage). Otherwise, you 
//have finished all the spelling. 
// 
//
// 
// Example 1: 
//
// 
//Input: ring = "godding", key = "gd"
//Output: 4
//Explanation:
//For the first key character 'g', since it is already in place, we just need 1 
//step to spell this character. 
//For the second key character 'd', we need to rotate the ring "godding" 
//anticlockwise by two steps to make it become "ddinggo".
//Also, we need 1 more step for spelling.
//So the final output is 4.
// 
//
// Example 2: 
//
// 
//Input: ring = "godding", key = "godding"
//Output: 13
// 
//
// 
// Constraints: 
//
// 
// 1 <= ring.length, key.length <= 100 
// ring and key consist of only lower case English letters. 
// It is guaranteed that key could always be spelled by rotating ring. 
// 
// Related Topics 深度优先搜索 广度优先搜索 字符串 动态规划 👍 220 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail {
    public static void main(String[] args) {
        Solution solution = new FreedomTrail().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP store <current pointed ring index + current key index, steps>
    Map<String, Integer> cache = new HashMap<>();
    Map<Character, List<Integer>> map = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        int len = ring.length();
        for (int i = 0; i < len; ++i) {
            if (!map.containsKey(ring.charAt(i))) {
                map.put(ring.charAt(i), new ArrayList<>());
            }
            map.get(ring.charAt(i)).add(i);
        }
        return key.length() + dfs(ring, key, 0, 0);
    }

    public int dfs(String ring, String key, int ringIndex, int keyIndex) {
        if (keyIndex == key.length()) {
            return 0;
        }
        String cacheKey = ringIndex+"_"+keyIndex;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        int res = Integer.MAX_VALUE;
        char targetChar = key.charAt(keyIndex);
        for (int targetIndex : map.get(targetChar)) {
            int dis = Math.min(Math.abs(ringIndex - targetIndex), ring.length() - Math.abs(ringIndex - targetIndex));
            res = Math.min(res, dis + dfs(ring, key, targetIndex, keyIndex + 1));
        }
        cache.put(cacheKey, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
