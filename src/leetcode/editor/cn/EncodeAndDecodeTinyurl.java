/**
  * 题目Id：535
  * 题目：Encode and Decode TinyURL
  * 日期：2022-01-28 23:15:31
*/
//Note: This is a companion problem to the System Design problem: Design 
//TinyURL. 
//
// TinyURL is a URL shortening service where you enter a URL such as https://
//leetcode.com/problems/design-tinyurl and it returns a short URL such as http://
//tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL. 
//
// There is no restriction on how your encode/decode algorithm should work. You 
//just need to ensure that a URL can be encoded to a tiny URL and the tiny URL 
//can be decoded to the original URL. 
//
// Implement the Solution class: 
//
// 
// Solution() Initializes the object of the system. 
// String encode(String longUrl) Returns a tiny URL for the given longUrl. 
// String decode(String shortUrl) Returns the original long URL for the given 
//shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
// 
// 
//
// 
// Example 1: 
//
// 
//Input: url = "https://leetcode.com/problems/design-tinyurl"
//Output: "https://leetcode.com/problems/design-tinyurl"
//
//Explanation:
//Solution obj = new Solution();
//string tiny = obj.encode(url); // returns the encoded tiny url.
//string ans = obj.decode(tiny); // returns the original url after deconding it.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= url.length <= 10⁴ 
// url is guranteed to be a valid URL. 
// 
// Related Topics 设计 哈希表 字符串 哈希函数 👍 136 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class EncodeAndDecodeTinyurl {
    public static void main(String[] args) {
        Solution solution = new EncodeAndDecodeTinyurl().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

        HashMap<Character, String> huffmanTable;
        Node root;

        //Huffman Tree Node
        class Node {
            char c;
            int val;
            Node left, right;

            Node(char c, int val) {
                this.c = c;
                this.val = val;
                this.left = null;
                this.right = null;
            }
            Node(char c, int val, Node left, Node right) {
                this.c = c;
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        void createHuffmanTable(Node node, String encoding) {
            if(node.left == null && node.right == null) {
                huffmanTable.put(node.c, encoding);
                // System.out.println(node.c + " ~ " + encoding + " ~ " + f.get(node.c)); // Prints all character's encoding and frequency
                return;
            }

            createHuffmanTable(node.left, encoding + "0");
            createHuffmanTable(node.right, encoding + "1");
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int len = longUrl.length();

            huffmanTable = new HashMap<>(); // HashMap containing each unique character and its Huffman encoding ('a' -> '000', 'b' -> '110' etc.)
            HashMap<Character,Integer> f = new HashMap<>(); // HashMap containing each unique character and its frequency ('a' -> 2, 'b' -> 5 etc.)

            // Filling HashMap with each unique character and its frequency in longUrl
            for(int i = 0 ; i < len; i++) {
                char c = longUrl.charAt(i);
                if(!f.containsKey(c)) {
                    f.put(c, 0);  // Create an entry for new unique character found in longUrl
                }
                f.put(c, f.get(c) + 1);  // Increase its frequency by 1
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(len, (a, b) -> a.val - b.val); // For building Huffman Tree
            for(Map.Entry<Character, Integer> entry : f.entrySet()) {
                pq.add(new Node(entry.getKey(), entry.getValue())); // Add all unique characters present in url to priority queue (based on their frequency)
            }

            root = null; // Root of HuffmanTree

            // We run this till we have only one node left in priority queue and this remaining last node will be the root of our Huffman tree
            while(pq.size() > 1) {
                Node a = pq.poll(); // 1st Minimum frequency character in Priority Queue
                Node b = pq.poll(); // 2nd Minimum frequency character in Priority Queue
                Node node = new Node('\u0000', a.val + b.val, a, b); // Create a new Node with frequency as 'sum of a's frequency and b's frequency'
                root = node;
                pq.add(node);       // Push newly created node back into priority queue
            }

            createHuffmanTable(root, ""); // Filling huffmanTable to see our encodings

            StringBuilder url = new StringBuilder("http://tinyurl.com/");
            for(int i = 0 ; i < len ; i++) {
                char c = longUrl.charAt(i);
                url.append(huffmanTable.get(c));
            }

            return url.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int len = shortUrl.length();
            StringBuilder url = new StringBuilder();
            // {0..18} is "http://tinyurl.com/" so ignore it during decoding
            int i = 19;
            while (i < len) {
                Node node = root;
                while (node.left != null && node.right != null) {
                    if (shortUrl.charAt(i) == '0') {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                    i++;
                }
                url.append(node.c);
            }
            return url.toString();
        }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

}
