package competition.day368;

/**
 * @author heyao
 * @date 2023-10-22 10:30
 */
public class MinimumSum {
    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(nums[i] >= nums[j]){
                    continue;
                }
                for(int k = j+1;k < n;k++){
                    if(nums[k] >= nums[j]){
                        continue;
                    }
                    int tmp = nums[i]+nums[j]+nums[k];
                    res = Math.min(res,tmp);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int minimumSumII(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int[] left = new int[n];//[0,i]里的最小值
        int[] right = new int[n];//[i,n-1]里的最小值
        //满足条件的值为left[i-1]+nums[i]+right[i+1];
        left[0] = nums[0];
        for(int i = 1;i < n;i++){
            left[i]=Math.min(left[i-1],nums[i]);
        }
        right[n-1] = nums[n-1];
        for(int i = n-2;i >= 0;i--){
            right[i]=Math.min(right[i+1],nums[i]);
        }
        for(int i = 1;i < n-1;i++){
            if(left[i-1] >= nums[i] || right[i+1] >= nums[i]){
                continue;
            }
            int tmp = left[i-1]+nums[i]+right[i+1];
            res = Math.min(res,tmp);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
