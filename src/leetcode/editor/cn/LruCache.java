/**
  * 题目Id：146
  * 题目：LRU Cache
  * 日期：2021-12-27 21:03:45
*/
//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1801 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class LruCache {
    public static void main(String[] args) {
        Solution solution = new LruCache().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    Node head;
    Node tail;

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node n) {
        head.next.prev = n;
        n.prev = head;
        n.next = head.next;
        head.next = n;
    }
    void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    Node removeLast() {
        Node res = tail.prev;
        remove(res);
        return res;
    }

}

class LRUCache {

    HashMap<Integer,Node> map;
    DoubleList cache;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        cap = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node res = map.get(key);
        //delete res and add it to the first
        cache.remove(res);
        cache.addFirst(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        Node n = new Node(key, value);
        if(map.containsKey(key)) {
            cache.remove(map.get(key));
        } else if(map.size() == cap) {
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(n);
        map.put(key, n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
