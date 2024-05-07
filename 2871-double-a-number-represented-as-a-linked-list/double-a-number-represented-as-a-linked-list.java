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
    // public ListNode reverse(ListNode head){
    //     ListNode prev=null,curr=head,nex;
    //     while(curr!=null){
    //         nex=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=nex;
    //     }
    //     return prev;
    // }
    // public ListNode doubleIt(ListNode head) {
    //     head=reverse(head);
    //     ListNode prev=null,curr=head;
    //     int carry=0;
    //     while(curr!=null){
    //         int newval=curr.val*2;
    //         curr.val=(newval%10)+carry;
    //         carry=newval>9?1:0;
    //         prev=curr;
    //         curr=curr.next;
    //     }
    //     if(carry!=0){
    //         ListNode newNode=new ListNode(carry);
    //         prev.next=newNode;
    //     }
    //     return reverse(head);
    // }

    public ListNode doubleIt(ListNode head) {
        Stack<Integer> s=new Stack<>();
        int nums=0;

        while(head!=null){
            s.push(head.val);
            head=head.next;
        }

        ListNode tail=null;
        while(!s.isEmpty()||nums!=0){
            tail=new ListNode(0,tail);
            if(!s.isEmpty()) nums+=s.pop()*2;
            tail.val=nums%10;
            nums/=10;
        }
        return tail;
    }
}