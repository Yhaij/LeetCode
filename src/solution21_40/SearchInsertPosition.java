package solution21_40;

/**
 * Created by yhj on 2017/12/9.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int low = 0, high = nums.length;
        while (low < high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid+1;
            }
            if(nums[mid] > target){
                high = mid;
            }
        }
        return low;
    }
}
