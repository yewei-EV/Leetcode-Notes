/**
  * 题目Id：677
  * 题目：Map Sum Pairs
  * 日期：2022-01-14 00:34:21
*/
//Design a map that allows you to do the following: 
//
// 
// Maps a string key to a given value. 
// Returns the sum of the values that have a key with a prefix equal to a given 
//string. 
// 
//
// Implement the MapSum class: 
//
// 
// MapSum() Initializes the MapSum object. 
// void insert(String key, int val) Inserts the key-val pair into the map. If 
//the key already existed, the original key-value pair will be overridden to the 
//new one. 
// int sum(string prefix) Returns the sum of all the pairs' value whose key 
//starts with the prefix. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//Output
//[null, null, 3, null, 5]
//
//Explanation
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key and prefix consist of only lowercase English letters. 
// 1 <= val <= 1000 
// At most 50 calls will be made to insert and sum. 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 187 👎 0

package leetcode.editor.cn;
public class MapSumPairs {
    public static void main(String[] args) {
        Solution solution = new MapSumPairs().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    TrieNode root;

    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    public MapSum() {
        this.root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = this.root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
        }
        node.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return dfs(node);
    }

    private int dfs(TrieNode root) {
        if (root == null) return 0;
        int res = 0;
        res += root.val;
        for (TrieNode node : root.next) {
            res += dfs(node);
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
