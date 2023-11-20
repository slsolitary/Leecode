package work.oppo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 10:22
 */
public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        int a0 = arr[0]+arr[1];
        int an = arr[n-1];
        int a1 = arr[2];
        int ans;
        if(n == 3){
            ans = Math.abs(an-a0);
        }else {
            ans = Math.abs(an-Math.min(a0,a1));
        }
        ans = Math.min(ans,arr[n-1]-arr[0]);
        System.out.println(ans);
//        int ans = arr[n-1]-Math.min(arr[0]+arr[1],arr[2]);
//        System.out.println(ans);
    }
}
