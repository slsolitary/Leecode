package work.mt.d0812;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-12 15:21
 */
public class Main {
    int n;
    int[] v;
    List<List<Integer>> graph = new ArrayList<>();
    int[][] dp;
    public static void main(String[] args) {


    }

    void solve(){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        v = new int[n+1];
        for(int i = 1;i <= n;i++){
            v[i] = input.nextInt();
        }
        for(int i = 0;i <= n;i++){
            graph.add(new LinkedList<>());
        }
        int res = 0;
        for(int i = 0;i < n-1;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dp = new int[n+1][2];//0染色 1不染色
        dfs(1,-1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    void dfs(int node, int pre) {
        for(int next : graph.get(node)){
            if(next != pre){
                dfs(next,node);
            }
        }

        if(graph.get(node).size() == 1 && graph.get(node).get(0) == pre){
            dp[node][1] = 1;
        }

        for(int next : graph.get(node)){
            if(next != pre){
                dp[node][0] += Math.max(dp[next][0],dp[next][1]);
            }
        }

        for (int next : graph.get(node)) {
            if (next != pre) {
                if (isAns(v[next], v[node])) dp[node][1] = Math.max(dp[node][0] - Math.max(dp[next][0], dp[next][1])+2+dp[next][0], dp[node][1]);
            }
        }
    }

    boolean isAns(int a,int b){
        if(a < 0 || b < 0)
            return false;
        long c = a * b;
        int sq = (int) Math.sqrt(c);
        return sq*sq == c;
    }
}
