package solution21_40;

/**
 * Created by yhj on 2017/10/21.
 */
public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 采用归并排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){return null;}
        if(lists.length == 1){return lists[0];}
        ListNode[] mergeLists = new ListNode[(lists.length+1)/2];
        for(int i = 0; (2*i+1)<lists.length;i++){
            mergeLists[i] = mergeTwoLists(lists[2*i], lists[2*i+1]);
        }
        if(lists.length%2 == 1){
            mergeLists[mergeLists.length-1] = lists[lists.length-1];
        }
        return mergeKLists(mergeLists);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2;}
        if (l2 == null) { return l1;}
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
