package work.d360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-23 17:46
 */
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        int maxValue = arr[n-1];
        int left = 0,right = 1;
        int count = 0;
        while (right < n){
            if(arr[left] == arr[right]){
                maxValue += arr[right];
                count++;
            }
            left++;
            right++;
        }
        System.out.println(count);
    }
}
