/**
  * 题目Id：460
  * 题目：LFU Cache
  * 日期：2021-12-27 22:07:44
*/
//Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data 
//structure. 
// int get(int key) Gets the value of the key if the key exists in the cache. 
//Otherwise, returns -1. 
// void put(int key, int value) Update the value of the key if present, or 
//inserts the key if not already present. When the cache reaches its capacity, it 
//should invalidate and remove the least frequently used key before inserting a new 
//item. For this problem, when there is a tie (i.e., two or more keys with the same 
//frequency), the least recently used key would be invalidated. 
// 
//
// To determine the least frequently used key, a use counter is maintained for 
//each key in the cache. The key with the smallest use counter is the least 
//frequently used key. 
//
// When a key is first inserted into the cache, its use counter is set to 1 (
//due to the put operation). The use counter for a key in the cache is incremented 
//either a get or put operation is called on it. 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element 
//is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, 
//invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 0 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 471 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LfuCache {
    public static void main(String[] args) {
        Solution solution = new LfuCache().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        int time;
        int capacity;
        Map<Integer, Node> cache;
        TreeSet<Node> set;

        public LFUCache(int capacity) {
            this.time = 0;
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.set = new TreeSet<>();
        }

        public int get(int key) {
            if (capacity == 0 || !cache.containsKey(key)) return -1;
            Node newNode = cache.get(key);
            set.remove(newNode);
            newNode.cnt++;
            newNode.time = time;
            set.add(newNode);
            return newNode.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (!cache.containsKey(key)) {
                // if over capacity
                if (cache.size() == capacity) {
                    cache.remove(set.first().key);
                    set.remove(set.first());
                }
                Node node = new Node(1, time, key, value);
                cache.put(key, node);
                set.add(node);
            } else {
                Node newNode = cache.get(key);
                set.remove(newNode);
                newNode.cnt++;
                newNode.time = time;
                newNode.value = value;
                set.add(newNode);
                cache.put(key, newNode);
            }
            time++;
        }

    }

    class Node implements Comparable<Node> {
        int cnt;
        int time;
        int key;
        int value;

        public Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node object = (Node) o;
                return object.cnt == this.cnt && object.time == this.time;
            }
            return false;
        }

        public int hashCode() {
            return cnt * 1000000007 + time;
        }

        @Override
        public int compareTo(Node o) {
            return cnt == o.cnt ? time - o.time : cnt - o.cnt;
        }
    }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
