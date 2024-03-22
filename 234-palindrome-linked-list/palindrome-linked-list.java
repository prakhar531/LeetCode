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
    // public ListNode getMid(ListNode head){
    //     ListNode slow=head;
    //     ListNode fast=head;

    //     while(fast!=null &&  fast.next!=null ){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     return slow;
    // }
    // public ListNode reverse(ListNode head){
    //     ListNode prev=null;
    //     ListNode curr=head;
    //     ListNode nex=head;

    //     while(curr!=null){
    //         nex=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=nex;
    //     }
    //     return prev;
    // }
    private static final int[] array = new int[100_000];
    public boolean isPalindrome(ListNode head) {
        // if(head==null) return false;
        // if(head.next==null) return true;

        // ListNode mid=getMid(head);
        // ListNode last=reverse(mid);

        // while(last!=null){
        //     if(last.val!=head.val){
        //         return false;
        //     }
        //     last=last.next;
        //     head=head.next;
        // }
        // return true;
        if(head==null || head.next==null){
            return true;
        }
       ListNode h= head;
       final int[] array1 = array;
       int size =0;

       while(h!=null){
           array1[size++] = h.val;
           h=h.next;
       }

       int m = size/2;
       for(int i=0;i<m;i++){
           if(array[i] != array1[--size]){
               return false;
           }
       }
       return true;
    }
}