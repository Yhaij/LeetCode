package solution21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 21:23 2018/12/9
 * @Modified By:
 **/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        find(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void find(List<List<Integer>> result, List<Integer> value, int[] candidates, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(value));
            return;
        }

        for(int i = start; i < candidates.length;i++){
            if(candidates[i] > target){
                return;
            }
            //对于与下个元素相同的元素，只能加起始的第一个元素，其余都不能加
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            value.add(candidates[i]);
            //i+1是为了不能使用重复元素
            find(result, value, candidates, target-candidates[i], i+1);
            value.remove(value.size()-1);
        }
    }
}
