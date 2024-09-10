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
    public int gcd(int a, int b){
        if(a == 1 || b==1){
            return 1;
        }
        while(b !=0){
            int rem = a % b;
            a = b;
            b= rem;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;
        while(temp1 !=null){
            int num = gcd(temp.val,temp1.val);
            ListNode a = new ListNode(num);
            temp.next = a;
            a.next = temp1;
            temp = temp1;
            temp1=temp1.next;
        }

        return head;
    }
}