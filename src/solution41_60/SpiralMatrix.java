package solution41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description: 当最后剩下一行或者一列时需要单独考虑
 * @Date: Created in 21:35 2019/2/18
 * @Modified By:
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m == 0){
            return result;
        }
        int n = matrix[0].length;
        int low = 0,high = m-1,left = 0, right = n-1;
        while (low < high && left < right){
            for(int i = left; i <= right; i++){
                result.add(matrix[low][i]);
            }
            for(int i = low+1; i <= high;i++){
                result.add(matrix[i][right]);
            }
            for(int i = right-1; i >= left; i--){
                result.add(matrix[high][i]);
            }
            for(int i = high-1; i > low;i--){
                result.add(matrix[i][left]);
            }
            low++;high--;
            left++;right--;
        }
        if(low == high){
            for(int i = left; i <= right;i++){
                result.add(matrix[low][i]);
            }
        }else if(left == right){
            for(int i = low; i<= high;i++){
                result.add(matrix[i][left]);
            }
        }
        return result;
    }
}
