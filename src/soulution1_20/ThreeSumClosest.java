package soulution1_20;

import java.util.Arrays;

/**
 * Created by yhj on 2017/10/13.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i<nums.length-2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1, high = nums.length-1;
                while (low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if(Math.abs(sum-target) < minDiff){
                        minDiff = Math.abs(sum-target);
                        result = sum;
                    }
                    if(sum < target){
                        low ++;
                    }else if(sum == target){
                        return result;
                    }else {
                        high --;
                    }
                }
            }
        }
        return result;
    }
}
