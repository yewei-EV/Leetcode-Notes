/**
  * 题目Id：692
  * 题目：Top K Frequent Words
  * 日期：2022-02-22 17:36:35
*/
//Given an array of strings words and an integer k, return the k most frequent 
//strings. 
//
// Return the answer sorted by the frequency from highest to lowest. Sort the 
//words with the same frequency by their lexicographical order. 
//
// 
// Example 1: 
//
// 
//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
//Explanation: "i" and "love" are the two most frequent words.
//Note that "i" comes before "love" due to a lower alphabetical order.
// 
//
// Example 2: 
//
// 
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
// k = 4
//Output: ["the","is","sunny","day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
//with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] consists of lowercase English letters. 
// k is in the range [1, The number of unique words[i]] 
// 
//
// 
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space? 
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 430 👎 0

package leetcode.editor.cn;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        // Min Heap
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
