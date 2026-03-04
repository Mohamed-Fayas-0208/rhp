import java.util.*;
public class runnable {
    
    public static void main(String [] args){

        for(int i=0;i<200;i++){
            String str="Thread "+String.valueOf(i);
            Worker obj=new Worker();
            Thread th=new Thread(obj,str);
            th.start();
        }
    }

}

class Worker implements Runnable{
    public void displayName(){
        System.out.println("Running "+Thread.currentThread().getName());
    }

    public void run(){
        displayName();
    }
}
