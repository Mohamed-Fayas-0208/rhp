package classes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class MaximumSubarraySum {

    public static void main(String [] args){

        FastScanner sc=new FastScanner();

        int n=sc.nextInt();
//        int [] arr=new int[n];
//
//        for(int i=0;i<n;i++) arr[i]=sc.nextInt();

        long sum=0,ans=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            sum+=num;
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }

        }

        System.out.println(ans);

    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
