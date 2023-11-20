package competition.day370;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyao
 * @date 2023-11-05 10:55
 */
public class MaximumScoreAfterOperations {
    public static void main(String[] args) {
        MaximumScoreAfterOperations test = new MaximumScoreAfterOperations();
        int[][] edges = {{2,0},{4,1},{5,3},{4,6},{2,4},{5,2},{5,7}};
        int[] values = {12,12,7,9,2,11,12,25};
//        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
//        int[] values = {20,10,9,7,4,3,5};
        System.out.println(test.maximumScoreAfterOperations(edges, values));
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        ArrayList<Integer>[] edge = new ArrayList[n];
        long sum = 0l;
        for(int i = 0;i < n;i++){
            edge[i] = new ArrayList<Integer>();
            sum += values[i];
        }
        for(int i = 0;i < n-1;i++){
            int x = edges[i][0],y = edges[i][1];
            edge[x].add(y);
            edge[y].add(x);
        }
        boolean[] used = new boolean[n];
        used[0]=true;
        long minDiff = dfs(edge, values, 0,used);
        return Math.max(sum-minDiff,sum-values[0]);
    }

    public long dfs(ArrayList[] edge,int[] values,int index,boolean[] used){
        //计算左右子树 和最小的层数 比如左子树取第x层 右子树取第y层
        ArrayList<Integer> tmp = edge[index];
//        if(tmp.size() == 0){
//            return values[index];
//        }
        long sum = 0;
        boolean isYZ = true;//节点index是否为叶子节点
        for(int i = 0;i < tmp.size();i++){
            int next = tmp.get(i);
            if(used[next] == false){
                used[next] = true;
                sum += dfs(edge,values,next,used);
                used[next] = false;
                isYZ = false;
            }
        }
        return isYZ ? values[index] : Math.min(sum,values[index]);
    }
}
