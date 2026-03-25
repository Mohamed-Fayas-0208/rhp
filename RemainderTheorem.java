package classes.hackwithinfy;

import java.util.*;

public class RemainderTheorem {

    public static void solve(int [] a,int [] b){
        long ans=0;
        int mod=(int)1e9+7;
        PriorityQueue<Integer> ones=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> zeroes=new PriorityQueue<>();

        for(int i:a) ones.add(i);
        for(int i:b) zeroes.add(i);

        for(int i=0;i<a.length;i++){
            int one=ones.poll(),zero=zeroes.poll();

            while(one-->0){
                ans=((ans*2)+1)%mod;
            }

            while(zero-->0){
                ans=(ans*2)%mod;
            }

        }

        System.out.println(ans);

    }
}
