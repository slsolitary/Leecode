package competition.day353;

public class maximumJump {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,3};
        int target = 1;
        maximumJump test = new maximumJump();
        System.out.println(test.maximumJumps(nums, target));
    }
    public int maximumJumps(int[] nums,int target){
        int length = nums.length;
        int[] dp = new int[length];
        for(int i = 1;i < length;i++){
            for(int j = 0;j < i;j++){
                if(j == 0 && Math.abs(nums[i]-nums[j]) <= target){
                    dp[i] = 1;
                }else if(dp[j] > 0 && Math.abs(nums[i]-nums[j]) <= target){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[length-1]==0 ? -1:dp[length-1];
    }
}
