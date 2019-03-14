package solution81_100;

/**
 * @Author: yhj
 * @Description: 一维的dp问题，有最优子结构，递归慢
 * @Date: Created in 2019/03/13.
 */
public class DecodeWays {
//    public int numDecodings(String s) {
//        char[] c = s.toCharArray();
//        return traceBack(c, 0);
//    }
//
//    public int traceBack(char[] cArr, int index){
//        if(index == cArr.length){
//            return 1;
//        }
//        int count = 0;
//        if(cArr[index] > '0'){
//            count += traceBack(cArr, index+1);
//        }
//        if(index < cArr.length-1){
//            if(cArr[index] == '1' || (cArr[index] == '2' && cArr[index+1] <= '6')){
//                count += traceBack(cArr, index+2);
//            }
//        }
//        return count;
//    }

    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int[] p = new int[c.length+1];
        p[0] = 1;
        p[1] = c[0]=='0'?0:1;
        for (int i = 1;i < c.length;i++){
            if(c[i] > '0'){
                p[i+1] += p[i];
            }
            if(c[i-1] == '1' || (c[i-1] == '2' && c[i] <= '6')){
                p[i+1] += p[i-1];
            }
        }
        return p[c.length];
    }

}
