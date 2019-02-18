package solution41_60;

import java.util.*;

/**
 * @Author: yhj
 * @Description: 相对于全排列无重复需要对重复的数组添加一个去重步骤
 * 整体的思想和上题一样:都是从上到下,固定一个不重复的数字,再对之后的数组再次进行全排列
 * @Date: Created in 2019-02-11.
 * @Modified By:
 */
public class permutationsii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        find(nums, 0, result);
        return result;
    }

    public void find(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        find(nums, index+1, result);
        // 保证每次固定的数都不相同,引入set,可以使用isDuplicate代替
        Set<Integer> set = new HashSet<>();
        set.add(nums[index]);
        for(int i = index+1;i < nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            swap(nums, index, i);
            find(nums, index+1, result);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public boolean isDuplicate(int[] nums, int start, int end){
        for(int i = start;i < end;i++){
            if(nums[start] == nums[end]){
                return false;
            }
        }
        return true;
    }
}
