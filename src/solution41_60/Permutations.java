package solution41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 递归求解
 * @Date: Created in 2019-02-11.
 * @Modified By:
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        find(nums, 0, result);
        return result;
    }

    public void find(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        find(nums, index+1, result);
        for(int i = index+1;i< nums.length;i++){
            change(nums, index, i);
            find(nums, index+1, result);
            change(nums, index, i);
        }
    }

    public void change(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
