/**
  * 题目Id：23
  * 题目：Merge k Sorted Lists
  * 日期：2022-01-01 20:22:58
*/
//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1670 👎 0

package leetcode.editor.cn;
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (l+r) >> 1;
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid+1, r);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode ans = null;
//        for (int i = 0; i < lists.length; ++i) {
//            ans = mergeTwoLists(ans, lists[i]);
//        }
//        return ans;
//    }
//
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode cur = dummyHead;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = list1 == null ? list2 : list1;
//        return dummyHead.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
