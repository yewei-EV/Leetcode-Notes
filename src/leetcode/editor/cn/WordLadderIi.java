/**
  * 题目Id：126
  * 题目：Word Ladder II
  * 日期：2022-02-24 17:28:38
*/
//A transformation sequence from word beginWord to word endWord using a 
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// 
//
// 
// Every adjacent pair of words differs by a single letter. 
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need 
//to be in wordList. 
// sk == endWord 
// 
//
// Given two words, beginWord and endWord, and a dictionary wordList, return 
//all the shortest transformation sequences from beginWord to endWord, or an empty 
//list if no such sequence exists. Each sequence should be returned as a list of 
//the words [beginWord, s1, s2, ..., sk]. 
//
// 
// Example 1: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//Explanation: There are 2 shortest transformation sequences:
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// Example 2: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: []
//Explanation: The endWord "cog" is not in wordList, therefore there is no 
//valid transformation sequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beginWord.length <= 5 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 1000 
// wordList[i].length == beginWord.length 
// beginWord, endWord, and wordList[i] consist of lowercase English letters. 
// beginWord != endWord 
// All the words in wordList are unique. 
// 
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 541 👎 0

package leetcode.editor.cn;

import java.util.*;

public class WordLadderIi {
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;
        // collecting PATH in queue
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Collections.singletonList(beginWord));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
//            System.out.println(queue);
            while (size-- > 0) {
                List<String> cur = queue.poll();
                String lastWord = cur.get(cur.size() - 1);
                List<String> neighbors = getNeighbors(lastWord, dict, visited);
                for (String neighbor : neighbors) {
                    List<String> newPath = new ArrayList<>(cur);
                    newPath.add(neighbor);
                    // cannot set visited in this loop
//                    visited.add(neighbor);
                    if (neighbor.equals(endWord)) {
                        ans.add(newPath);
                    } else {
                        queue.offer(newPath);
                    }
                }
            }
            for (List<String> strings : queue) {
                visited.add(strings.get(strings.size() - 1));
            }
            if (ans.size() > 0) break;
        }
        return ans;
    }

    public List<String> getNeighbors(String word, Set<String> dict, Set<String> visited) {
        List<String> res = new ArrayList<>();
        char[] charArrays = word.toCharArray();
        for (int i = 0; i < charArrays.length; i++) {
            char temp = charArrays[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charArrays[i] = c;
                String next = String.valueOf(charArrays);
                if (!visited.contains(next) && dict.contains(next)) {
                    res.add(next);
                }
            }
            charArrays[i] = temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
