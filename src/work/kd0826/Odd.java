package work.kd0826;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 14:32
 */
public class Odd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//数组长度
        //完美偶数:l≤x≤r
        int l = input.nextInt();
        int r = input.nextInt();
        int count = 0;
        for(int i = 0;i < n;i++){
            int x = input.nextInt();
            if(x >= l && x <= r && x % 2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
