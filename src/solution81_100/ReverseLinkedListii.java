package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/14.
 */
public class ReverseLinkedListii {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n){
            return head;
        }
        int i = 1;
        ListNode phead = new ListNode(0), pre = phead, p = head;
        phead.next = head;
        ListNode start = null;
        while (p != null){
            if(i == m){
                start = pre;
            }
            if(i > m && i < n){
                ListNode q = p;
                p = p.next;
                q.next = pre;
                pre = q;
                i++;
                continue;
            }
            if(i == n){
                ListNode q = start.next;
                start.next = p;
                q.next = p.next;
                p.next = pre;
                break;
            }
            pre = p;
            p = p.next;
            i++;
        }
        return phead.next;
    }
}
