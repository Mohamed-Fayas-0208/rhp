package classes.hackwithinfy;

import java.util.ArrayList;
import java.util.*;

public class BeautifulTree {
    public static final int mod=(int)1e9+7;
    public static int rec(int node,int [] colors,ArrayList<List<Integer>> adj,HashSet<Integer> vis,int [] dp){
        if(dp[node]!=-1) return dp[node];
        vis.add(colors[node-1]);
        long maxi=0;
        for(int adjacent:adj.get(node)){
            maxi=Math.max(maxi,rec(adjacent,colors,adj,vis,dp));
        }

        if(vis.contains(colors[node-1])){
            maxi++;
            vis.remove(colors[node-1]);
        }


        int ans=(int)(maxi%mod);
        return dp[node]=ans;
    }

    public static void solve(int [] parents,int [] colors,int [] queries){
        ArrayList<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=parents.length;i++) adj.add(new ArrayList<>());

        for(int i=0;i<parents.length;i++){
            int curr=i+1;
            adj.get(parents[i]).add(curr);
        }

        int [] dp=new int[parents.length+1];
        Arrays.fill(dp,-1);
        HashSet<Integer> visColors=new HashSet<>();
        long ans=0;
        for(int i=0;i<queries.length;i++){
            ans+=rec(queries[i],colors,adj,visColors,dp);
            ans=ans%mod;
        }

        System.out.println(ans);

    }
}
//Scanner sc=new Scanner(System.in);
//
//int len=sc.nextInt();
//
//int [] parents=new int[len];
//int [] colors=new int[len];
//
//        for(int i=0;i<len;i++){
//parents[i]=sc.nextInt();
//        }
//                for(int i=0;i<len;i++){
//colors[i]=sc.nextInt();
//        }
//
//int q= sc.nextInt();
//int [] queries=new int[q];
//
//        for(int i=0;i<q;i++){
//queries[i]= sc.nextInt();
//        }
//
//                BeautifulTree.solve(parents,colors,queries);
