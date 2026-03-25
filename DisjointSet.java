package classes;

public class DisjointSet {
    int [] leader;
    int [] count;

    DisjointSet(int size){
        leader=new int[size];
        count=new int[size];
    }

    public int find(int ind){
        if(leader[ind]!=ind){
            leader[ind]=find(leader[ind]);
        }
        return ind;
    }

    public void merge(int a,int b){
        leader[a]=b;
    }

    public void insert(int a,int b){
        if(find(a)!=find(b)){
            merge(a,b);
        }
    }

}
