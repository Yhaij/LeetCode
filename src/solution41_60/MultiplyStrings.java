package solution41_60;

/**
 * @Author: yhj
 * @Description: 大整数相乘
 * @Date: Created in 21:53 2018/12/15
 * @Modified By:
 **/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length() + num2.length();
        int[] value  = new int[m];
        for(int i = 0; i < num1.length();i++){
            for(int j = 0;j < num2.length();j++){
                value[m - i - j - 2] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
            }
        }

        //知道找到第一个高位不为0的数
        int index;
        for(index = value.length-1; index > 0 && value[index] == 0;index--);

        //处理进位并将结果放入StringBuilder中
        int f = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0 ;i <= index;i++){
            int n = value[i] + f;
            result.append(n%10);
            f = n/10;
        }
        if(f != 0){
            result.append(f);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyString = new MultiplyStrings();
        System.out.println(multiplyString.multiply("123", "456"));
    }
}
