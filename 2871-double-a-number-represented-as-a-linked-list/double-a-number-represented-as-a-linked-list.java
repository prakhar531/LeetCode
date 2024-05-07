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
    public ListNode reverse(ListNode head){
        ListNode prev=null,curr=head,nex;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        ListNode prev=null,curr=head;
        int carry=0;
        while(curr!=null){
            int newval=curr.val*2;
            curr.val=(newval%10)+carry;
            carry=newval>9?1:0;
            prev=curr;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            prev.next=newNode;
        }
        return reverse(head);
    }
}