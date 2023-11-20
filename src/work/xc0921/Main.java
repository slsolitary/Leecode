package work.xc0921;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-21 19:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[] ans = new boolean[n];
        for(int i = 0;i < n;i++){
            String a = input.next();
            String b = input.next();
            ans[i] = isY(a,b);
        }
        for(int i = 0;i < n;i++){
            if(ans[i]){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static boolean isY(String a,String b){
        int length = a.length();
        int[] af = new int[length];
        int[] bf = new int[length];
        HashMap<Integer, Integer> amap = new HashMap<>();
        HashMap<Integer, Integer> bmap = new HashMap<>();
        for(int i = 0;i < length;i++){
            int aa = a.charAt(i)-'a';
            int bb = b.charAt(i)-'a';
            amap.put(aa,amap.getOrDefault(aa,0)+1);
            bmap.put(bb,bmap.getOrDefault(bb,0)+1);
            af[aa]++;
            bf[bb]++;
        }
        if(amap.size() < bmap.size()){
            return false;
        }
        Arrays.sort(af);
        Arrays.sort(bf);
//        int al = 0;
//        int bl = 0;
//        int count = 0;
//        while (al < length){
//            if(af[al] == af[bl]){
//
//            }
//        }
        return true;
        //        char[] rem = new char[26];
//        for(int i = 0;i < length;i++){
//            if(rem[a.charAt(i)-'a'] == ' '){
//                rem[a.charAt(i)-'a'] = b.charAt(i);
//            }
//            if(rem[a.charAt(i)-'a'] != ' ' && rem[a.charAt(i)-'a'] != b.charAt(i)){
//                return false;
//            }
//        }
//        return true;
    }
}
