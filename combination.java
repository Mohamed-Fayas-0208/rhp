import java.util.*;
public class combination {

    public static void fun(String str){
        int len=str.length();

        for(int i=1;i<=(1<<len)-1;i++){
            int ind=0,temp=i;

            while(temp>0){
                if((temp&1)==1){
                    System.out.print(str.charAt(ind));

                }
                temp>>=1;
                ind++;
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        String str="abcd";

        fun(str);
    }
    
}
