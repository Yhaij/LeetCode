package solution61_80;

/**
 * @Author: yhj
 * @Description: 如果是0移到头部并进1，保持low和i相同，是1，进1，是2移到尾部，
 * @Date: Created in 2019/2/26.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null){
            return;
        }
        int low = 0, high = nums.length-1;
        for(int i = low; i <= high;){
            if(nums[i] == 0){
                swap(nums, i, low++);
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, high--);
            }else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
