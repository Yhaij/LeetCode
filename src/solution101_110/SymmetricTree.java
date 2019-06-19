package solution101_110;

import tool.TreeNode;

/**
 * @Author: yhj
 * @Description: 可以得到其中序遍历左右对称
 * @Date: Created in 2019/03/16.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left , root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null){
            return right == null;
        }
        if(right == null){
            return left == null;
        }
        // 自身镜像以及左子树和右子树镜像，右子树和左子树镜像
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
