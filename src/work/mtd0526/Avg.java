package work.mtd0526;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 10:31
 */
public class Avg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//长度
        int k = input.nextInt();//操作次数
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        long a = (long) 1e9+7;
        System.out.println(a);
        long  account = 1l;
        for(int i = n-1;i >= n-1-k;i--){
            account = account * nums[i] % a;
        }
        for(int i = 0;i < n-1-k;i++){
            account = (account+nums[i]) % a;
        }
        account = (account+k) % a;
        System.out.println(account);

    }
}
