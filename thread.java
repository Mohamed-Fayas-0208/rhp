import java.util.*;

public class thread{
   public static void main(String [] args){

        for(int i=0;i<200;i++){
            String str="Thread "+String.valueOf(i);
            Worker obj=new Worker(str);
            obj.start();
        }

   }
}
class Worker extends Thread{
    public void displayName(){
        System.out.println("Running "+Thread.currentThread().getName());
    }

    Worker(String str){ super(str);}
    public void run(){
        displayName();
    }
}