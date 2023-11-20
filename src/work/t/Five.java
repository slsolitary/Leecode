package work.t;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 19:46
 */
public class Five {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//数组长度
        int[] arr = new int[n];
        //糖果类型-出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int size = map.size();
        int[] candy = new int[size];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            candy[i] = entry.getValue();
            i++;
        }
        int count = 0;
        Arrays.sort(candy);
        for(i = 0;i < size;i++){
            if (candy[i] == 0 ){
                continue;
            }
            for(int j = i+1;j < size;j++){
                if(candy[j] == 0){
                    continue;
                }else {
                    count++;
                    candy[i]--;
                    candy[j]--;
                }
                if(candy[i] == 0){
                    break;
                }
            }
        }
        for(i = 0;i < size;i++){
            if(candy[i] >= 2){
                count++;
            }
        }
        System.out.println(count);
    }
}
