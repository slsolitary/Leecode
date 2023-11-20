import java.util.*;

/**
 * @author heyao
 * @date 2023-11-05 20:20
 */
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        for(int i = 0;i <= n;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0;i < m;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            edges[x].add(y);
            edges[y].add(x);
        }
        int st = input.nextInt();
        int target = input.nextInt();
        boolean[] used = new boolean[n+1];
        LinkedList<Integer> list = new LinkedList<>();
        used[st] = true;
        dfs(edges,st,target,used,list);
        if(res.size() <= 1){
            System.out.println(-1);
        }
        System.out.println(res.size()-1);
    }
    static HashSet<Integer> res = new HashSet<>();
    public static void dfs(ArrayList<Integer>[] edges, int st, int target, boolean[] used, LinkedList<Integer> list){
        if(st == target){
            for(int i : list){
                res.add(i);
            }
            return;
        }
        ArrayList<Integer> tmp = edges[st];
        for(int i = 0;i < tmp.size();i++){
            int next = tmp.get(i);
            if(used[next] == false){
                used[next] = true;
                list.add(next);
                dfs(edges,next,target,used,list);
                used[next]=false;
                list.removeLast();
            }
        }
    }
}
