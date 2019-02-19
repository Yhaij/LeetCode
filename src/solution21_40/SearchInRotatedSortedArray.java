package solution21_40;

/**
 * Created by yhj on 2017/11/15.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[high]) low = mid+1;
            else high = mid;
        }
        int start = low;
        low = 0;high = nums.length-1;
        while (low <= high){
            int mid = (low+high)/2;
            int realmid = (start+mid)%nums.length;
            if(nums[realmid] == target)return realmid;
            if(nums[realmid] < target )low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
