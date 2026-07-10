

package com.mycompany.topological_sort;

import java.util.Scanner;
import java.util.Stack;

class DFS
{
    int g[][],n,col[],prev[],d[],f[],time;
    Stack<Integer> st = new  Stack<Integer>();
    DFS(int g[][],int n)
    {
        this.g = g;
        this.n = n;
        time = 0;
        col = new int[n];
        prev = new int[n];
        d = new int[n];
        f= new int[n];
        for(int i =0;i<n;i++)
        {
            prev[i]=-1;
        }
    }
    void dfsVisit(int u)
    {
        if(col[u]!=2)
        {
            col[u] = 1;
            d[u] = ++time;
            for(int v=0;v<n;v++)
            {
                if(g[u][v]==1 && col[v]==0)
                {
                    col[v]=1;
                    prev[v]=u;
                    dfsVisit(v);
                }
            }
            col[u]=2;
            st.push(u);
            f[u]=++time;
        }
    }
    void print()
    {
        System.out.println("Topological Sort:");
        while(!st.isEmpty())
        {
            int x = st.pop();
            switch(x)
            {
                case 0 -> System.out.println("UnderShort");
               case 1 -> System.out.println("Pant");
               case 2 -> System.out.println("Belt");
               case 3 -> System.out.println("Shirt");
                case 4 -> System.out.println("Tie");
               case 5 -> System.out.println("Jacket");
                case 6 -> System.out.println("Shocks");
               case 7 -> System.out.println("Shoes");
                case 8 -> System.out.println("Watch");
                default -> System.out.println("Invalid");
            }
           
        }
    }
}

public class Topological_Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element that are going to be arrange:");
        int n = sc.nextInt();
        int g[][] = new int[n][n];
         System.out.println("Enter the graph:");
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 g[i][j] = sc.nextInt();
             }
         }
         DFS dfs = new DFS(g,n);
         for(int i=0;i<n;i++)
         {
             dfs.dfsVisit(i);
         }
         dfs.print();
    }
}
/*
0 1 0 0 0 0 0 1 0
0 0 1 0 0 0 0 1 0
0 0 0 0 0 1 0 0 0
0 0 1 0 1 0 0 0 0
0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
*/