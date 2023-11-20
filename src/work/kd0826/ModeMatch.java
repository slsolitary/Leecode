package work.kd0826;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 14:40
 */
public class ModeMatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int t = Integer.valueOf(s);//询问次数
        int[] ans = new int[t];
        for(int i = 0;i < t;i++){
            String s1 = input.nextLine();
            String s2 = input.nextLine();
            ans[i] = countM(s1,s2);
        }
        for(int i = 0;i < t;i++){
            System.out.println(ans[i]);
        }
    }

    static int countM(String s1,String s2){
        int count = 0;
        int[] usedC1 = new int[3];
        int[] usedC2 = new int[3];
        if(s1.length() == s2.length()){
            count++;
        }
        for(int i = 0;i < s1.length();i++){
            char c = s1.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                usedC1[0] = 1;
            }else if(c >= '0' && c <= '9'){
                usedC1[1] = 1;
            }else {
                usedC1[2] = 1;
            }
        }
        for(int i = 0;i < s2.length();i++){
            char c = s2.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                usedC2[0] = 1;
            }else if(c >= '0' && c <= '9'){
                usedC2[1] = 1;
            }else {
                usedC2[2] = 1;
            }
        }
        if(usedC1[0]==usedC2[0] && usedC1[1]==usedC2[1] && usedC1[2]==usedC2[2]){
            count++;
        }
        return count;
    }
}
