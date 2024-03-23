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
    
    public ListNode midNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }

        ListNode mid=midNode(head);

        ListNode prev=null;
        ListNode curr=mid;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode left=head;
        ListNode right=prev;
        while(right.next != null && left != right){
            ListNode templ=left.next;
            ListNode tempr=right.next;
            left.next=right;
            right.next=templ;
            left=templ;
            right=tempr;
        }    
    }
}





