package solution101_110;

import tool.TreeNode;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/10.
 */
public class BalancedBinaryTree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        deep(root);
        return flag;
    }

    public int deep(TreeNode root){
        if(root == null || !flag){
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) +1;
    }
}
