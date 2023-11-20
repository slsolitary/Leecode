package hot100;

/**
 * @author heyao
 * @date 2023-08-01 21:25
 * 53.最大子数组和
 */
public class maxSubArrays {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i = 1; i < n;i++){
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
