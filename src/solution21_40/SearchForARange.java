package solution21_40;

/**
 * Created by yhj on 2017/12/3.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums,target);
        if(start<0 || nums[start] != target){
            return new int[]{-1, -1};
        }
        int end = binarySearch(nums, target+1);
        if(end < 0 || target == nums[end]){
            return new int[]{start, end};
        }else {
            return new int[]{start, end-1};
        }
    }

    public int binarySearch(int[] nums, int target){
        int low = 0,high = nums.length-1;
        while (low < high){
            int mid = (low + high) >> 1;
            if(nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return high;
    }
}
