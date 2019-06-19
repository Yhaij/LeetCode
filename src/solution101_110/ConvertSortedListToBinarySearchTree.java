package solution101_110;

import tool.TreeNode;
/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/10.
 */
public class ConvertSortedListToBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        int l = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            l++;
        }
        int[] arr = new int[l];
        p = head;l = 0;
        while (p != null){
            arr[l++] = p.val;
            p = p.next;
        }
        return build(arr, 0, arr.length);
    }

    public TreeNode build(int[] nums, int start, int end){
        if(start == end){
            return null;
        }
        int p = (start + end)/2;
        TreeNode node = new TreeNode(nums[p]);
        node.left = build(nums, start, p);
        node.right = build(nums, p+1, end);
        return node;
    }
}
