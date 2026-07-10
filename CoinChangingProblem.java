

package com.mycompany.coinchangingproblem;

import java.util.Arrays;
import java.util.Scanner;


public class CoinChangingProblem {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter number of coins:");
       int n = sc.nextInt();
       System.out.print("Enter the coins:");
       int A[]=new int[n];
       for(int i=0;i<n;i++)
       {
           A[i]=sc.nextInt();
       }
       Arrays.sort(A);
       System.out.print("Enter the amount:");
       int a = sc.nextInt();
       int r=0;
       for(int i=n-1;i>=0;i--)
       {
           if(a>=A[i])
           {
               int y = (a/A[i]);
               a = a%A[i];
               r+=y;
           }
       }
       System.out.print("The number coin needed is "+r);
    }
}
