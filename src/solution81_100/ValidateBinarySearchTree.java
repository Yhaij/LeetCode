package solution81_100;

import tool.TreeNode;
/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/16.
 */
public class ValidateBinarySearchTree {
    public class Value{
        int min;
        int max;
        boolean flag;
        Value(int min, int max, boolean flag){
            this.min = min;
            this.max = max;
            this.flag = flag;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        return get(root).flag;
    }

    public Value get(TreeNode root){
        Value value =  new Value(root.val, root.val, true);
        if(root.left == null && root.right == null){
            return value;
        }

        if(root.left != null){
            Value left = get(root.left);
            value.flag = value.flag && left.flag && root.val > left.max;
            value.min = Math.min(value.min, left.min);
            value.max = Math.max(value.max, left.max);
        }
        if(root.right != null){
            Value right = get(root.right);
            value.flag = value.flag && right.flag && root.val < right.min;
            value.min = Math.min(value.min, right.min);
            value.max = Math.max(value.max, right.max);
        }
        return value;
    }


//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//        if (root == null) return true;
//        if (root.val >= maxVal || root.val <= minVal) return false;
//        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//    }
}
