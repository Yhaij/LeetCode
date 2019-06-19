package solution101_110;

import tool.TreeNode;
import java.util.HashMap;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created on 2019/4/10.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversa {
    public HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public HashMap<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length;i++){
            inorderMap.put(inorder[i], i);
            postorderMap.put(postorder[i], i);
        }
        return build(postorder, inorder.length-1, inorder, 0, postorder.length);
    }

    public TreeNode build(int[] postorder, int index, int[] inorder, int start, int end){
        if(start == end){
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        int p = inorderMap.get(postorder[index]);
        node.right = build(postorder, index-1, inorder, p+1, end);
        node.left = build(postorder, index - (end - p), inorder, start, p);
        return node;
    }

}
