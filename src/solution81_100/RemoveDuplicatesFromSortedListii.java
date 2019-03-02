package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/02.
 */
public class RemoveDuplicatesFromSortedListii {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = new ListNode(-1), pre = head, qq = q;
        boolean flag = true;
        while (p!=null && p.next != null) {
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                p = p.next;
            } else {
                qq.next = new ListNode(p.val);
                qq = qq.next;
                p = p.next;
            }
        }
        if (p != null){
            qq.next = p;
        }
        return q.next;
    }

}
