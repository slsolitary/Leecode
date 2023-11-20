package work.wzbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-10-08 19:39
 */
public class One {
    static int res = Integer.MAX_VALUE;
    static List<int[]>[] edges;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        edges = new List[n+1];
        for(int i = 0;i <= n;i++){
            edges[i] = new ArrayList<int[]>();
        }
        int st = input.nextInt(),en = input.nextInt();
        int x = input.nextInt(),y = input.nextInt();
        int w = 0;
        edges[x].add(new int[]{y,w});
        edges[y].add(new int[]{x,w});
        for(int i = 0;i < m;i++){
            x = input.nextInt();
            y = input.nextInt();
            w = input.nextInt();
            edges[x].add(new int[]{y,w});
            edges[y].add(new int[]{x,w});
        }
        boolean[] used = new boolean[n+1];
        used[st] = true;
        dfs(0,st,en,used);
        System.out.println(res);
    }

    public static void dfs(int curTime,int st,int en,boolean[] used){
        if(st == en){
            res = Math.min(res,curTime);
        }
        List<int[]> edge = edges[st];
        for(int i = 0;i < edge.size();i++){
            int[] tmp = edge.get(i);
            int y = tmp[0];
            if(used[y]){
                continue;
            }
            used[y] = true;
            dfs(curTime+tmp[1],y,en,used);
            used[y] = false;
        }
    }
}
