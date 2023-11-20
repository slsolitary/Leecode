package work.xc0921;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-21 19:47
 */
public class Three {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String[] s = new String[n];
        for(int i = 0;i < n;i++){
            s[i] = input.next();
        }
        System.out.println(m*n);
    }
}
