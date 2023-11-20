package work.hw;

/**
 * @author heyao
 * @date 2023-10-12 20:03
 */
public class two {

    public int func(int[][] arr){
        int m = arr.length,n = arr[0].length;
        boolean[][] used = new boolean[m][n];
        int res = 0;
        for(int i = 0;i < m;i++) {
            for (int j = 0; j < n; j++) {
                used[i][j]=true;
                res = Math.max(res,dfs(arr,used,i,j,0));
                used[i][j]=false;
            }
        }
        return res;
    }

    //返回值：当前最大的次数
    public int dfs(int[][] arr,boolean[][] used,int x,int y,int pre){
        int res = 0;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int m = arr.length,n = arr[0].length;
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                int newX = x+dx[i];
                int newY = y+dy[j];
                if(newX < 0 || newX > m || newY < 0 || newY > n || used[newX][newY]){
                    continue;
                }
                int t = 0;
                if(arr[newX][newY] > arr[x][y]){
                    t = -1;
                }else {
                    t = 1;
                }
                if(pre == 0 || pre != t){
                    used[newX][newY]=true;
                    res = Math.max(res,dfs(arr,used,newX,newY,t)+1);
                    used[newX][newY]=false;
                }
            }
        }
        return res;
    }
}
