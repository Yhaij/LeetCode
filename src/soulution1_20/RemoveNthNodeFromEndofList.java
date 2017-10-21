package soulution1_20;

/**
 * Created by yhj on 2017/10/17.
 */
public class RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sum  = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            sum ++;
        }
        p = head;
        if (sum == n){
            head = head.next;
        }else{
            int target = sum-n;
            for(int i = 0; i < target-1;i++){
                p = p.next;
            }
            p.next = p.next.next;
        }
        return head;
    }
}
