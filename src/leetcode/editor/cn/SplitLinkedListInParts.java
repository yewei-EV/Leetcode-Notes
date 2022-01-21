/**
  * 题目Id：725
  * 题目：Split Linked List in Parts
  * 日期：2022-01-11 11:51:58
*/
//Given the head of a singly linked list and an integer k, split the linked 
//list into k consecutive linked list parts. 
//
// The length of each part should be as equal as possible: no two parts should 
//have a size differing by more than one. This may lead to some parts being null. 
//
// The parts should be in the order of occurrence in the input list, and parts 
//occurring earlier should always have a size greater than or equal to parts 
//occurring later. 
//
// Return an array of the k parts. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3], k = 5
//Output: [[1],[2],[3],[],[]]
//Explanation:
//The first element output[0] has output[0].val = 1, output[0].next = null.
//The last element output[4] is null, but its string representation as a 
//ListNode is [].
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
//Output: [[1,2,3,4],[5,6,7],[8,9,10]]
//Explanation:
//The input has been split into consecutive parts with size difference at most 1
//, and earlier parts are a larger size than the later parts.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 1000]. 
// 0 <= Node.val <= 1000 
// 1 <= k <= 50 
// 
// Related Topics 链表 👍 240 👎 0

package leetcode.editor.cn;
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        int chunk = count / k;
        int remainder = count % k;
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        for(int i = 0; i < k && curr != null; i++) {
            ans[i] = curr;
            int size = chunk + (i < remainder ? 1 : 0);
            for (int j = 1; j < size; j++) {
                curr = curr.next;
            }
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
