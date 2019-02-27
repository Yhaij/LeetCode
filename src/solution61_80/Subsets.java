package solution61_80;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 22:14 2019/2/27
 * @Modified By:
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i <= nums.length;i++){
            traceBack(0, 0, i, new int[i], nums, result);
        }
        return result;
    }

    public void traceBack(int deep, int start,int k, int[] tmp, int[] nums, List<List<Integer>> result){
        if(deep == k){
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < tmp.length;i++){
                list.add(tmp[i]);
            }
            result.add(list);
            return;
        }
        for(int i = start; i < nums.length-k+deep+1; i++){
            tmp[deep] = nums[i];
            traceBack(deep+1, i+1, k, tmp, nums, result);
        }
    }
}
