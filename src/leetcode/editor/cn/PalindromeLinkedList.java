/**
  * 题目Id：234
  * 题目：Palindrome Linked List
  * 日期：2022-01-11 11:51:48
*/
//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics 栈 递归 链表
// 双指针 👍 1226 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
//    ListNode first = null;
    public boolean isPalindrome(ListNode head) {
        //recursion
//        first = head;
//        return recursion(head);

        //slow-fast pointer
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode reverseNode = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            //important
            ListNode temp = slow.next;
            slow.next = reverseNode;
            reverseNode = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while(slow != null && reverseNode != null) {
            if (slow.val != reverseNode.val) {
                return false;
            }
            slow = slow.next;
            reverseNode = reverseNode.next;
        }
        return true;



//        Deque<Integer> queue = new LinkedList<>();
//        ListNode cur = head;
//        while(cur != null) {
//            queue.push(cur.val);
//            cur = cur.next;
//        }
//        while(head != null) {
//            if (queue.pop() != head.val) {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
    }

//    public boolean recursion(ListNode head) {
//        if(head != null) {
//            if(!recursion(head.next)) {
//                return false;
//            }
//            if(head.val != first.val) {
//                return false;
//            }
//            first = first.next;
//        }
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
