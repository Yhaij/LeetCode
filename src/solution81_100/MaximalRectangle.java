package solution81_100;

import java.util.Stack;

/**
 * @Author: yhj
 * @Description: 对于每一行都转为直方图，变成上一题IargestRectangleInHistogram求解
 * @Date: Created in 22:54 2019/3/11
 * @Modified By:
 **/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] p = new int[n][m];
        for(int i = 0; i < n;i++){
            for(int j = 0;j < m;j++){
                if (i == 0){
                    p[i][j] = matrix[i][j] == '0'? 0:1;
                }else {
                    p[i][j] = matrix[i][j] == '0'? 0:p[i-1][j]+1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < n;i++){
            int s = largestRectangleArea(p[i]);
            if(s > result){
                result = s;
            }
        }
        return result;
    }



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
