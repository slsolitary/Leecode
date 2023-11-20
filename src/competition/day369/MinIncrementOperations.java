package competition.day369;

/**
 * @author heyao
 * @date 2023-10-29 10:53
 */
public class MinIncrementOperations {
    public static void main(String[] args) {
        MinIncrementOperations test = new MinIncrementOperations();
//        int k = 4;
//        int[] nums = {2,3,0,0,2};
//        int k = 5;
//        int[] nums = {0,1,3,3};
//        int k = 1;
//        int[] nums = {1,1,2};
        int k = 8;
        int[] nums = {1,2,6,9};
//        int k = 67;
//        int[] nums = {20,2,22,30};
//        int[] nums = {6,5,8,6,0,9};
//        int k = 9;
        System.out.println(test.minIncrementOperations(nums,k));
    }
    public long minIncrementOperations(int[] nums, int k) {
//        int n = nums.length;
//        long[][] dp = new long[n][2];
//        boolean[] isY = new boolean[n];//[i-2,i-1,i]里需要修改一次
//        long[] diff = new long[n];
//        for(int i = 0;i < n;i++){
//            diff[i]=nums[i] < k ? k-nums[i]:0;
//            if(i > 2 && diff[i-1]>0 && diff[i-2]>0 && diff[i] >0)
//                isY[i]=true;
//        }
//        for(int i = 0;i < 2;i++){
//            dp[i][1]=nums[i] < k ? k-nums[i]:0;
//        }
//        for(int i = 2;i < n;i++){
//            if(nums[i] >= k){
//                if(i > 2 && isY[i-1]){
//                    dp[i][0]=Math.min(dp[i-1][1],dp[i-2][1]);
//                    dp[i][1]=Math.min(dp[i-1][1],dp[i-2][1]);
//                }else {
//                    dp[i][1]=Math.min(dp[i-1][0],dp[i-2][0]);
//                    dp[i][0]=Math.min(dp[i-1][0],dp[i-2][0]);
//                }
//            }else {
//                if(i > 2 && nums[i-3] < k){
//                    dp[i][0]=Math.min(dp[i-1][1],dp[i-2][1]);
//                    dp[i][1]=Math.min(Math.min(dp[i-1][1],dp[i-2][1]),dp[i-3][1])+k-nums[i];
//                }else {
//                    dp[i][1]=Math.min(dp[i-1][0],dp[i-2][0])+k-nums[i];
//                    dp[i][0]=Math.min(dp[i-1][1],dp[i-2][1]);
//                }
//            }
//        }
//        return Math.min(dp[n-1][0],dp[n-1][1]);
        int n = nums.length;
        long[] diff = new long[n];
        //dp[i]表示[0,i]位置i大于等于k时最小修改次数
        long[] dp = new long[n];
        for(int i = 0;i < n;i++){
            diff[i]=nums[i] < k ? k-nums[i]:0;
        }
        dp[0]=diff[0];
        dp[1]=diff[1];
        dp[2]=diff[2];
        for(int i = 3;i < n;i++){
            dp[i]=Math.min(Math.min(dp[i-2],dp[i-1]),dp[i-3])+diff[i];
        }
        return Math.min(Math.min(dp[n-3],dp[n-2]),dp[n-1]);
    }
}
