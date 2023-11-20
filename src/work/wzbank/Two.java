package work.wzbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-10-08 19:34
 */
public class Two {
    static List<int[]> list;//其他楼房位置
    static int ax = 0,ay = 0;//大楼位置
    static int res = 0;
    static boolean[][] used;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int r = input.nextInt();
        String[] arr = new String[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.next();
        }
        int[][] nums = new int[n][m];
        list = new ArrayList<>();
        for (int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                int x = arr[i].charAt(j)-'0';
                nums[i][j] = x;
                if(x == 1){
                    list.add(new int[]{i,j});
                }else if(x == 2){
                    ax = i;ay = j;
                }
            }
        }
        dfs(nums,r);
        System.out.println(res);
    }

    public static void dfs(int[][] nums,int r){
        for (int i = 0;i < nums.length;i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if(nums[i][j] == 0 && isValid(i,j,r)){
                    res++;
                }
            }
        }
    }

    public static boolean isValid(int x,int y,int r){
        int dis = Math.abs(x-ax)+ Math.abs(y-ay);
        if(dis > r){
            return false;
        }
        for(int i = 0;i < list.size();i++){
            int[] a = list.get(i);
            dis = Math.abs(a[0]-x)+Math.abs(a[1]-y);
            if(dis <= r){
                return false;
            }
        }
        return true;
    }
}
