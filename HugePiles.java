package classes;
import java.util.*;
public class HugePiles {

    public static int solve(int pile,int tar){
        if(pile==1) return -(int)1e7;
        int a=pile/2,b=(pile+1)/2;
        if(a==tar || b==tar) return 1;

        if(b>a) return 1+solve(b,tar);
        return 1+solve(a,tar);
    }

    public static int rec(int pile,int tar,HashMap<Integer,Integer> hm){
        if(pile==tar) return 1;
        if(pile==1) return Integer.MIN_VALUE;
        if(hm.containsKey(pile)) return hm.get(pile);

        int a=pile/2,b=(pile+1)/2;
        int left=rec(a,tar,hm);
        if(left>0) {
            hm.put(a,left+1);
            return left + 1;
        }
        int right=rec(b,tar,hm);
        if(right>0) {
            hm.put(b,right+1);
            return right + 1;
        }

        return left;
    }
    public static void iter(int pile,int tar){
        int maxi=pile,mini=pile;
        int time=0;
        boolean reach=false;

        while(maxi>=tar || mini>=tar){
            if(maxi==tar || mini==tar){
                reach=true;
                break;
            }
            maxi=(maxi+1)/2;mini=mini/2;
            time++;
        }
        if(!reach) time=-1;
        System.out.println(time);
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        HashMap<Integer,Integer> hm=new HashMap<>();
//        Arrays.fill(dp,-1);
        int n=sc.nextInt();

        while(n-- > 0){
            int pile=sc.nextInt(),tar=sc.nextInt();

            System.out.println(rec(pile,tar,hm));
        }
    }
}
