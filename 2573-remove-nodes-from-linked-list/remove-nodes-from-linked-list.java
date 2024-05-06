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
        ListNode prev=null,curr=head,nex=head;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        int max=Integer.MIN_VALUE;
        ListNode prev=null;
        ListNode temp=head;
        while(head!=null){
            int curr=head.val;
            max=Math.max(max,curr);
            if(curr<max){
                prev.next=head.next;
            }else{
                prev=head;
                
            }
            head=head.next;
        }
        head=reverse(temp);
        return head;
    }
}