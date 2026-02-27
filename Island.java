import java.util.*;


public class Island{
    
    public static void dfs(int i,int j,char [][] mat,boolean [][] vis){

        vis[i][j]=true;

        int [] r={0,-1,0,1};
        int [] c={-1,0,1,0};
        for(int ind=0;ind<4;ind++){
            int cr=i+r[ind],cc=j+c[ind];

            if(cr>=0 && cr<mat.length && cc>=0 && cc<mat[0].length && !vis[cr][cc]
            && mat[cr][cc]=='1'){
                dfs(cr,cc,mat,vis);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int ans=0,r=grid.length,c=grid[0].length;
        boolean [][] vis=new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
        
    }

}