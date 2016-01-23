/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //iterative way O(n) time and O(1) space
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p=dummy, q,r;
        
        do{
            q=p.next;r=q.next;
            q.next=r.next;
            r.next=q;
            p.next=r;
            p=q;
        }while(p.next!=null&&p.next.next!=null);
        
        return dummy.next;
        
        
        //recursive way O(n) time O(1) space
        /*if(head==null||head.next==null) return head;
        ListNode p=head,q=head.next;
        p.next=swapPairs(q.next);
        q.next=p;
        return q;*/
    }
}