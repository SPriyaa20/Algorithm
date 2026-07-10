

package com.mycompany.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertex
{
    int n,d;
    Vertex(int n,int d)
    {
        this.n = n;
        this.d = d;
    }
}
class D
{
    int g[][],n,p[],d[],t[];

     PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt((Vertex v)->v.d));
     D(int g[][],int n)
     {
         this.g = g;
         this.n = n;
         d=new int[n];
         t = new int [n];
         p= new int[n];
         Arrays.fill(p, -1);
         Arrays.fill(d, Integer.MAX_VALUE);
         Arrays.fill(t, 0);
     }
     void d1(int s)
     {
         d[s]=0;
         pq.add(new Vertex (s,0));
      
         while(!pq.isEmpty())
      {
          Vertex current = pq.poll();
          int u = current.n;
          if(t[u]==1) continue;
          t[u]=1;
          
          System.out.print(u+" ");
          for(int v=0;v<n;v++)
          {
              if(t[v]==0 && g[u][v]>0 && d[v]>(d[u]+g[u][v]))
              {
                  p[v] = u;
                  d[v]=d[u]+g[u][v];
                 if(pq.contains(v))
                 {
                     pq.remove(v);
                      pq.add(new Vertex(v,d[v]));
                 }
                 else
                 {
                     pq.add(new Vertex(v,d[v]));
                 }
              }
             
          }
      }
     }
     void path(int r,int x)
     {
         if(r==x)
         {
             System.out.println(r);
             return;
         }
         path(r,p[x]);
         System.out.println("->"+x);
     }
}

public class Dijkstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of nodes:");
        n = sc.nextInt();
        int g[][] = new int[n][n];
        System.out.println("Enter the graph:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                g[i][j]=sc.nextInt();
            }
        }
        D d = new D(g,n);
        d.d1(0);
        d.path(0, 4);
        System.out.println();
        
    }
}
/*
0 10 0 5 0
0 0 1 3 0
0 0 0 0 6
0 2 9 0 2
2 0 4 0 0
*/