package work.xm0923;

import java.util.*;

/**
 * @author heyao
 * @date 2023-09-23 16:24
 */
public class Two {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        String[] split = s.split(",");
        //b->a
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];
        for(int i = 0;i < split.length;i++){
            int a = split[i].charAt(0)-'0';
            int b = split[i].charAt(2)-'0';
            inDegree[a]++;
            if(!adj.containsKey(b)){
                adj.put(b,new ArrayList<>());
            }
            adj.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(!adj.containsKey(cur)){
                continue;
            }
            List<Integer> list = adj.get(cur);
            for(int k : list){
                inDegree[k]--;
                if(inDegree[k] == 0){
                    queue.offer(k);
                }
            }
        }
        int ans = 1;
        for(int i = 0;i < n;i++){
            if(inDegree[i] != 0){
                ans = 0;
            }
        }
        System.out.println(ans);
    }
}
