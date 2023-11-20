package competition.day361;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-03 10:57
 */
public class CountInterestingSubarrays {
    public static void main(String[] args) {
        System.out.println(Integer.numberOfLeadingZeros(3));
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);nums.add(1);nums.add(9);nums.add(6);
        System.out.println(countInterestingSubarrays(nums, 3, 0));
    }
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//        int n = nums.size();
//        //dp[i]：[0,i]之间满足nums[i] % modulo == k的数量cnt
//        int[] dp = new int[n];
//        //isY[i]：nums[i]是否满足nums[i] % modulo == k
//        boolean[] isY = new boolean[n];
//        //初始化
//        if(nums.get(0) % modulo == k){
//            isY[0] = true;
//            dp[0] = 1;
//        }
//        for(int i = 1;i < n;i++){
//            if(nums.get(i) % modulo == k){
//                isY[i] = true;
//                dp[i] = dp[i-1]+1;
//            }else {
//                dp[i] = dp[i-1];
//            }
//        }
//        //统计趣味子数组个数
//        long count = 0;
//        //判断[i,j]子数组是否为趣味子数组
//        for(int i = 0;i < n;i++){
//            for(int j = i;j < n;j++){
//                int cnt = dp[j]-dp[i];//(i,j]
//                if(isY[i]){
//                    cnt++;
//                }
//                if(cnt % modulo == k){
//                    count++;
//                }
//            }
//        }
//        return count;
        int n = nums.size();
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            if(nums.get(i) % modulo == k) {
                dp[i] = 1;
            }
        }
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cur = 0;
        //(a - b) % m = k <=> b % m = (a - k) % m
        for(int i = 0;i < n;i++){
            cur += dp[i];
            int r = cur % modulo;
            int idx = map.getOrDefault(r,0);
            int l = (cur-k) % modulo;
            if (map.containsKey(l)){
                count += map.get(l);
            }
            map.put(r,idx+1);
        }
        return count;
    }
}
