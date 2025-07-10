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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        //gonna split in half
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half
        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //prev is the head of l2
        //merge l1.1 l2.1 l1.2 l2.2 ....

        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first  = tmp1;
            second = tmp2;
        }
    }
}
