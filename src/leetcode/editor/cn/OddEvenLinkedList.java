/**
  * 题目Id：328
  * 题目：Odd Even Linked List
  * 日期：2022-01-11 11:52:08
*/
//Given the head of a singly linked list, group all the nodes with odd indices 
//together followed by the nodes with even indices, and return the reordered list. 
//
//
// The first node is considered odd, and the second node is even, and so on. 
//
// Note that the relative order inside both the even and odd groups should 
//remain as it was in the input. 
//
// You must solve the problem in O(1) extra space complexity and O(n) time 
//complexity. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
// 
//
// 
// Constraints: 
//
// 
// n == number of nodes in the linked list 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
// Related Topics 链表 👍 517 👎 0

package leetcode.editor.cn;
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        // oddHead is head
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

//        // 空链表
//        if (head == null) return null;
//
//        // 偶数节点链表
//        ListNode evenHead = new ListNode();
//        ListNode evenTail = evenHead;
//        // 奇数节点链表
//        ListNode oddHead = new ListNode();
//        ListNode oddTail = oddHead;
//
//        int num = 1;
//        while (head != null) {
//            if (num % 2 == 0) {
//                evenTail.next = new ListNode(head.val);
//                evenTail = evenTail.next;
//            } else {
//                oddTail.next = new ListNode(head.val);
//                oddTail = oddTail.next;
//            }
//            num++;
//            head = head.next;
//        }
//
//        oddTail.next = evenHead.next;
//        return oddHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
