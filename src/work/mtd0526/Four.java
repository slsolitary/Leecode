package work.mtd0526;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 11:00
 */
public class Four {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();//询问次数
        boolean[] ans = new boolean[q];
        for(int i = 0;i < q;i++){
            int n = input.nextInt();//数组长度
            int m = input.nextInt();//数值
            int[] a = new int[n];
            int[] b = new int[n];
            for(int j = 0;j < n;j++){
                a[j] = input.nextInt();
            }
            for(int j = 0;j < n;j++){
                b[j] = input.nextInt();
            }
            ans[i] = isTrue(a,b,n,m);
        }
        for(int i = 0;i < q;i++){
            if(ans[i]){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static boolean isTrue(int[] a,int[] b,int n,int m){
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0;i < n;i++){
            if(a[n-i-1] + b[i] < 1 || a[n-i-1] + b[i] > m){
                return false;
            }
        }
        return true;
    }
}
