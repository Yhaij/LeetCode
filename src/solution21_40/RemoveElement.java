package solution21_40;

/**
 * Created by yhj on 2017/10/21.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
