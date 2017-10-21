package solution21_40;

/**
 * Created by yhj on 2017/10/21.
 */
public class ReverseNodesInk_Group {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


/*    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }*/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode zeroNode = new ListNode(0), pre = zeroNode;
        zeroNode.next = head;
        while (pre.next != null) {
            ListNode p = pre.next;
            int i;
            for (i = 0; i < k && p != null; i++, p = p.next) ;
            if (i == k) {
                ListNode aft = p;
                ListNode q = pre.next;
                p = pre.next.next;
                while (p != aft) {
                    ListNode tmp = p.next;
                    p.next = q;
                    q = p;
                    p = tmp;
                }
                ListNode tmp = pre.next;
                tmp.next = aft;
                pre.next = q;
                pre = tmp;
            } else {
                break;
            }
        }
        return zeroNode.next;
    }
}
