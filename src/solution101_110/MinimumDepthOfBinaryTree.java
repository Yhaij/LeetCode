package solution101_110;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/5/30.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        while (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 1;
        while (!queue.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node: queue){
                boolean flag = true;
                if(node.left != null){
                    tmp.offer(node.left);
                    flag = false;
                }
                if(node.right != null){
                    tmp.offer(node.right);
                    flag = false;
                }
                if(flag){
                    return deep;
                }
            }
            queue = tmp;
            deep++;
        }
        return deep;
    }
}
