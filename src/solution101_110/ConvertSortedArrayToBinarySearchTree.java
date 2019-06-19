package solution101_110;

import tool.TreeNode;
/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/10.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
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
