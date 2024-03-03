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
        if(head==null||head.next==null){
            return null;
        }
        
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        if(n==count){
            return head.next;
        }
        int i=1;
        int index=count-n;
        ListNode prev=head;
        while(i<index){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
        
    }
}