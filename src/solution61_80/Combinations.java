package solution61_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 解法和全排列46、47题相同，递归解决，回溯剪枝
 * @Date: Created in 2019/2/26.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        traceBack(0, 1,k, n, new int[k], result);
        return result;
    }

    public void traceBack(int x, int start,int k,int n, int[] nums, List<List<Integer>> result){
        if(x == k){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for(int i = start; i <= n-k+x+1; i++){
            nums[x] = i;
            traceBack(x+1,i+1, k, n, nums, result);
        }
    }

}
