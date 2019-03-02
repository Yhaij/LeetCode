package solution81_100;

import solution21_40.SearchInRotatedSortedArray;

/**
 * @Author: yhj
 * @Description: 从前或后遍历
 * @Date: Created in 2019/03/02.
 */
public class SearchInRotatedSortedArrayii {
    public boolean search(int[] nums, int target) {
        int l = nums.length;
        if (l == 0)
            return false;
        if (l == 1) {
            if (target == nums[0])
                return true;
            return false;
        }
        int st = 0, ed = l - 1;
        while (st < ed) {
            if (nums[st] == target || nums[ed] == target)
                return true;
            if (nums[ed] < target && nums[st] > target)
                return false;
            if (nums[ed] < target) {
                st++;
            } else {
                ed--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new  SearchInRotatedSortedArrayii().search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
