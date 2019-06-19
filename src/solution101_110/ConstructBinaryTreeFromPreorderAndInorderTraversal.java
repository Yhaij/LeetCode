package solution101_110;

import tool.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yhj
 * @Description: 递归，preorder的值根据分左右子树构造
 * @Date: Created on 2019/4/2.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    Map<Integer, Integer> preorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length;i++){
            inorderMap.put(inorder[i], i);
            preorderMap.put(preorder[i], i);
        }
        return build(preorder, 0, 0, inorder.length);
    }

    public TreeNode build(int[] preorder, int index, int start, int end){
        if (start == end){
            return null;
        }
        int p = inorderMap.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        node.left = build(preorder, index+1, start, p);
        node.right = build(preorder, index + (p - start) + 1, p+1, end);
        return node;
    }
}

