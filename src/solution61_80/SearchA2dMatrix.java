package solution61_80;

/**
 * @Author: yhj
 * @Description: 二分查找
 * @Date: Created in 2019/2/26.
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        while (low <= high){
            int mid = (low + high)/2;
            int source = matrix[mid/n][mid%n];
            if(source > target){
                high = mid - 1;
            }else if(source < target){
                low = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
