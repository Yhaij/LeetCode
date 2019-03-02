package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/02.
 */

public class RemoveDuplicatesRromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p = head.next, pre = head;
        ListNode headnew = new ListNode(head.val);
        ListNode q = headnew;
        while (p != null){
            while (p != null && p.val == pre.val){
                p = p.next;
            }
            if(p == null){
                break;
            }
            q.next = new ListNode(p.val);
            q = q.next;
            pre = p;
            p = p.next;
        }
        return headnew;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        if (head.val != head.next.val) {
//            head.next = deleteDuplicates(head.next);
//            return head;
//        } else {
//            while ((head = head.next).next != null && (head.val == head.next.val)) {
//            }
//            return deleteDuplicates(head);
//        }
//    }
}
