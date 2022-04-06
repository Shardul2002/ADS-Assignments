
import java.util.*;
import java.lang.*;
import java.io.*;


public class MST {
    static  final int  V=5;
    int minkey(int key[],boolean mstset[]){
        int min=Integer.MAX_VALUE;
        int min_index=-1;

        for(int i=0;i<V;i++){
            if(mstset[i]==false && key[i]<min){
                min=key[i];
                min_index=i;
            }
        }
       return min_index;
    }

    void print(int parent[],int graph[][]){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    
    }

    void prims(int graph[][]){
        int parent[]= new int[V];
        boolean mstset[]=new boolean[V];
        int key[]=new int[V];
    
     

    for(int i=0;i<V;i++){
        key[i]=Integer.MAX_VALUE;
        mstset[i]=false;
    }

    key[0]=0;
    parent[0]=-1;

    for(int i=0;i<V-1;i++){
        int u=minkey(key, mstset);
        mstset[u]=true;

        for(int v=0;v<V;v++){
            if(graph[u][v]!=0 && mstset[v]==false && graph[u][v]<key[v]){
                   parent[v]=u;
                   key[v]=graph[u][v];
            }
        }
    }
    print(parent, graph);
}

public static void main(String[] args){
    MST t = new MST();
    int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                  { 2, 0, 3, 8, 5 },
                                  { 0, 3, 0, 0, 7 },
                                  { 6, 8, 0, 0, 9 },
                                  { 0, 5, 7, 9, 0 } };

    // Print the solution
    t.prims(graph);
}

}
