package work.mhy0827;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-27 21:01
 */
public class PaiMmmmmmmm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//数组的大小
        long[] arr = new long[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextLong();
        }
        int[] dp = new int[n];//i之前比它小的数的个数
        boolean flag = true;
        int win = 0;
//        for(int i = 1;i < n;i++){
//            flag = true;
//            for(int j = 0;j < i;j++){
//                if(arr[j] < arr[i]){
//                    dp[i]++;
//                }
//                if(arr[i] > arr[j] && (j == 0 || dp[j] == 0) && flag){
//                    win++;
//                    flag = false;
//                }
//            }
//        }
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(arr[j] < arr[i]&& (i == 0 || dp[i] == 0)){
                    dp[i] = 1;
                    break;
                }
            }
        }
        for(int i = 0;i < n;i++){
            win += dp[i];
        }
        int comp = comp(win, n);
        System.out.println(win/comp+"/"+n/comp);
    }

    public static int comp(int a,int b){
        if(b == 0){
            return a;
        }else {
            return comp(b,a % b);
        }
    }
}
