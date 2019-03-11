package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 23:09 2019/3/11
 * @Modified By:
 **/
public class PartitionList {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
            val = x;
        }
     }

    public ListNode partition(ListNode head, int x) {
         if(head == null || head.next == null){
             return head;
         }
        ListNode p = head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode insertP;
         if(head.val >= x){
             insertP = phead;
         }else {
             while (p.next != null && p.next.val < x){
                 p = p.next;
             }
             insertP = p;
         }
         while (p.next != null){
             if (p.next.val < x){
                 ListNode q = p.next;
                 p.next = p.next.next;
                 q.next = insertP.next;
                 insertP.next = q;
                 insertP = insertP.next;
             }else {
                p = p.next;
             }
         }
        return phead.next;
    }
}
