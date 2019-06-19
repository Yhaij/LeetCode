package solution101_110;

import tool.TreeNode;
import java.util.*;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/2.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()){
            int n = stack.size();
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> newStack = new Stack<>();
            if (level % 2 == 0){
                for(int i = 0; i < n;i++){
                    TreeNode p = stack.pop();
                    list.add(p.val);
                    if(p.left != null){
                        newStack.push(p.left);
                    }
                    if(p.right != null){
                        newStack.push(p.right);
                    }
                }
            }else {
                for(int i = 0; i < n;i++){
                    TreeNode p = stack.pop();
                    list.add(p.val);
                    if(p.right != null){
                        newStack.push(p.right);
                    }
                    if(p.left != null){
                        newStack.push(p.left);
                    }
                }
            }
            result.add(list);
            stack = newStack;
            level++;
        }
        return result;
    }
}
