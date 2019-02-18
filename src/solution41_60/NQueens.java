package solution41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 使用递归回溯法,从上到下的每一行必定要摆放一个黄后,deep代表要摆放的行数,该行每一列都有可能摆放
 * @Date: Created in 2019-02-12.
 * @Modified By:
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        //记录该列是否摆放过皇后
        boolean[] column = new boolean[n];
        //从左上到右下的斜线上是否摆放过皇后,共2*n-1条
        boolean[] left = new boolean[2*n];
        //从右上到左下的斜线上是否摆放过皇后,共2*n-1条
        boolean[] right = new boolean[2*n];
        int[] queen = new int[n];
        List<List<String>> result = new ArrayList<>();
        backtrace(result, 0, n, column, left, right, queen);
        return result;
    }

    public void backtrace(List<List<String>> result, int deep, int n, boolean[] column, boolean[] left, boolean[] right, int[] queen){
        if(deep == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < n;j++){
                    if(j == queen[i]){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int i = 0;i < n; i++){
            // 判断斜线和行列是否已经摆放过皇后
            if(column[i] || left[deep + i] || right[n-1+deep-i]){
                continue;
            }
            queen[deep] =i;
            column[i] = left[deep + i] = right[n-1+deep-i] = true;
            backtrace(result, deep+1, n, column, left, right, queen);
            column[i] = left[deep + i] = right[n-1+deep-i] = false;
        }
    }
}
