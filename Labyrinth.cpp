#include<bits/stdc++.h>
using namespace std;

struct node{
    int r,c;
};


void print(vector<char> &direction){
    for(int i=direction.size()-1;i>=0;i--){
        cout<<direction[i];
    }
}

void update(int x,int y,vector<vector<char>> &grid,vector<char> &direction){
    int i=x,j=y;
    while(true){
        char ch=grid[i][j];
        if(ch=='A') break;
        if(ch=='U'){ 
            i--;
            direction.push_back('D');
        }
        else if(ch=='D') {
            i++;
            direction.push_back('U');
            
        }
        else if(ch=='L') {
            j--;
            direction.push_back('R');
            
        }
        else {
            j++;
            direction.push_back('L');
            
        }

    }
}

int main(){
    
    int row[]={0,-1,0,1};
    int col[]={-1,0,1,0};
    char dir[]={'R','D','L','U'};

    int n,m,cnt=0;
    cin>>n>>m;
    vector<vector<char>> grid(n,vector<char>(m));
    bool reach=false;
    int startx=0,starty=0,endx=0,endy=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            
            cin>>grid[i][j];
            if(grid[i][j]=='A'){
                startx=i;starty=j;
            }
            if(grid[i][j]=='B'){
                endx=i;endy=j;
            }
        }
    }
    
    queue<node> q;
    
    q.push({startx,starty});
    
    
    while(!q.empty()){
        node curr=q.front();
        q.pop();
        int i=curr.r,j=curr.c;
        cnt++;
        for(int z=0;z<4;z++){
            int x=i+row[z],y=j+col[z];
            char ch=dir[z];
            if(x>=0 && y>=0 && x<n && y<m){
                char temp=grid[x][y];
                if(temp=='B'){
                    reach=true;
                    grid[x][y]=ch;
                    break;
                }
                if(temp=='.'){
                    grid[x][y]=ch;
                    q.push({x,y});
                }

            }
        }
        if(reach) break;
    }
    
   
    
    
    if(reach){
        vector<char> direction;
        update(endx,endy,grid,direction);
        cout<<"YES"<<endl;
        cout<<direction.size()<<endl;
        print(direction);
    }
    else{
        cout<<"NO"<<endl;
    }

}