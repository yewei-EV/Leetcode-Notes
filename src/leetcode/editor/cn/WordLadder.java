/**
  * 题目Id：127
  * 题目：Word Ladder
  * 日期：2021-12-12 17:53:02
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
//the number of words in the shortest transformation sequence from beginWord to 
//endWord, or 0 if no such sequence exists. 
//
// 
// Example 1: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
//> "dog" -> cog", which is 5 words long.
// 
//
// Example 2: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no 
//valid transformation sequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord, endWord, and wordList[i] consist of lowercase English letters. 
// beginWord != endWord 
// All the words in wordList are unique. 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 912 👎 0

package leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Set<String> startQ = new HashSet<>();
        Set<String> endQ = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        startQ.add(beginWord);
        endQ.add(endWord);
        int step = 1;
        while (!startQ.isEmpty()) {
            step++;
            // delete visited element from dict
            dict.removeAll(startQ);
            int size = startQ.size();
            Set<String> tempQ = new HashSet<>();
            while (size-- > 0) {
                for (String cur : startQ) {
                    // find valid neighbors of cur
                    for (String neighbor : getNeighbors(dict, cur)) {
                        // check if neighbor is in endQ
                        if (endQ.contains(neighbor)) {
                            return step;
                        } else {
                            tempQ.add(neighbor);
                        }
                    }
                }
            }
            // set tempQ to startQ or endQ
            if (tempQ.size() >= endQ.size()) {
                startQ = endQ;
                endQ = tempQ;
            } else {
                startQ = tempQ;
            }
        }
        return 0;
    }

    public Set<String> getNeighbors(Set<String> dict, String word) {
        Set<String> res = new HashSet<>();
        char[] charArrays = word.toCharArray();
        for (int i = 0; i < charArrays.length; i++) {
            char temp = charArrays[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charArrays[i] = c;
                String next = String.valueOf(charArrays);
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
            charArrays[i] = temp;
        }
        return res;
    }

        //Normal BFS
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        boolean[] marked = new boolean[wordList.size()];
//        int length = 1;
//        while (queue.size() != 0) {
//            length++;
//            int size = queue.size();
//            while (size-- > 0) {
//                String cur = queue.poll();
//                for (int j = 0; j < wordList.size(); j++) {
//                    if (!marked[j] && isValid(cur, wordList.get(j))) {
//                        if (wordList.get(j).equals(endWord)) {
//                            return length;
//                        }
//                        queue.add(wordList.get(j));
//                        marked[j] = true;
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    public boolean isValid(String target, String word) {
//        int count = 0;
//        for (int i = 0; i < target.length(); ++i) {
//            if (target.charAt(i) != word.charAt(i)) {
//                if (count == 1) {
//                    return false;
//                } else {
//                    count++;
//                }
//            }
//        }
//        return count == 1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
