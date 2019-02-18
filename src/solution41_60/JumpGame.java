package solution41_60;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 22:13 2019/2/18
 * @Modified By:
 **/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int p = nums.length-1;
        for(int i = nums.length-2; i > 0;i--){
            if(nums[i] + i >= p){
                p = i;
            }
        }
        return nums[0] >= p;
    }
}
