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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode result = lists[0];

        for(int i = 1; i < lists.length; i++){
            result = merge2Lists(result, lists[i]);
        }

        return result;
    }

    public ListNode merge2Lists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }

            head = head.next;
        }

        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }

        return dummy.next;
    }
}
