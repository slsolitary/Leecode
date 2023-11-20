package work.t;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 19:14
 */
public class Three {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] arr = new int[n];
//        int maxValue = -1;
//        for(int i = 0;i < n;i++){
//            arr[i] = input.nextInt();
//            maxValue = Math.max(arr[i],maxValue);
//        }
//        int initValue = arr[0];
//        int count = 0;
//        while (initValue < maxValue){
//            initValue *= 2;
//            count++;
//        }
//        initValue = arr[0];
//        int tmp = initValue;
//        int countM = 0;
//        while (initValue < maxValue){
//            maxValue %= 2;
//            tmp *= 2;
//            countM++;
//        }
//        Arrays.sort(arr);
//        if(n > 2 && tmp >= arr[n-2]){
//            count = Math.min(count,countM);
//        }
//        System.out.println(count);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int maxValue = -1;
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
            maxValue = Math.max(arr[i],maxValue);
        }
        int initValue = arr[0];
        int count = 0;
        while (initValue < maxValue){
            maxValue /= 2;
            count++;
        }
        System.out.println(count);
    }
}
