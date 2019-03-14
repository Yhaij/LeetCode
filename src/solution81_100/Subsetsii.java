package solution81_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 对于相同的可以选择不加入，加入一个、两个...
 * @Date: Created in 2019/03/13.
 */
public class Subsetsii {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traceBack(nums, 0, new int[nums.length], 0);
        return result;
    }

    public void traceBack(int[] nums, int index, int[] tmp, int length){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < length;i++){
                list.add(tmp[i]);
            }
            result.add(list);
            return;
        }
        int l = 1;
        while (l+index < nums.length && nums[l+index] == nums[index]){
            l++;
        }
        for(int i = 0;i <= l;i++){
            int j = 0;
            for(; j < i; j++){
                tmp[length + j] = nums[index];
            }
            traceBack(nums, index+l,tmp, length+j);
        }
    }
}
