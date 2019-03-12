package solution81_100;

import java.util.Stack;

/**
 * @Author: yhj
 * @Description: 递增栈求解，如果加入大于栈顶元素则加入栈，
 * 小于的话出栈直到找到小于其的值，对于每一个出栈元素，其面积为其该元素值作为高，宽为当前index减去其栈中下一个元素的index
 * @Date: Created in 2019/03/02.
 */
public class IargestRectangleInHistogram {
    private class Node{
        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
        int value;
        int index;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();int m = 0;
        for (int i = 0;i < heights.length;i++){
            if(stack.isEmpty() || heights[i] > stack.peek().value){
                stack.push(new Node(heights[i], i));
            }else {
                while (!stack.isEmpty() && stack.peek().value > heights[i]){
                    Node node = stack.pop();
                    int s;
                    if (stack.isEmpty()){
                        s = node.value * i;
                    }else {
                        s = node.value * (i - stack.peek().index - 1);
                    }
                    if (s > m){
                        m = s;
                    }
                }
                stack.push(new Node(heights[i], i));
            }
        }
        while (!stack.isEmpty()){
            Node node = stack.pop();
            int s;
            if (stack.isEmpty()){
                s = node.value * heights.length;
            }else {
                s = node.value * (heights.length - stack.peek().index - 1);
            }
            if (s > m){
                m = s;
            }
        }return m;
    }
}
