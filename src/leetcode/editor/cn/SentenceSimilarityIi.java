/**
  * 题目Id：737
  * 题目：Sentence Similarity II
  * 日期：2021-12-30 22:33:41
*/
//We can represent a sentence as an array of words, for example, the sentence 
//"I am happy with leetcode" can be represented as arr = ["I","am",happy","with",
//"leetcode"]. 
//
// Given two sentences sentence1 and sentence2 each represented as a string 
//array and given an array of string pairs similarPairs where similarPairs[i] = [xi, 
//yi] indicates that the two words xi and yi are similar. 
//
// Return true if sentence1 and sentence2 are similar, or false if they are not 
//similar. 
//
// Two sentences are similar if: 
//
// 
// They have the same length (i.e., the same number of words) 
// sentence1[i] and sentence2[i] are similar. 
// 
//
// Notice that a word is always similar to itself, also notice that the 
//similarity relation is transitive. For example, if the words a and b are similar, and 
//the words b and c are similar, then a and c are similar. 
//
// 
// Example 1: 
//
// 
//Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama",
//"talent"], similarPairs = [["great","good"],["fine","good"],["drama","acting"],[
//"skills","talent"]]
//Output: true
//Explanation: The two sentences have the same length and each word i of 
//sentence1 is also similar to the corresponding word in sentence2.
// 
//
// Example 2: 
//
// 
//Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love",
//"onepiece"], similarPairs = [["manga","onepiece"],["platform","anime"],["leetcode",
//"platform"],["anime","manga"]]
//Output: true
//Explanation: "leetcode" --> "platform" --> "anime" --> "manga" --> "onepiece".
//
//Since "leetcode is similar to "onepiece" and the first two words are the same,
// the two sentences are similar. 
//
// Example 3: 
//
// 
//Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love",
//"onepiece"], similarPairs = [["manga","hunterXhunter"],["platform","anime"],["leetcode",
//"platform"],["anime","manga"]]
//Output: false
//Explanation: "leetcode" is not similar to "onepiece".
// 
//
// 
// Constraints: 
//
// 
// 1 <= sentence1.length, sentence2.length <= 1000 
// 1 <= sentence1[i].length, sentence2[i].length <= 20 
// sentence1[i] and sentence2[i] consist of lower-case and upper-case English 
//letters. 
// 0 <= similarPairs.length <= 2000 
// similarPairs[i].length == 2 
// 1 <= xi.length, yi.length <= 20 
// xi and yi consist of English letters. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 👍 53 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityIi {
    public static void main(String[] args) {
        Solution solution = new SentenceSimilarityIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Integer> index = new HashMap();
        int count = 0;
        UnionFind uf = new UnionFind(2 * similarPairs.size());
        for (List<String> pair: similarPairs) {
            for (String p: pair) {
                if (!index.containsKey(p)) {
                    index.put(p, count++);
                }
            }
            uf.union(index.get(pair.get(0)), index.get(pair.get(1)));
        }

        for (int i = 0; i < sentence1.length; ++i) {
            String w1 = sentence1[i], w2 = sentence2[i];
            if (w1.equals(w2)) continue;
            if (!index.containsKey(w1) || !index.containsKey(w2) ||
                    uf.find(index.get(w1)) != uf.find(index.get(w2)))
                return false;
        }
        return true;
    }

    class UnionFind {
        private int[] roots;

        public UnionFind(int size){
            this.roots = new int[size];
            for (int i = 0; i < size; i++){
                roots[i] = i;
            }
        }
        public int find(int x){
            if(roots[x] != x){
                roots[x] = find(roots[x]);
            }
            return roots[x];
        }
        public void union(int x, int y){
            int root1 = find(x);
            int root2 = find(y);
            if (root1 != root2){
                roots[root1] = root2;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
