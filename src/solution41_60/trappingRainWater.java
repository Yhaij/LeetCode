package solution41_60;

/**
 * @Author: yhj
 * @Description: 找到最高点，以最高点为界限，正序和倒序遍历，
 *               对于每一个元素，如果下面存在比起高的，那么在该元素和比其高的元素之间，加上该元素减去每一个元素的值
 * @Date: Created in 23:11 2018/12/9
 * @Modified By:
 **/
public class trappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }

        int max = 0, maxIndex = 0;
        for(int i = 0;i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int lowValue = 0;
        int sum = 0;
        for(int i = 0 ;i <= maxIndex; i++){
            if(height[i] > lowValue){
                lowValue = height[i];
            }else {
                sum += lowValue - height[i];
            }
        }

        int highValue = 0;
        for(int i = height.length-1; i >= maxIndex; i--){
            if(height[i] > highValue){
                highValue = height[i];
            }else{
                sum += highValue - height[i];
            }
        }
        return sum;
    }

}
