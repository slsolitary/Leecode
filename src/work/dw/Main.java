package work.dw;

import java.util.*;

/**
 * @author heyao
 * @date 2023-08-23 19:32
 */
public class Main {
    public static void main(String[] args) {
        //第一题
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0;i < n;i++){
//            nums[i] = scanner.nextInt();
//        }
//        Arrays.sort(nums);
//        int res = 0;
//        //0 2 4 6 8为一组
//        //1 3 5 7 9为一组
//        for(int i = 2;i < n;i+=2){
//            res = Math.max(res,Math.abs(nums[i]-nums[i-2]));
//        }
//        for(int i = 3;i < n;i+=2){
//            res = Math.max(res,Math.abs(nums[i]-nums[i-2]));
//        }
//        res = Math.max(res,Math.abs(nums[0]-nums[1]));
//        res = Math.max(res,Math.abs(nums[n-2]-nums[n-1]));
//        System.out.println(res);

        //第二题
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0;i < n;i++){
//            nums[i] = scanner.nextInt();
//            if(nums[i] == m){
//                System.out.println(1);
//            }
//        }
//        System.out.println("No solution");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            int a = scanner.nextInt();
            set.add(a);
            if(a == m){
                System.out.println(1);
            }
        }
        n = set.size();
        int[] nums = set.stream().mapToInt(Integer::intValue).toArray();
        //dp[i]：和为i所需要的最少个数
        int[] dp = new int[m + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < n;i++) {
            dp[nums[i]] = 1;
        }
        for(int i = 0;i < n;i++){
            dp[nums[i]] = 1;
            for(int j = nums[i];j <= m;j++){
                if(dp[j-nums[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-nums[i]]+1,dp[j]);
                }
            }
//            for(int j = m;j >= nums[i];j--){
//                if(dp[j-nums[i]] != Integer.MAX_VALUE){
//                    dp[j] = Math.min(dp[j-nums[i]]+1,dp[j]);
//                }
//            }
        }
        if(dp[m] == Integer.MAX_VALUE)
            System.out.println("No solution");
        else
            System.out.println(dp[m]);
    }

}
