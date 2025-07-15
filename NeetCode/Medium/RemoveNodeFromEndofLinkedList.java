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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
            return head;
        }
        //find how long is the linkedlist

        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        if(cnt < n){
            return head;
        }

        //if I need to delete 1st node
        if(cnt == n){
            head = head.next;
            return head;
        }

        int index = cnt - n;
        temp = head;
        //move to the index before the one to remove
        for(int i = 0; i < index -1 ; i++){
            temp = temp.next;
        }

        //have to check if we remove somewhere in the list or the end
        if(temp.next != null){
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }

        return head;
    }
}
