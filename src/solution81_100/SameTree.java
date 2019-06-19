package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/16.
 */
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null){
            return q == null;
        }
        if(q == null){
            return p == null;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
