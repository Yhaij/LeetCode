package solution81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 递归，查找所有的二叉搜索树
 * @Date: Created in 2019/03/14.
 */
public class UniqueBinarySearchTreesii {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return traceBack(1, n);
    }

    public List<TreeNode> traceBack(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start;i <= end;i ++){
            List<TreeNode> lefts = traceBack(start, i-1);
            List<TreeNode> rights = traceBack(i+1, end);
            for(TreeNode left: lefts){
                for(TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }


}
