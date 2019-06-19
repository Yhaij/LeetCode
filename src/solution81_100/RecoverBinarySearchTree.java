package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/16.
 */
public class RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        TreeNode prev;
        TreeNode prev_first;
        TreeNode first;
        TreeNode second;
        public void recoverTree(TreeNode root) {
            /**
             所谓简单的O(n)个空间的思路：
             中序遍历得到数组，比如[1,3,2,4],在用一个hashmap<int,TreeNode>保存对象.
             然后对数组排序，得到[1,2,3,4],对比得到2和3两个节点不一样，交换一下值即可。
             下面实现进阶的常数空间思想：
             在纸上写几个数组观察一下，可以发现，只需要找到三个结点（prev_first,first,second），就能进行交换，且只交换值是最方便的。
             中序遍历，寻找第一个递减的节点，用prev记录前一个节点。
             prev_first记录frist前驱，first记录现在。
             再次寻找第二个递减的节点，second记录。若是找到了second，交换prev_first和second，若是没找到，交换prev_first和first
             */
            isValidBST(root);
            int tmp=prev_first.val;
            if(second!=null){
                prev_first.val=second.val;
                second.val=tmp;
            }else{
                prev_first.val=first.val;
                first.val=tmp;
            }
        }
        public void isValidBST(TreeNode root) {
            if(root==null){
                return;
            }
            isValidBST(root.left);
            if(prev!=null){
                if(root.val<=prev.val){
                    if(prev_first==null){
                        prev_first=prev;//找到第一个前驱以及第一个节点
                        first=root;
                    }else{//找到第二个节点,因为已知两个节点,则写上return可以提高效率
                        second=root;
                        return;
                    }
                }
                prev=root;
            }else{
                prev=root;
            }
            isValidBST(root.right);
        }
    }
}
