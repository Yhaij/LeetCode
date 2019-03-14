package solution81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/13.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int l = 1;
        for (int i = 1; i <= n; i ++){
            for(int j = result.size()-1; j >= 0;j--){
                result.add(l + result.get(j));
            }
            l = 2*l;
        }
        return result;
    }
}
