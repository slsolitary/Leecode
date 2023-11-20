package hot100;

import com.sun.source.doctree.EntityTree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String[] strs = {"bd","aacc"};
        List<List<String>> lists = test.groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        int[] count = new int[26];
        List<List<String>> ans = new ArrayList<>();
//        ArrayList<String> list;
        for(int i = 0;i < n;i++){
            String s = strs[i];
            int length = s.length();
            count = new int[26];
            //统计字符数
            for(int j = 0;j < length;j++){
                count[s.charAt(j)-'a']++;
            }
            //生成唯一的key
//            String key = "";
//            for(int k = 0;k < 26;k++){
//                if(count[k] > 0){
//                    key += String.valueOf((char)(k+'a'))+String.valueOf(count[k]);
//                }
//            }
            //判断当前哈希表中是否有该key
//            if(map.containsKey(key)){
//                list = map.get(key);
//                list.add(s);
//                map.put(key,list);
//            }else {
//                list = new ArrayList<>();
//                list.add(s);
//                map.put(key,list);
//            }
            StringBuffer sb = new StringBuffer();
            for(int k = 0;k < 26;k++){
                if(count[k] > 0){
                    sb.append((char)('a'+k));
                    sb.append(count[k]);
                }
            }
            String key = sb.toString();
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key,list);
        }
//        for(Map.Entry<String,ArrayList<String>> entry: map.entrySet()){
//            ans.add(entry.getValue());
//        }
//        return ans;
        return new ArrayList<List<String>>(map.values());
    }
}
