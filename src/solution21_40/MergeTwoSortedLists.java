package solution21_40;

/**
 * Created by yhj on 2017/10/20.
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    /**
     * amazing solution
     * @param l1
     * @param l2
     * @return
     */
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){ return  l2;}
        if (l2 == null){ return  l1;}
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }*/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, t = result;
        while (p != null && q != null){
            if(p.val < q.val){
                t.next = new ListNode(p.val);
                t = t.next;
                p = p.next;
            }else {
                t.next = new ListNode(q.val);
                t = t.next;
                q = q.next;
            }
        }
        while (p != null){
            t.next = new ListNode(p.val);
            t = t.next;
            p = p.next;
        }
        while (q != null){
            t.next = new ListNode(q.val);
            t = t.next;
            q = q.next;
        }
        return result.next;
    }
}
