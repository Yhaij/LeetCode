package solution81_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/14.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> result = new ArrayList<>();
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public class Item{
//        TreeNode node;
//        int val;
//        Item(TreeNode node){
//            this.node = node;
//            this.val = 0;
//        }
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null){
//            return result;
//        }
//        Stack<Item> stack = new Stack<>();
//        stack.add(new Item(root));
//        while (!stack.isEmpty()){
//            Item item = stack.pop();
//            item.val ++;
//            if(item.val == 2){
//                result.add(item.node.val);
//                if(item.node.right != null){
//                    stack.add(new Item(item.node.right));
//                }
//            }
//            if(item.val == 1){
//                stack.add(item);
//                if(item.node.left != null){
//                    stack.add(new Item(item.node.left));
//                }
//            }
//        }
//        return result;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        traceBack(root);
        return result;
    }

    public void traceBack(TreeNode node){
        if(node == null){
            return;
        }
        traceBack(node.left);
        result.add(node.val);
        traceBack(node.right);
    }
}
