package classes;

import java.util.HashMap;

public class TwoGroups {

    public static void ZeroesAndOnes(int [] arr){

        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0,maxlen=0;

        hm.put(0,-1);

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum++;
            }
            else{
                sum--;
            }

            if(hm.containsKey(sum)){
                maxlen=Math.max(maxlen,i-hm.get(sum));
                continue;
            }

            hm.put(sum,i);

        }

        System.out.println(maxlen);
    }
}
