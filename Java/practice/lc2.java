/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //one more pass, but less space
        ListNode head = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        //find which is longer
        while(temp1!=null&&temp2!=null){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp1!=null) head.next = l1;
        else head.next = l2;
        ListNode p = head;
        
        int c = 0;
        while(l1!=null||l2!=null){
            int num = (l1==null?0:l1.val)+(l2==null?0:l2.val)+c;
            c = num/10;
            p.next.val = num%10;
            p=p.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(c!=0){
            p.next = new ListNode(1);
        }
        return head.next;
        
        /*ListNode head = new ListNode(0);
        ListNode p = head;
        int c = 0;
        while(l1!=null||l2!=null){
            int num = (l1==null?0:l1.val)+(l2==null?0:l2.val)+c;
            c = num/10;
            p.next = new ListNode(num%10);
            p=p.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(c!=0){
            p.next = new ListNode(1);
        }
        return head.next;*/
    }
}