
package com.mycompany.bfs_shortest_path;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFS
{
    int g[][],prev[],dis[],color[],n;
    Queue<Integer>q=new LinkedList();
    BFS(int g[][],int n)
    {
        this.g = g;
        this.n = n;
        prev = new int[n];
        dis = new int [n];
        color = new int [n];
        for(int i=0;i<n;i++)
        {
           dis[i]= Integer.MAX_VALUE;
        }
    }
    void bfs(int s)
    {
        q.add(s);
        while(!q.isEmpty())
        {
            int u= q.remove();
            for(int v=0;v<n;v++)
            {
                if(g[u][v]==1 && color[v]==0)
                {
                    color[v] = 1;
                    prev[v]=u;
                    dis[v]= dis[u]+1;
                    q.add(v);
                }
            }
            color[u]=2;
            System.out.print(u+" ");
        }
    }
    void printpath(int s,int d)
    {
        if(s==d)
        {
           System.out.print(s); 
        }
        else
        {
            printpath(s,prev[d]);
             System.out.print("->"+d); 
        }
    }
}

public class BFS_Shortest_path {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
       System.out.println("Enter number of nodes:");
       int n = sc .nextInt();
    int g[][] = new int[n][n];
    System.out.println("Enter the graph:");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            g[i][j]= sc.nextInt();
        }
    }
    BFS b=new BFS(g,n);
    b.bfs(0);
    System.out.println();
    b.printpath(0, 7);
    System.out.println();
    }
}
/*
0 1 0 1 0 0 0 0
1 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0
1 0 0 0 1 0 0 1
0 0 0 1 0 1 0 1
0 0 0 0 1 0 1 0 
0 0 0 0 0 1 0 1
0 0 0 1 1 0 1 0
*/