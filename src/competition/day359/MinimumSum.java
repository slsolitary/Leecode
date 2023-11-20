package competition.day359;

import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-08-20 10:41
 */
public class MinimumSum {
    public static void main(String[] args) {
        System.out.println(minimumSum(3, 5));
    }
    static public int minimumSum(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = i+1;
        }
        int tmp = n+1;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(nums[i]+nums[j] == k){
                    nums[j] = tmp;
                    tmp++;
                    for(int l = j-1;l >=0 ;l--){
                        if(nums[j]+nums[l] == k){
                            nums[j] = tmp;
                            tmp++;
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0;i < n;i++){
            res += nums[i];
        }
        return res;
    }
}
