package work.xc0921;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-21 19:02
 */
public class One {
    static int[] ans;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        ans = new int[n];
        boolean[] used = new boolean[n+1];
        dfs(used,n,0,arr,0);
    }

    public static void dfs(boolean[] used,int n,int index,int[] arr,int count){
        if(index == n){
            return;
        }
        for(int i = index;i < n;i++){
            for(int j = 1;j <= n;j++){
                if(!used[j] && j != arr[i]){
                    int tmp = ans[i];
                    ans[i] = j;
                    used[j] = true;
                    count++;
                    dfs(used,n,i+1,arr,count);
                    if(count == n){
                        for(int k = 0;k < n;k++){
                            System.out.print(ans[k]+" ");
                        }
                        return;
                    }
                    count--;
                    used[j] = false;
                    ans[i] = tmp;
                }
            }
        }
    }
}
