package work.t;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 19:07
 */
public class Two {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String[] arr = new String[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.next();
        }
        String target = "meituan";
        boolean isExist = false;
        int index = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(arr[i].charAt(j) == target.charAt(index)){
                    index++;
                    break;
                }
            }
            if(index == target.length()){
                isExist = true;
                break;
            }
        }
        if(isExist){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
