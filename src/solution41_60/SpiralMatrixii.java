package solution41_60;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/19.
 */
public class SpiralMatrixii {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int low = 0, high = n-1;
        int left = 0, right = n-1;
        int count = 0;
        while (low <= high && left <= right){
            for (int i = left; i <= right;i++){
                result[low][i] = ++ count;
            }
            for (int i = low+1;i <= high;i++){
                result[i][right] = ++ count;
            }
            for (int i = right-1;i >= left;i--){
                result[high][i] = ++ count;
            }
            for (int i = high-1;i > low;i--){
                result[i][left] = ++ count;
            }
            low++;high--;
            left++;right--;
        }
        return result;
    }
}
