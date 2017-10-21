package solution21_40;

/**
 * Created by yhj on 2017/10/21.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = nums.length == 0?0:1;
        for(int i = 1;i<nums.length;i++){
            if (nums[i] != nums[i-1]){
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
