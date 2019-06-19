package solution101_110;

import tool.TreeNode;
import java.util.*;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/10.
 */
public class BinaryTreeLevelOrderTraversalii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> nodeList = new LinkedList<>();
        if(root == null){
            return result;
        }
        nodeList.offer(root);
        while (!nodeList.isEmpty()){
            Queue<TreeNode> newNodes = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!nodeList.isEmpty()){
                TreeNode node = nodeList.poll();
                list.add(node.val);
                if(node.left != null){
                    newNodes.offer(node.left);
                }
                if(node.right != null){
                    newNodes.offer(node.right);
                }
            }
            result.add(0, list);
            nodeList = newNodes;
        }
        return result;
    }
}
