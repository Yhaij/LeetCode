package solution21_40;

/**
 * Created by yhj on 2017/10/21.
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode h = pre;
        pre.next = head;
        while (pre.next != null && pre.next.next != null){
            ListNode mid = pre.next;
            pre.next = mid.next;
            mid.next = pre.next.next;
            pre.next.next = mid;
            pre = mid;
        }
        return h.next;
    }

    /*public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null){
            int mid = p.val;
            p.val = p.next.val;
            p.next.val = mid;
            p = p.next.next;
        }
        return head;
    }*/

}
