package competition.day370;

/**
 * @author heyao
 * @date 2023-11-05 10:30
 */
public class FindChampion {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int max = -1;
        int index = 0;
        for(int i = 0;i < n;i++){
            int tmp = 0;
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    tmp++;
                }
            }
            if(tmp >= max){
                max = tmp;
                index = i;
            }
        }
        return index;
    }


    public int findChampionII(int n, int[][] edges) {
//        if(edges.length == 0){
//            return n == 1 ? 0 : -1;
//        }
        //入度为0
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for(int[] arr : edges){
            int x = arr[0],y = arr[1];
            inDegree[y]++;
            outDegree[x]++;
        }
        int res = 8;
        int index = -1;
        for(int i = 0;i < n;i++){
            if(inDegree[i] == 0 && outDegree[i] >= 0){
                if(res == 0){
                    index = -1;
                    break;
                }else {
                    res = 0;
                    index = i;
                }
            }
        }
        return index;
    }
}
