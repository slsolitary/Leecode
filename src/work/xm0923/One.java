package work.xm0923;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-23 16:25
 */
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String[] split = s.split(",");
        int length = Integer.valueOf(split[0]);
        int radius = Integer.valueOf(split[1]);
        int[][] towers = new int[length][3];
        for(int i = 0;i < length;i++){
            s = input.next();
            split = s.split(",");
            towers[i][0]=Integer.valueOf(split[0]);
            towers[i][1]=Integer.valueOf(split[1]);
            towers[i][2]=Integer.valueOf(split[2]);
        }
        Arrays.sort(towers,(a,b)->a[0]-b[0]);
        int[] signal = new int[length];
        int maxValue = -1;
        int[] ans = new int[]{0,0};
        for(int i = 0;i < length;i++){
            int x0 = towers[i][0];
            int y0 = towers[i][1];
            for(int j = 0;j < length;j++){
                if(i == j){
                    signal[i] += towers[i][2];
                    continue;
                }
                int x = Math.abs(x0-towers[j][0]);
                int y = Math.abs(y0-towers[j][1]);
                double d = Math.sqrt(x*x+y*y);
                if(d > radius){
                    continue;
                }
                signal[i] += towers[j][2] / (1+d);
            }
            if(signal[i] > maxValue){
                maxValue = signal[i];
                ans[0] = x0;
                ans[1] = y0;
            }
        }
        System.out.println(ans[0]+","+ans[1]);
    }
}
