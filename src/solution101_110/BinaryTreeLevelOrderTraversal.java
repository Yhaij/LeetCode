package solution101_110;

import tool.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    tmp.add(node.left);
                }
                if(node.right != null){
                    tmp.add(node.right);
                }
            }
            result.add(list);
            queue = tmp;
        }
        return result;
    }
}
