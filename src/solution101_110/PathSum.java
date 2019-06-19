package solution101_110;

import tool.TreeNode;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/5/30.
 */
public class PathSum {
    boolean result  = false;
    int target;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        target = sum;
        traceBack(root, 0);
        return result;
    }

    public void traceBack(TreeNode node, int sum){
        if(result){
            return;
        }
        sum += node.val;
        if(node.left == null && node.right == null){
            if(sum == target){
                result = true;
            }
            return;
        }
        if(node.left != null){
            traceBack(node.left, sum);
        }
        if(node.right != null){
            traceBack(node.right, sum);
        }
    }
}
