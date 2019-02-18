package solution41_60;

/**
 * @Author: yhj
 * @Description: 和上一题一样的解法
 * @Date: Created in 2019-02-12.
 * @Modified By:
 */
public class NQueensii {
    public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] left = new boolean[2*n];
        boolean[] right = new boolean[2*n];
        return backtrace(0, n, column, left, right);
    }

    public int backtrace(int deep, int n, boolean[] column, boolean[] left, boolean[] right){
        int res = 0;
        if (deep == n){
            return 1;
        }
        for(int i = 0;i < n;i++){
            if(column[i] || left[deep + i] || right[n - 1 + deep - i])
                continue;
            column[i] = left[deep + i] = right[n - 1 + deep - i] = true;
            res += backtrace(deep + 1, n, column, left, right);
            column[i] = left[deep + i] = right[n - 1 + deep - i] = false;
        }
        return res;
    }
}
