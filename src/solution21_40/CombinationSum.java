package solution21_40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 解题方法，递归所有方案，首先列出包括所有最小数的组合，接着是（不包括最小的）次小的开始，以此类推，target-num后的数也按照上述方法
 *                  也可以到着来，首先列出所有包括最大数的组合，接着是次大的
 * @Date: Created in 22:33 2018/12/8
 * @Modified By:
 **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        find(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void find(List<List<Integer>> result, List<Integer> value, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }else if(target == 0){
            result.add(new ArrayList<>(value));
            return;
        }

        for(int i = start;i < candidates.length;i++){
            value.add(candidates[i]);
            //i是为了使用重复元素，i+1是不能使用重复元素
            find(result, value, candidates, target-candidates[i], i);
            value.remove(value.size()-1);
        }
    }
}