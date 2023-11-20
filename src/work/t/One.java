package work.t;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 19:01
 */
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//数组大小
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        int[] brr = new int[n-1];
        for(int i = 0;i < n-1;i++){
            brr[i]=arr[i+1]-arr[i];
        }
        boolean isY = true;
        for(int i = 1;i < n;i++){
            if(arr[i] <= arr[i-1] || (i < n-1 && brr[i] >= brr[i-1])){
                isY = false;
                break;
            }
        }
        if(isY){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
