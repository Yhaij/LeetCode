package solution61_80;

/**
 * @Author: yhj
 * @Description: 其中一种思路（别人的）如果是两个，则该元素的值一定大于其向前两位的元素值，否则就超过两个
 * @Date: Created in 2019/3/2.
 */
public class RemoveDuplicatesFromSortedArrayii {
    public int removeDuplicates(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int p = 1, count = 1, pre = nums[0];
//        for(int i = 1;i < nums.length;i++){
//            if(nums[i] == pre){
//                pre = nums[i];
//                if(++count > 2){
//                    continue;
//                }
//            }else {
//                count = 1;
//                pre = nums[i];
//            }
//            nums[p++] = nums[i];
//        }
//        return p;
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
