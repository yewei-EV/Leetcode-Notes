/**
  * 题目Id：143
  * 题目：Reorder List
  * 日期：2022-01-01 20:22:47
*/
//You are given the head of a singly linked-list. The list can be represented 
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 741 👎 0

package leetcode.editor.cn;
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = middleNode(head);
        ListNode head1 = head;
        ListNode head2 = middle.next;
        middle.next = null;
        head2 = reverseList(head2);
        mergetList(head1, head2);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public void mergetList(ListNode head1, ListNode head2) {
        ListNode tmp1;
        ListNode tmp2;
        while (head1 != null && head2 != null) {
            tmp1 = head1.next;
            tmp2 = head2.next;
            head1.next = head2;
            head1 = tmp1;
            head2.next = head1;
            head2 = tmp2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
