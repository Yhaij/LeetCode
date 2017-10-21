package solution21_40;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yhj on 2017/10/20.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        inOrOut(result, "", n, n);
        return result;
    }

    public void inOrOut(List<String> list, String s, int a, int b){
        if(a == 0 && b == 0){
            System.out.println(s);
            list.add(s);
        }
        if(a > 0){
            inOrOut(list, s+"(", a-1, b);
        }
        if(a < b){
            inOrOut(list, s + ")", a, b-1);
        }
    }
}
