package work.d360;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-23 17:50
 */
public class Two {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] strings = new String[n];
        for(int i = 0;i < n;i++){
            strings[i] = input.next();
        }
        boolean[] res = new boolean[n];
        for(int i = 0;i < n;i++){
            res[i] = isTrue(strings[i]);
            if(res[i])
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public static boolean isTrue(String s){
        String[] query = s.split("=");
        long l = ca(query[0]);
        long r = ca(query[1]);
        String tmp = "";
        long a = Math.max(l,r);
        if(l == r){
            return true;
        }else if(l < r){
            tmp = query[0];
        }else {
            tmp = query[1];
        }

        return isYes(tmp,a);
    }

    public static long ca(String s){
        ArrayDeque<Long> deque = new ArrayDeque<>();
        char pre = '+';
        long num = 0;
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i)) || i == n-1){
                switch (pre){
                    case '+':
                        deque.push(num);
                        break;
                    case '*':
                        deque.push(deque.pop()*num);
                }
                pre = s.charAt(i);
                num = 0;
            }
        }
        long res = 0;
        while (!deque.isEmpty()){
            res += deque.pop();
        }
        return res;
    }

    public static boolean isYes(String s,long a){
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(Character.isDigit(s.charAt(i))){
                for(int j = 0;j <= 9;j++){
                    String x = s.substring(0,i)+j+s.substring(i,n);
                    if(ca(x) == a){
                        return true;
                    }
                    String y = s.substring(0,i+1)+j+s.substring(i+1,n);
                    if(ca(y) == a){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}