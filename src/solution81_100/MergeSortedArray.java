package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 23:15 2019/3/12
 * @Modified By:
 **/
public class MergeSortedArray {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = 0, j = 0, k = 0;
//        int[] result = new int[nums1.length];
//        while (i < m && j < n){
//            while (i < m && j < n && nums1[i] <= nums2[j]){
//                result[k++] = nums1[i++];
//            }
//            while (i < m && j < n && nums2[j] <= nums1[i]){
//                result[k++] = nums2[j++];
//            }
//
//        }
//        while (i < m){
//            result[k++] = nums1[i++];
//        }
//        while (j < n){
//            result[k++] = nums2[j++];
//        }
//        for(int l = 0;l < m+n;l++){
//            nums1[l] = result[l];
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        for (int i = index; i >= 0; i--) {
            if (indexA == -1 || indexB == -1) {
                break;
            }
            if (nums1[indexA] > nums2[indexB]) {
                nums1[i] = nums1[indexA];
                indexA--;
            } else {
                nums1[i] = nums2[indexB];
                indexB--;
            }
        }
        while (indexB >= 0) {
            nums1[indexB] = nums2[indexB];
            indexB--;
        }
    }
}
