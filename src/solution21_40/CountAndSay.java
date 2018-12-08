package solution21_40;

import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 21:13 2018/12/8
 * @Modified By:
 **/
public class CountAndSay {
    public String countAndSay(int n) {
        char[] target = new char[10000];
        target[0] = '1';
        int length = 1;
        for(int i = 1; i < n; i++){
            char[] result = new char[10000];
            char pre = target[0];
            int count = 0;
            int newLength = 0;
            for(int j = 0; j < length;j++){
                if(pre == target[j]){
                    count ++;
                }else {
                    result[newLength++] = (char) ('0' + count);
                    result[newLength++] = pre;
                    pre = target[j];
                    count = 1;
                }
            }
            result[newLength++] = (char) ('0' + count);
            result[newLength++] = pre;
            length = newLength;
            target = result;
        }

        return new String(target, 0, length);
    }

}
