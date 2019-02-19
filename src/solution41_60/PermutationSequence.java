package solution41_60;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/19.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] num = new int[n-1];
        boolean[] isUse = new boolean[n];
        int pre = 1;
        //放入每一个阶梯上的数量，即1个数为1，2个数为2,3个数为3*2=6
        for(int i = num.length-1;i >= 0; i--){
            num[i] = (num.length-i)*pre;
            pre = num[i];
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n-1){
            int t = (k-1)/num[i]+1;
            int c = k%num[i];
            if(c == 0){
                k = num[i];
            }else {
                k = c;
            }
            //寻找第t个未被使用的数字
            for(int j = 0;j < isUse.length;j++){
                if(!isUse[j]){
                    t--;
                    if(t == 0){
                        isUse[j] = true;
                        sb.append(j+1);
                        break;
                    }
                }
            }
            i++;
        }
        for(int j = 0;j < isUse.length;j++){
            if(!isUse[j]){
                sb.append(j+1);
                break;
            }
        }
        return sb.toString();
    }
}
