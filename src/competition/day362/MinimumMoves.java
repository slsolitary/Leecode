package competition.day362;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author heyao
 * @date 2023-09-10 11:00
 */
public class MinimumMoves {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,1,0},{1,1,1},{1,2,1}};
//        int[][] grid = new int[][]{{1,3,0},{1,0,0},{1,0,3}};
        int[][] grid = new int[][]{{1,2,2},{1,1,0},{0,1,1}};
        MinimumMoves test = new MinimumMoves();
        System.out.println(test.minimumMoves(grid));
    }

//    static int ans = 0;
//    static int[][] g = new int[3][3];
//    public static int minimumMoves(int[][] grid) {
//        ArrayList<int[]> list = new ArrayList<>();
//        for(int i = 0;i < 3;i++){
//            for(int j = 0;j < 3;j++){
//                g[i][j] = grid[i][j];
//                if(grid[i][j] > 1){
//                    list.add(new int[]{grid[i][j],i,j});
//                }
//            }
//        }
//        Collections.sort(list,(a,b) -> b[0]-a[0]);
//        for(int i = 0;i < list.size();i++){
//            boolean[][] used = new boolean[3][3];
//            int[] num = list.get(i);
//            int x = num[1];
//            int y = num[2];
//            dfs(x,y,x,y,used);
//        }
//        return ans;
//    }
//
//    public static void dfs(int x,int y,int xpre,int ypre,boolean[][] used){
//        if(g[xpre][ypre] == 1){
//            return;
//        }
//        int[] dx = new int[]{0,0,1,-1};
//        int[] dy = new int[]{1,-1,0,0};
//        for(int i = 0;i < 4;i++){
//            int xnew = x + dx[i];
//            int ynew = y + dy[i];
//            if(xnew < 0 || ynew < 0 || xnew >= 3 || ynew >= 3 || used[xnew][ynew]){
//                continue;
//            }else {
//                if(g[xnew][ynew] == 0){
//                    g[xnew][ynew] = 1;
//                    g[xpre][ypre] -= 1;
//                    ans += Math.abs(xpre-xnew)+Math.abs(ypre-ynew);
//                }
//                used[xnew][ynew] = true;
//            }
//        }
//        if(g[xpre][ypre] == 1){
//            return;
//        }
//
//        dx = new int[]{1,1,-1,-1,0,0,2,-2};
//        dy = new int[]{1,-1,1,-1,2,-2,0,0};
//        for(int i = 0;i < 8;i++){
//            int xnew = x + dx[i];
//            int ynew = y + dy[i];
//            if(xnew < 0 || ynew < 0 || xnew >= 3 || ynew >= 3 || used[xnew][ynew]){
//                continue;
//            }else {
//                if(g[xnew][ynew] == 0){
//                    g[xnew][ynew] = 1;
//                    g[xpre][ypre] -= 1;
//                    ans += Math.abs(xpre-xnew)+Math.abs(ypre-ynew);
//                }
//                used[xnew][ynew] = true;
//            }
//        }
//        if(g[xpre][ypre] == 1){
//            return;
//        }
//
//        dx = new int[]{0,0,3,-3,1,1,-2,2};
//        dy = new int[]{3,-3,0,0,2,-2,1,1};
//        for(int i = 0;i < 8;i++){
//            int xnew = x + dx[i];
//            int ynew = y + dy[i];
//            if(xnew < 0 || ynew < 0 || xnew >= 3 || ynew >= 3 || used[xnew][ynew]){
//                continue;
//            }else {
//                if(g[xnew][ynew] == 0){
//                    g[xnew][ynew] = 1;
//                    g[xpre][ypre] -= 1;
//                    ans += Math.abs(xpre-xnew)+Math.abs(ypre-ynew);
//                }
//                used[xnew][ynew] = true;
//            }
//        }
//        if(g[xpre][ypre] == 1){
//            return;
//        }
//
//        dx = new int[]{2,-2,2,-2};
//        dy = new int[]{2,-2,-2,2};
//        for(int i = 0;i < 8;i++){
//            int xnew = x + dx[i];
//            int ynew = y + dy[i];
//            if(xnew < 0 || ynew < 0 || xnew >= 3 || ynew >= 3 || used[xnew][ynew]){
//                continue;
//            }else {
//                if(g[xnew][ynew] == 0){
//                    g[xnew][ynew] = 1;
//                    g[xpre][ypre] -= 1;
//                    ans += Math.abs(xpre-xnew)+Math.abs(ypre-ynew);
//                }
//                used[xnew][ynew] = true;
//            }
//        }
//        if(g[xpre][ypre] == 1){
//            return;
//        }
//    }
    int ans = Integer.MAX_VALUE;
    public int minimumMoves(int[][] grid) {
        ArrayList<int[]> a = new ArrayList<>();
        ArrayList<int[]> b = new ArrayList<>();
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(grid[i][j] > 1){
                    b.add(new int[]{i,j});
                }else if(grid[i][j] == 0){
                    a.add(new int[]{i,j});
                }
            }
        }
        dfs(0,grid,a,b,0);
        return ans;
    }

    public void dfs(int i,int[][] grid,ArrayList<int[]> a,ArrayList<int[]> b,int cnt){
        if(i == a.size()){
            ans = Math.min(ans,cnt);
            return;
        }
        int[] p = a.get(i);
        for(int j = 0;j < b.size();j++){
            int[] q = b.get(i);
            int x = grid[q[0]][q[1]];
            if(x > 1){
                grid[q[0]][q[1]] --;
                dfs(i+1,grid,a,b,cnt+Math.abs(q[0]-p[0])+Math.abs(q[1]-p[1]));
                grid[q[0]][q[1]] ++;
            }
        }
    }
}
