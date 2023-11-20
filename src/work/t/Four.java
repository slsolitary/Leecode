package work.t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 19:31
 */
public class Four {
    static final int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//数组长度
        int k = input.nextInt();//删除元素
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        int[][] dp = new int[n][n-k+1];
        for(int i = 0;i < n;i++){
            dp[i][1] = 1;
        }
        for(int j = 2;j <= n-k;j++){
            for(int i = j-1;i < n;i++){
                for(int l = 0;l < i;l++){
                    if(arr[i] % arr[l] == 0){
                        dp[i][j] += dp[l][j-1];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i < n;i++){
//            count = (count + dp[i][n-k]) % MOD;
            count += dp[i][n-k];
            count %= MOD;
        }
        System.out.println(count);
    }
}
