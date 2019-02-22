package solution61_80;

import java.util.Arrays;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/21.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        for(int i = digits.length-1; i >= 0;i--){
            digits[i] += 1;
            if(digits[i] < 10){
                flag = 0;
                break;
            }else {
                digits[i] = digits[i]%10;
                flag = 1;
            }
        }
        if(flag == 1){
            int[] arr = new int[digits.length+1];
            System.arraycopy(digits, 0, arr, 1, digits.length);
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
