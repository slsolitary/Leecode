package competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-03 15:54
 */
public class TreeAncestor {
    private int[] depth;
    private int[][] pa;
    public TreeAncestor(int[][] edges){
        int n = edges.length+1;
        int m = 32-Integer.numberOfLeadingZeros(n);
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for(int[] e : edges){
            int x = e[0],y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        depth = new int[n];
        pa = new int[n][m];
        dfs(g,0,-1);
        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }
    //边-节点-父节点
    private void dfs(List<Integer>[] g,int x,int fa){
        pa[x][0] = fa;
        for(int y : g[x]){
            if(y != fa){
                depth[y] = depth[x]+1;
                dfs(g, y, x);
            }
        }
    }
    public int getKthAncestor(int node,int k){
        for(;k > 0;k &= (k-1)){
            node = pa[node][Integer.numberOfLeadingZeros(k)];
        }
        return node;
    }
    public int getLCA(int x,int y){
        if(depth[x] > depth[y]){
            int tmp=y;
            y = x;
            x = y;
        }
        y = getKthAncestor(y,depth[y]-depth[x]);
        if(y == x){
            return x;
        }
        for(int i = pa[x].length-1;i >= 0;i--){
            int px = pa[x][i],py = pa[y][i];
            if(px != py){
                x = px;
                y = py;
            }
        }
        return pa[x][0];
    }
}
