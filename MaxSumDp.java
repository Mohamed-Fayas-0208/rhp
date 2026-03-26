package classes;
import java.util.*;
public class MaxSumDp {

    public static int[] updateMax(int first,int second,int num){
        if(first<num){
            int temp=first;
            first=num;
            second=temp;
        }
        else if(second<num){
            second=num;
        }

        return new int[]{first,second};
    }
    public static void solve(int [][] mat){
        int n=mat.length,m=mat[0].length;

        int [][] dp=new int[n][m];
        int first=0,second=0;
        for(int i=0;i<m;i++){
            int num=mat[0][i];
            dp[0][i]=num;
            int [] maxs=updateMax(first,second,num);
            first=maxs[0];second=maxs[1];
        }

        for(int i=1;i<n;i++){
            int tf=0,ts=0;
            for(int j=0;j<m;j++){
                int temp=mat[i][j];
                if(dp[i-1][j]==first) temp+=second;
                else temp+=first;
                dp[i][j]=temp;
                int [] maxs=updateMax(tf,ts,temp);
                tf=maxs[0];ts=maxs[1];
            }
            first=tf;second=ts;
        }


        System.out.println(first);

    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(),m= sc.nextInt();

        int [][] mat=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }

        solve(mat);
    }
}
