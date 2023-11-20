package work.hw;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author heyao
 * @date 2023-09-11 17:17
 */
public class Main {
    public static void main(String[] args) {
        FastScanner cin = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = cin.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            int p = cin.nextInt();
            a[i] = p;
        }
        for(int i = 0;i < n;i++){
            System.out.print(a[i]+" ");
        }
        out.flush();
    }
}

class FastScanner{
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in),16384);
        eat("");
    }

    public void eat(String s){
        st = new StringTokenizer(s);
    }

    public String nextLine(){
        try {
            return br.readLine();
        }catch (IOException e){
            return null;
        }
    }

    public boolean HashNext(){
        while (!st.hasMoreTokens()){
            String s = nextLine();
            if(s == null){
                return false;
            }
        }
        return true;
    }
    public String next(){
        HashNext();
        return st.nextToken();
    }
    public int nextInt(){
        return Integer.parseInt(next());
    }
}