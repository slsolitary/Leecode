package competition.day361;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-03 16:11
 */
public class MinOperationsQueries {
    private int[][] pa;
    private int[] depth;
    private int[][][] cnt;
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        //此处存入w-1是为了方便后面统计路径上权重数目可以直接对应上索引w-1
        for(int[] e : edges){
            int x = e[0],y = e[1],w = e[2];
            g[x].add(new int[]{y,w-1});
            g[y].add(new int[]{x,w-1});
        }
        int m = 32-Integer.numberOfLeadingZeros(n);//计算n的二进制长度
        pa = new int[n][m];
        depth = new int[n];
        cnt = new int[n][m][26];
        //更新每个节点的深度
        dfs(g,0,-1);
        //倍增
        for(int i = 0;i < m-1;i++){
            for(int x = 0;x < n;x++){
                int p = pa[x][i];
                if(p != -1){
                    pa[x][i+1] = pa[p][i];
                    for(int j = 0;j < 26;j++){
                        cnt[x][i+1][j] = cnt[x][i][j]+cnt[p][i][j];
                    }
                }else {
                    pa[x][i+1] = -1;
                }
            }
        }
        int[] answers = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int x = query[0];
            int y = query[1];
            int pathLen = depth[x]+depth[y];
            if(depth[x] > depth[y]){
                int tmp = x;
                x = y;
                y = tmp;
            }
            //将y与x移到一层
            int[] cw = new int[26];
            int k = depth[y]-depth[x];
            for(int j = 0;j < m;j++){
                if(((k >> j) & 1) == 1){
                    int p = pa[y][j];
                    for(int l = 0;l < 26;l++){
                        cw[l] += cnt[y][j][l];
                    }
                    y = p;
                }
            }
            //找y与x的最近公共祖先
            if(y != x){
                for(int j = m-1;j >= 0;j--){
                    int px = pa[x][j];
                    int py = pa[y][j];
                    if(px != py){
                        for(int l = 0;l < 26;l++){
                            cw[l] += cnt[x][j][l]+cnt[y][j][l];
                        }
                        x = px;
                        y = py;
                    }
                }
                for(int l = 0;l < 26;l++){
                    cw[l] += cnt[x][0][l]+cnt[y][0][l];
                }
                x = pa[x][0];
            }
            int lca = x;
            pathLen -= 2*depth[x];
            int maxCw = Arrays.stream(cw).max().getAsInt();
            answers[i++] = pathLen-maxCw;
        }
        return answers;
    }

    //边-节点-父节点，更新每个节点的深度
    private void dfs(List<int[]>[] g,int x,int fa){
        pa[x][0] = fa;
        for(int[] y : g[x]){
            if(y[0] != fa){
                cnt[y[0]][0][y[1]]=1;
                depth[y[0]] = depth[x]+1;
                dfs(g,y[0],x);
            }
        }
    }

    //返回x的第k个祖先
    public int getKAncestor(int x,int k){
        for(;k > 0 ;k &= (k-1)){
            x = pa[x][Integer.numberOfLeadingZeros(k)];
        }
        return x;
    }


}
