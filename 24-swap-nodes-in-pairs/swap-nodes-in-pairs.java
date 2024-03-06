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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,curr=dummy,nex=dummy;

        int count=0;
        curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }

        int idx=0;
        while(idx<count/2){
            curr=prev.next;
            nex=curr.next;

            curr.next=nex.next;
            nex.next=prev.next;
            prev.next=nex;
            prev=curr;
            idx++;
        }
        return dummy.next;
    }
}