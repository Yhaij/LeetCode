package solution41_60;

/**
 *
 *
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019-02-12.
 * @Modified By:
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int tmp = 0, max = nums[0];
        for(int num: nums){
            if(tmp > 0){
                tmp += num;
            }else {
                tmp = num;
            }
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//        if(nums.length <= 0){
//            return 0;
//        }
//        return partition(nums, 0 , nums.length-1);
//    }
//
//    public int partition(int[] nums, int left, int right){
//        if(left == right){
//            return nums[left]>0?nums[left]:0;
//        }
//        int p = (right + left)/2;
//        int leftTmp = 0, leftMaxTmp = 0;
//        for(int i = p+1;i <= right;i++){
//            leftTmp += nums[i];
//            if(leftTmp > leftMaxTmp)
//                leftMaxTmp = leftTmp;
//        }
//        int rightTmp = 0, rightMaxTmp = 0;
//        for(int i = p;i >= left;i--){
//            rightTmp += nums[i];
//            if(rightTmp > rightMaxTmp){
//                rightMaxTmp = rightTmp;
//            }
//        }
//        int tmp = leftMaxTmp + rightMaxTmp;
//        return Math.max(tmp, Math.max(partition(nums, left, p), partition(nums, p+1, right)));
//    }
}
