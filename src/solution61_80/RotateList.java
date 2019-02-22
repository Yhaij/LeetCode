package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/19.
 */
public class RotateList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int n = 0;
        ListNode p = head;
        ListNode last = head;
        while (p != null){
            last = p;
            p = p.next;
            n++;
        }
        int j = k%n;
        if(j != 0){
            p = head;
            j = n - j;
            while (j > 1){
                p = p.next;
                j--;
            }
            ListNode tmp = p.next;
            p.next = null;
            last.next = head;
            head = tmp;
        }
        return head;
    }
}
