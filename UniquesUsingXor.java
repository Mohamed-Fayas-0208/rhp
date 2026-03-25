package classes;

public class UniquesUsingXor {

    public static void findTwoUniques(int len,int []arr){

        int xor=0;
        for(int num:arr){
            xor^=num;
        }

        int pos=0,ones=0,zeroes=0;

        while((xor&1)!=1){
            pos++;
            xor>>=1;
        }

        for(int num:arr){
            if((num&(1<<pos))==0){
                zeroes^=num;
            }
            else{
                ones^=num;
            }
        }

        System.out.println(ones+" "+zeroes);

    }
}
