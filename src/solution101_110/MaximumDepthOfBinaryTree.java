package solution101_110;

import tool.TreeNode;
/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/2.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
