package solution41_60;

/**
 * @Author: yhj
 * @Description: 位图法,题目不严谨才可以用这个方法,1000应该是Integer.MAX_VALUE/32,但是这样提交会超出内存限制
 *              << 1表示乘2;>> 1 表示除以2
 *              也可以使用鸽舍问题来解决，但是这都是基于题目不严谨的情况下
 * @Date: Created in 22:36 2018/12/9
 * @Modified By:
 **/
public class firstMissingPositive {
//    /**
//     * 位图法求解
//     * @param nums
//     * @return
//     */
//    public int firstMissingPositive(int[] nums) {
//        int[] result = new int[1000];
//        for(int i = 0; i < nums.length;i++){
//            if(nums[i] > 0){
//                result[nums[i]/32] |= 1 << nums[i]%32;
//            }
//        }
//        for(int i = 1; i < Integer.MAX_VALUE;i++){
//            if((result[i/32] & 1 << i%32) == 0){
//                return i;
//            }
//        }
//        return -1;
//    }

    public int firstMissingPositive(int[] nums) {
        int size=nums.length;
        int i=0;
        while(i<size)
        {
            int idx=nums[i]-1;
            if(idx<0 || idx>=size || nums[i]==i+1 || nums[idx]==nums[i])
            {
                ++i;
                continue;
            }
            nums[i]^=nums[idx];
            nums[idx]^=nums[i];
            nums[i]^=nums[idx];
        }
        for(int j=0;j<size;++j)
            if(nums[j]!=j+1)
                return j+1;
        return size+1;
    }
}
