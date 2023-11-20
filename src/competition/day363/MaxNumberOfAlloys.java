package competition.day363;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-17 11:00
 */
public class MaxNumberOfAlloys {
    public static void main(String[] args) {
//        int n = 3;
//        int k = 2;
        int n = 2;
        int k = 3;
        int budget = 15;
        List<List<Integer>> composition = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);list.add(1);
        composition.add(list);
        list.add(1);list.add(2);
        composition.add(list);
        list.add(1);list.add(1);
        composition.add(list);
//        list.add(1);list.add(1);list.add(1);
//        composition.add(list);
//        list.add(1);list.add(1);list.add(10);
//        composition.add(list);
        List<Integer> stock = new ArrayList<>();
//        stock.add(0);
//        stock.add(0);
//        stock.add(0);
        stock.add(1);
        stock.add(1);
        List<Integer> cost = new ArrayList<>();
//        cost.add(1);
//        cost.add(2);
//        cost.add(3);
        cost.add(5);
        cost.add(5);
        MaxNumberOfAlloys test = new MaxNumberOfAlloys();
        System.out.println(test.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }
    //composition k * n
    int ans = 0;
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
//        int res = 0;
//        for(int i = 0;i < k;i++){
//            List<Integer> stockTmp = new ArrayList<>();
//            for(int j = 0;j < n;j++){
//                stockTmp.add(stock.get(j));
//            }
//            List<Integer> tmp = composition.get(i);
//            ans = 0;
//            dfs(n,budget,tmp,stockTmp,cost);
//            res = Math.max(ans,res);
//        }
//        return res;
        //二分法
        long ans = 0;
        for(int i = 0;i < k;i++){
            List<Integer> tmp = composition.get(i);
            //l和r表示合金数的左右边界
            long l = 0,r = Integer.MAX_VALUE;
            while (l <= r){
                long mid = (l+r)/2;
                long b = 0;
                for(int j = 0;j < n;j++){
                    //need为冶炼mid份合金数所需要第j类材料need份
                    long need = tmp.get(j)*mid-stock.get(j);
                    need = need < 0 ? 0 : need;
                    b += need * cost.get(j);
                }
                if(b > budget){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }
            ans = Math.max(ans,r);
        }
        return (int)ans;
    }
    public void dfs(int n,int budget,List<Integer> comp, List<Integer> stock, List<Integer> cost){
        int money = 0;
        for(int i = 0;i < n;i++){
            if(stock.get(i) == 0){
                money += comp.get(i)*cost.get(i);
            }else if(stock.get(i) > comp.get(i)){
                stock.set(i,stock.get(i)-comp.get(i));
            }else {
                money += (comp.get(i)-stock.get(i))*cost.get(i);
                stock.set(i,0);
            }
            if(money > budget){
                return;
            }
        }
        if(budget >= money){
            ans++;
        }else{
            return;
        }
        dfs(n,budget-money,comp,stock,cost);
    }
}
