package work.oppo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 10:43
 */
public class mkdir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] st = new String[n];
        for(int i = 0;i < n;i++){
            st[i] = input.next();
        }
        //字符串-出现频次
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int fre = map.getOrDefault(st[i], 0);
            map.put(st[i],fre+1);
            if(fre == 0){
                System.out.println(st[i]);
            }else {
                System.out.println(st[i]+"("+fre+")");
            }
        }
    }
}
