package competition.day363;

import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-17 11:07
 */
public class MaximumSum {
    public static void main(String[] args) {
        float a = 1.0f;
        float b = 1.0f;
//        float c = 1.0f;
//        String c = "sse";
        int c = Integer.MAX_VALUE;
        System.out.println(testt(a, b, c));
    }
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        long[] sum = new long[n+1];
        for(int i = 0;i < n;i++){
            int c = core(i+1);
            sum[c] += nums.get(i);
            ans = Math.max(ans,sum[c]);
        }
        return ans;
    }

    public int core(int n){
        int res = 1;
        for(int i = 2;i * i <= n;i++){
            int e = 0;
            while (n % i == 0){
                e++;
                n /= i;
            }
            if(e % 2 == 1){
                res *= i;
            }
        }
        if(n > 1){
            res *= n;
        }
        return res;
    }

    public static double testt(double a,double b,double c){
        return a*b;
    }
}
