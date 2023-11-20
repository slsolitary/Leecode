package competition.day353;

public class maxNonDecreasing {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1};
        int[] nums2 = new int[]{1,2,1};
        maxNonDecreasing maxNonDecreasing = new maxNonDecreasing();
        System.out.println(maxNonDecreasing.maxNonDecreasingLength(nums1, nums2));
    }
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int minBefore = Math.min(nums1[0],nums2[0]);
        int maxBefore = Math.max(nums1[0],nums2[0]);
        int maxNow = 0,minNow = 0;
        for(int i = 1;i < length;i++){
            maxNow = Math.max(nums1[i],nums2[i]);
            minNow = Math.min(nums1[i],nums2[i]);
            if(minNow >= maxBefore){
                dp[i][0] = Math.max(dp[i][0],Math.max(dp[i-1][0],dp[i-1][1])+1);
            }else if(minNow >= minBefore){
                dp[i][0] = Math.max(dp[i][0],dp[i-1][0]+1);
            }else {
                dp[i][0] = 1;
            }

            if(maxNow >= maxBefore){
                dp[i][1] = Math.max(dp[i][1],dp[i-1][1]+1);
            }else if(maxNow >= minBefore){
                dp[i][1] = Math.max(dp[i][1],dp[i-1][0]+1);
            }else {
                dp[i][1] = 1;
            }
            maxBefore=maxNow;
            minBefore=minNow;
        }
        int max = 1;
        for(int i = 0;i < length;i++){
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        return max;
    }
}
