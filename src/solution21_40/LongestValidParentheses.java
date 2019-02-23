package solution21_40;

import java.util.Stack;

/**
 * Created by yhj on 2017/11/8.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int l = 0;
        int m1 = 0,m2=0;
        int p = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else {
                if(!stack.empty()){
                    stack.pop();
                    if (stack.empty()){
                        p = i+1;
                    }
                }
            }
        }
        stack.clear();
        for (int i = 0; i < p;i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else {
                if(stack.empty()){
                    if(l > m1){
                        m1 = l;
                    }
                    l = 0;
                }else {
                    stack.pop();
                    l = l+2;
                }
            }
        }
        if (stack.empty() && l > m1){
            m1 = l;
        }
        stack.clear();l  = 0;
        for(int i = s.length()-1;i>=p;i--){
            if(s.charAt(i) == ')'){
                stack.push(')');
            }else {
                if(stack.empty()){
                    if(l > m2){
                        m2 = l;
                    }
                    l = 0;
                }else {
                    stack.pop();
                    l  = l+2;
                }
            }
        }
        if(stack.empty() && l > m2){
            m2 = l;
        }
        return m1>m2?m1:m2;
    }
}
