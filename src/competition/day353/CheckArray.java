package competition.day353;

import java.util.ArrayList;

public class CheckArray {
    public static void main(String[] args) {
        CheckArray test = new CheckArray();
        int[] nums = new int[]{2,2,3,1,1,0};
        int k = 3;
        System.out.println(test.checkArray(nums, k));
    }

    public boolean checkArray(int[] nums, int k) {
//        int n = nums.length,sumD = 0;
//        int[] d = new int[n+1];
//        for(int i = 0;i < n;i++){
//            sumD += d[i];
//            int tmp = nums[i];
//            tmp += sumD;
//            if(tmp == 0)
//                continue;
//            if(tmp < 0 || i+k > n)
//                return false;
//            sumD -= tmp;
//            d[i+k] += tmp;
//        }
//        return true;
        int n = nums.length;
        //差分数组
        int[] f = new int[n+1];
        f[0] = nums[0];
        f[n] = -nums[n-1];
        for(int i = 1;i < n;i++){
            f[i] = nums[i]-nums[i-1];
        }
        //从左到右对差分数组里的每个元素进行操作
        for(int i = 0;i+k<=n;i++){
            if(f[i] > 0){
                f[i+k] += f[i];
                f[i] = 0;
            }
        }
        //检查差分数组中是否所有元素均为0
        for(int i = 0;i <= n;i++){
            if(f[i] != 0){
                return false;
            }
        }
        return true;
    }
}
