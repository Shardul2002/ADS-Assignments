import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static final int V=9;
    int mindistance(int dist[],Boolean splset[]){
        int min_index=-1;
        int min=Integer.MAX_VALUE;

        for(int v=0;v<V;v++){
            if(splset[v]==false && dist[v]<=min){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index;
    }

    void print(int dist[]){
        for(int i=0;i<V;i++){
            System.out.println(i+"\t\t"+dist[i]);
        }
    }

    void dijakstra_algo(int graph[][],int src){
        int dist[]=new int[V];
        Boolean splset[]=new Boolean[V];

        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            splset[i]=false;
        }

        dist[src]=0;
        for(int count=0;count<V-1;count++){
            int u=mindistance(dist, splset);
            splset[u]=true;
        
            for(int v=0;v<V;v++){
                if(!splset[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                         dist[v]=graph[u][v]+dist[u];
                }  
            }
            
        }
        print(dist);
    }

    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Main d=new Main();
        d.dijakstra_algo(graph, 0);
    }

}

