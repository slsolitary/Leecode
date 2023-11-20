package competition.day357;

import java.util.*;

/**
 * @author heyao
 * @date 2023-08-06 11:15
 */
public class MaximumSafenessFactor {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        int n = 400;
        for(int i = 0;i < n;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0;j < n;j++){
                tmp.add(1);
            }
            grid.add(tmp);
        }
        MaximumSafenessFactor test = new MaximumSafenessFactor();
        System.out.println(test.maximumSafenessFactor(grid));
    }

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dp = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            List<Integer> list = grid.get(i);
            for(int j = 0;j < n;j++){
                if(list.get(j) == 1) {
                    dp[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
                else
                    dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //统计每个位置的安全系数，由小偷位置向四周散开
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0],y = poll[1];
            for(int[] dir : dirs){
                int nx = x+dir[0],ny = y+dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }
                if(dp[nx][ny] != Integer.MAX_VALUE){
                    continue;
                }
                dp[nx][ny]=dp[x][y]+1;
                queue.add(new int[]{nx,ny});
            }
        }

        //找最大安全系数
        //利用有序队列，按递减顺序排列。
        int ans = Math.min(dp[0][0],dp[n-1][n-1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(nums -> -dp[nums[0]][nums[1]]));
        pq.add(new int[]{0,0});
        boolean[][] vis = new boolean[n][n];
        vis[0][0]=true;
        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            int x = poll[0],y = poll[1];
            if(x == n-1 && y == n-1){
                break;
            }
            ans = Math.min(ans,dp[x][y]);
            for(int[] dir : dirs){
                int nx = x + dir[0],ny = y+dir[1];
                if(nx < 0 || ny <0 || nx >= n||ny >= n){
                    continue;
                }
                if(vis[nx][ny]){
                    continue;
                }
                vis[nx][ny]=true;
                pq.add(new int[]{nx,ny});
            }
        }
        return ans;
    }
}
