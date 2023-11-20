package work.mtd0526;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 10:01
 */
public class Fruit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();//浇水
        int y = input.nextInt();//施肥
        int z = input.nextInt();//目标
        long count = 0l;
        long times = 0l;//当前频次 每当times为3的倍数的时候，就施肥
        while (count < z){
            count += x;
            if(times % 3 == 0){
                count += y;
            }
            times++;
        }
        System.out.println(times);
    }
}
