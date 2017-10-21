package soulution1_20;

import java.util.Stack;

/**
 * Created by yhj on 2017/10/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()) {
                    return false;
                } else {
                    char a = stack.pop();
                    if ((c == ')' && a != '(') ||(c == ']' && a != '[') ||(c == '}' && a != '{')){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
