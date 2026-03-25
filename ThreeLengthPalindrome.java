package classes;

import java.util.*;

public class ThreeLengthPalindrome {

    public static void solve(String str){

        int len=str.length();

        int [] right=new int[26];
        int [] left=new int[26];

        for(char ch:str.toCharArray()){
            right[ch-'a']++;
        }

        int ans=0;

        for(char ch:str.toCharArray()){
            right[ch-'a']--;

            for(int i=0;i<26;i++){
                ans+=right[i]*left[i];
            }
            left[ch-'a']++;
        }

        System.out.println(ans);

    }
}
