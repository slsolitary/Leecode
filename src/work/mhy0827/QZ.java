package work.mhy0827;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-27 21:24
 */
public class QZ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0;i < n;i++){
            path.add(new ArrayList<>());
        }
        for(int i = 0;i < n;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            path.get(x).add(y);
            path.get(y).add(x);
        }
    }



}
