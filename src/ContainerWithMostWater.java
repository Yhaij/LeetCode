/**
 * Created by yhj on 2017/10/8.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int p = 0;
        int q = height.length-1;
        int mArea = 0;
        int pre;
        while (p < q){
            int area;
            if(height[p]>height[q]){
                area = height[q]*(q-p);
                for(pre = q;height[pre]<=height[q] && p<pre;pre--);
                q = pre;
            }else {
                area = height[p]*(q-p);
                for(pre = p;height[pre]<=height[p] && pre<q;pre++);
                p = pre;
            }
            if(area > mArea){
                mArea = area;
            }
        }
        return mArea;
    }

    public static void main(String args[]){
        int[] height = {1,1};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
