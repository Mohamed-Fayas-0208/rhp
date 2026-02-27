import java.util.*;
class Main{
    public static void solve(Scanner sc){
        String str = sc.nextLine();
        int flag = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            flag = flag | (1<<(ch-'a'));
        }
        
        System.out.println((flag==((1<<26) - 1))?"YES":"NO");
        

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        while(tc-->0){
            solve(sc);
        }
        sc.close();
    }
}