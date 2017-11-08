package solution21_40;

/**
 * Created by yhj on 2017/11/7.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] >= nums[i+1])
                continue;
            int j = i+1;
            while (j<nums.length && nums[i] <= nums[j]){
                j++;
            }
            int tmp = nums[i];
            nums[i] = nums[j-1];
            nums[j-1] = tmp;
            reverse(nums, ++i);
            return;
        }
        reverse(nums, 0);
        return;
    }

    /*public void nextPermutation(int[] nums) {
        findBigger(nums, nums.length-1);
    }

    public void findBigger(int[] nums, int target){
        if (target < 0){
            reverse(nums, 0);
            return;
        }
        for(int i = nums.length-1;i>target;i--){
            if (nums[target] < nums[i]){
                int tmp = nums[target];
                nums[target] = nums[i];
                nums[i] = tmp;
                reverse(nums, ++target);
                return;
            }
        }
        findBigger(nums, --target);
        return;
    }*/

    public void reverse(int[] nums, int start){
        int l = nums.length-start;
        for(int i = 0;i<l/2;i++){
            int tmp = nums[start+i];
            nums[start+i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
