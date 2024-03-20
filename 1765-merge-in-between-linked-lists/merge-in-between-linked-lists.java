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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ret = list1;
        ListNode curr = list1;
        ListNode curr2 = list1;
        while(a>1){
            a--;
            curr = curr.next;
        }
        while(b>0){
            b--;
            curr2 = curr2.next;
        }
        curr2 = curr2.next;
        curr.next = list2;

        while(list2.next!=null){
            list2 = list2.next;
        } 
        list2.next = curr2;
        return ret;

    }
}