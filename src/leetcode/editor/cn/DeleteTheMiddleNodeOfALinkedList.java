/**
  * 题目Id：2095
  * 题目：Delete the Middle Node of a Linked List
  * 日期：2022-03-14 04:44:12
*/
//You are given the head of a linked list. Delete the middle node, and return 
//the head of the modified linked list. 
//
// The middle node of a linked list of size n is the ⌊n / 2⌋ᵗʰ node from the 
//start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or 
//equal to x. 
//
// 
// For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, 
//respectively. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [1,3,4,7,1,2,6]
//Output: [1,3,4,1,2,6]
//Explanation:
//The above figure represents the given linked list. The indices of the nodes 
//are written below.
//Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
//We return the new list after removing this node. 
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,2,4]
//Explanation:
//The above figure represents the given linked list.
//For n = 4, node 2 with value 3 is the middle node, which is marked in red.
// 
//
// Example 3: 
//
// 
//Input: head = [2,1]
//Output: [2]
//Explanation:
//The above figure represents the given linked list.
//For n = 2, node 1 with value 1 is the middle node, which is marked in red.
//Node 0 with value 2 is the only node remaining after removing node 1. 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 1 <= Node.val <= 10⁵ 
// 
// Related Topics 链表 双指针 👍 13 👎 0

package leetcode.editor.cn;
public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        Solution solution = new DeleteTheMiddleNodeOfALinkedList().new Solution();
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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
