package soulution1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yhj on 2017/10/14.
 */
public class FourSum {
    /**
     * 采用ThreeSum的思路，就是排序后算三个加起来等于target-num[i],i遍历元素
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            int target3 = target-nums[i];
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                for(int j = i+1;j<nums.length-1;j++){
                    if(j == i+1 || (j > i+1 && nums[j] != nums[j-1])){
                        int low  = j+1, high = nums.length-1;
                        while (low < high){
                            int sum = nums[j] + nums[low] + nums[high];
                            if(sum == target3){
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);list.add(nums[j]);list.add(nums[low]);list.add(nums[high]);
                                result.add(list);
                                for(low++;nums[low] == nums[low-1] && low < high ;low++);
                                for(high--;nums[high] == nums[high+1] && low < high;high--);
                            }else {
                                if(sum < target3){
                                    low++;
                                }else {
                                    high--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
