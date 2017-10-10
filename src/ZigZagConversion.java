/**
 * Created by yhj on 2017/9/23.
 */
public class ZigZagConversion {
    public String convert(String s,int numRows){
        if(numRows == 1){
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i = 0;i < numRows;i++){
            stringBuilders[i] = new StringBuilder();
        }
        for(int i = 0;i<s.length();i++){
            int r = i%(numRows*2-2);
            if(r < numRows){
                stringBuilders[r].append(s.charAt(i));
            }else {
                stringBuilders[numRows*2-2-r].append(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<numRows;i++){
            result.append(stringBuilders[i]);
        }
        return result.toString();
    }

    public static void main(String[] args){
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }
}
