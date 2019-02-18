package solution41_60;

/**
 *  @Author: yhj
 * @Description:
 * @Date: Created in 2019-02-03.
 * @Modified By:
 */
public class JumpGameii {
    public int jump(int[] nums) {
        if(nums == null|| nums.length<=0){
            return -1;
        }
        int[] jumpCount = new int[nums.length];
        int maxStep = 0;
        for(int i = 0;i < nums.length;i++){
            int step = jumpCount[i] + 1;
            int len = i+nums[i];
            for(int j = maxStep+1;j <= len && j < jumpCount.length;j++){
                jumpCount[j] = step;
            }
            if(len > maxStep) maxStep = len;
        }
        return jumpCount[jumpCount.length-1];
    }
}