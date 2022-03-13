/**
  * 题目Id：1019
  * 题目：Next Greater Node In Linked List
  * 日期：2022-03-11 08:54:00
*/
//You are given the head of a linked list with n nodes. 
//
// For each node in the list, find the value of the next greater node. That is, 
//for each node, find the value of the first node that is next to it and has a 
//strictly larger value than it. 
//
// Return an integer array answer where answer[i] is the value of the next 
//greater node of the iᵗʰ node (1-indexed). If the iᵗʰ node does not have a next 
//greater node, set answer[i] = 0. 
//
// 
// Example 1: 
//
// 
//Input: head = [2,1,5]
//Output: [5,5,0]
// 
//
// Example 2: 
//
// 
//Input: head = [2,7,4,3,5]
//Output: [7,0,5,5,0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
// Related Topics 栈 数组 链表 单调栈 👍 191 👎 0

package leetcode.editor.cn;

import java.util.*;

public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // descending monotonic stack
        List<Integer> link = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        while(head != null) {
            int cur = head.val;
            while(!stack.isEmpty() && link.get(stack.peek()) < cur) {
                Integer i = stack.pop();
                link.set(i, cur);
            }
            stack.push(index);
            link.add(cur);
            index++;
            head = head.next;
        }
        while (!stack.isEmpty()){
            link.set(stack.pop(), 0);
        }
        return link.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
