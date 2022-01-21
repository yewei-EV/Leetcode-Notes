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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> startQueue = new HashSet<>();
        HashSet<String> endQueue = new HashSet<>();
        HashSet<String> wordDict = new HashSet<>(wordList);
        int length = 1;
        startQueue.add(beginWord);
        endQueue.add(endWord);
        if (!wordDict.contains(endWord)) return 0;
        while (startQueue.size() != 0) {
            length++;
            wordDict.removeAll(startQueue);
            HashSet<String> tmpSet = new HashSet<>();
            for (String s: startQueue) {
                char[] arr = s.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char tmp = arr[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(tmp == c) continue;
                        arr[i] = c;
                        String strTmp = new String(arr);
                        if (wordDict.contains(strTmp)){
                            if (endQueue.contains(strTmp)){
                                return length;
                            } else {
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    arr[i] = tmp;
                }
            }
            if (tmpSet.size() < endQueue.size()) {
                startQueue = tmpSet;
            } else {
                startQueue = endQueue;
                endQueue = tmpSet;
            }
        }
        return 0;
    }

        //Normal BFS
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        boolean[] marked = new boolean[wordList.size() + 1];
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
    public boolean isValid(String target, String word) {
        int count = 0;
        for (int i = 0; i < target.length(); ++i) {
            if (target.charAt(i) != word.charAt(i)) {
                if (count == 1) {
                    return false;
                } else {
                    count++;
                }
            }
        }
        return count == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
