/**
  * 题目Id：445
  * 题目：Add Two Numbers II
  * 日期：2022-01-11 11:51:37
*/
//You are given two non-empty linked lists representing two non-negative 
//integers. The most significant digit comes first and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
// 
//
// Example 3: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// 
// Follow up: Could you solve it without reversing the input lists? 
// Related Topics 栈 链表 数学 👍 461 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while(carry != 0 || stack1.size()!= 0 || stack2.size() != 0) {
            int a = stack1.size() == 0 ? 0 : stack1.pop();
            int b = stack2.size() == 0 ? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum/10;
            sum = sum % 10;
            ListNode cur = new ListNode(sum);
            cur.next = ans;
            ans = cur;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
