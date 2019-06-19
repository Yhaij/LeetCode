package solution81_100;

/**
 * @Author: yhj
 * @Description: n的参数的答案分为 i= 1，2...n 时 i-1的左子树个数加上i+1到n的右子树个数
 * @Date: Created in 2019/03/14.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 1){
            return n;
        }
        int[] p = new int[n];
        p[0] = 1;
        p[1] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 1;j <= i;j++){
                p[i] += p[j-1]*p[i-j];
            }
        }
        return p[n];
    }
}
