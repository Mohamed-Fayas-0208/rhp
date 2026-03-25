package classes;


import java.util.Scanner;

public class RightMaximum{

    public static void rightMaximum(int len,int [] arr){
        int maxi=arr[0],ans=1;

        for(int i=1;i<len;i++){

            if(maxi<=arr[i]){
                maxi=arr[i];
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        while(n-- > 0){
            int len=sc.nextInt();
            int [] arr=new int[len];

            for(int i=0;i<len;i++) arr[i]=sc.nextInt();
            rightMaximum(len,arr);
        }

    }
}