import java.util.*;

/**
 * Created by yhj on 2017/10/11.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// 首先需要排序
        for(int i = 0;i < nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){//保证不会有重复的结果
                int low = i+1, high = nums.length-1;
                while (low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        for(low++;low<high && nums[low] == nums[low-1];low++);//保证不会有重复的结果
                        for(high--;low<high && nums[high] == nums[high+1];high--);//保证不会有重复的结果
                    }else {
                        if(sum < 0){
                            low ++ ;
                        }else {
                            high--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public void quickSort(Integer[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int p = nums[start];
        int low = start, high = end;
        while (low < high){
            for(;nums[high] > p && low < high;high--);
            nums[low] = nums[high];
            for(;nums[low] < p && low < high;low++);
            nums[high] = nums[low];
        }
        nums[low] = p;
        quickSort(nums, start, low-1);
        quickSort(nums, low+1, end);
    }

    public static void main (String args[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};

    }
}
