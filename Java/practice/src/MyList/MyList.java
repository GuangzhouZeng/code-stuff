package MyList;

/**
 * Created by guangzhouzeng on 2/11/16.
 */
public class MyList {

    public static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for(int num: arr){
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
}
