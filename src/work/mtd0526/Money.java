package work.mtd0526;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 10:09
 */
public class Money {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//账单数
        int m = input.nextInt();//除小红外的总人数
        int[] account = new int[m+1];
        for(int i = 0;i < n;i++){
            int k = input.nextInt();//一起吃饭的人数
            int c = input.nextInt();//价格
            int ev = (c+k-1) / k;
            for(int j = 1;j < k;j++){
                int index = input.nextInt();
                account[index] += ev;
            }
        }

        for(int i = 1;i <= m;i++){
            System.out.print(account[i]+" ");
        }
    }
}
