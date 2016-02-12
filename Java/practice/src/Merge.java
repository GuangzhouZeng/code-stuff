/**
 * Created by guangzhouzeng on 2/11/16.
 */
import MyList.*;
public class Merge {
    public static ListNode MergeTwoLinkedList(ListNode l1, ListNode l2){
        //remove the duplicates
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(l1 != null || l2 != null){// 1, 1 // 1, 2 //2, 2 // 2, 2
            int l1Val = l1 == null ? Integer.MAX_VALUE : l1.val;
            int l2Val = l2 == null ? Integer.MAX_VALUE : l2.val;

            if(l1Val < l2Val){
                if(p == dummy || l1Val != p.val){
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            }else if(l1Val > l2Val){
                if(p == dummy || l2Val != p.val){
                    p.next = l2;
                    p = p.next;
                }
                l2 = l2.next;
            }else {
                l1 = l1.next;
            }
        }
        p.next = null;

        return dummy.next;
    }
    //l1: (1),(2),(2),(null)
    //l2: (1),(2),(2)
    //res; 1, 2, null


    public static void main(String[] args){
        ListNode l1 = MyList.createList(new int[]{0,1,2,2,2,3,4,5,6,7,8,9,9,9});
        ListNode l2 = MyList.createList(new int[]{0,0,1,2,2,2,2,2,5,6,10,10});
        MyList.printList(MergeTwoLinkedList(l1, l2));
    }
}
